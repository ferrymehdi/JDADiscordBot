package org.ferry.PrefixCommands;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.ferry.PrefixCommands.Commands.CommandPing;
import org.ferry.interfaces.PrefixCommand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class PrefixCommandsHandler extends ListenerAdapter {
    private String prefix = Dotenv.load().get("PREFIX");
   private HashMap<String, PrefixCommand> commands = new HashMap<>();
   private HashMap<String, PrefixCommand> aliases = new HashMap<>();
   public PrefixCommandsHandler() {
       addCommand(new CommandPing());
   }
    public void addCommand(PrefixCommand command) {
        commands.put(command.getName(), command);
        for (String alias : command.getAliases()) {
            aliases.put(alias, command);
        }
    }
    public String getPrefix() {
        return prefix;
    }

    public HashMap<String, PrefixCommand> getCommands() {
        return commands;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot())
            return;
        if (!event.getMessage().getContentRaw().startsWith(prefix))
            return;

        String cxt = event.getMessage().getContentRaw().replaceFirst(prefix, "").trim();

        ArrayList<String> allcommands = new ArrayList<>(commands.keySet());
        ArrayList<String> allaliases = new ArrayList<>(aliases.keySet());

        allcommands.addAll(allaliases);

        Collections.sort(allcommands, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return Integer.compare(b.length(), a.length());
            }
        });
        for (String command : allcommands) {
            if (cxt.equals(command) || cxt.startsWith(command + " ")) {
                PrefixCommand cmd = commands.get(command);
                if (cmd == null)
                    cmd = aliases.get(command);
                if (cxt.equals(command))
                    cxt = cxt.replace(command, "");
                if (cxt.startsWith(command + " "))
                    cxt = cxt.replace(command + " ", "");
                if (cmd == null) return;
                cmd.execute(event, cxt, command, prefix);
                break;
            }
        }
    }
}