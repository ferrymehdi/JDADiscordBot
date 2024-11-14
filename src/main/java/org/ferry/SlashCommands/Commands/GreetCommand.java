package org.ferry.SlashCommands.Commands;


import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.internal.interactions.CommandDataImpl;
import org.ferry.interfaces.SlashCommand;

public class GreetCommand implements SlashCommand {
    private CommandData commandData = new CommandDataImpl("greet", "Greets a user")
            .addOptions(new OptionData(OptionType.STRING, "name", "The name of the user", true));
    public GreetCommand(){

    }
    @Override
    public void execute(SlashCommandInteractionEvent event) {
        String name = event.getOption("name").getAsString();
        event.reply("Hello, " + name + "!").queue();
    }

    @Override
    public CommandData getCommand() {
        return commandData;
    }
}