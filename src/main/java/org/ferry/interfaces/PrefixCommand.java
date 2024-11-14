package org.ferry.interfaces;


import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;

public interface PrefixCommand {
    void execute(MessageReceivedEvent event, String cxt, String command, String prefix);

    String getName();

    String getDescription();

    String getUsage();

    default ArrayList<String> getExamples(){
        return new ArrayList<>();
    }

    // aliasses
    default ArrayList<String> getAliases() {
        return new ArrayList<>();
    }
}