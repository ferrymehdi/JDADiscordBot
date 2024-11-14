package org.ferry.PrefixCommands.Commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.ferry.interfaces.PrefixCommand;

import java.util.ArrayList;

public class CommandPing implements PrefixCommand {
    private static String name = "ping";
    private static String description = "Get my ping to Discord";
    private static String usage = "ping";
    private static ArrayList<String> aliases = new ArrayList<>();
    public CommandPing() {
        aliases.add("pong");
        aliases.add("ping pong");
    }
    @Override
    public void execute(MessageReceivedEvent event, String cxt, String command, String prefix) {
        event.getMessage().reply("Pong!").queue();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getUsage() {
        return usage;
    }

    @Override
    public ArrayList<String> getAliases() {
        return aliases;
    }

}