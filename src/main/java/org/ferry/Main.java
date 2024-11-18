package org.ferry;

import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.ferry.PrefixCommands.PrefixCommandsHandler;
import org.ferry.SlashCommands.SlashCommandsHandler;

public class Main {
    static ShardManager shardManager;
    static Dotenv dotenv = Dotenv.load();
    public static void main(String[] args) {
        shardManager = DefaultShardManagerBuilder
                .createDefault(dotenv.get("TOKEN"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT,
                        GatewayIntent.GUILD_MEMBERS,
                        GatewayIntent.GUILD_VOICE_STATES,
                        GatewayIntent.GUILD_PRESENCES,
                        GatewayIntent.GUILD_MESSAGE_REACTIONS,
                        GatewayIntent.GUILD_MODERATION,
                        GatewayIntent.GUILD_MESSAGES)
                .build();
        shardManager.addEventListener(new SlashCommandsHandler(shardManager));
        shardManager.addEventListener(new PrefixCommandsHandler());

        
    }
}