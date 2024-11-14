package org.ferry.SlashCommands;


import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.ferry.SlashCommands.Commands.GreetCommand;
import org.ferry.interfaces.SlashCommand;

import java.util.ArrayList;

public  class SlashCommandsHandler extends ListenerAdapter {
    ArrayList<SlashCommand> commands = new ArrayList<SlashCommand>();
    ShardManager jda;
    public  SlashCommandsHandler(ShardManager jda) {
        this.jda = jda;
        //add salsh commands here
        commands.add(new GreetCommand());
        this.registerCommands();
    }

    public void registerCommands() {
        for (SlashCommand command : commands) {
            jda.getShardById(0).upsertCommand(command.getCommand()).queue(); // Registers the command
        }
    }
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        for (SlashCommand command : commands) {
            if (command.getCommand().getName().equals(event.getName())) {
                command.execute(event);
            }
        }
    }
}