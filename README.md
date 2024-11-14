# JDADiscordBot

![Java](https://img.shields.io/badge/Java-17-blue) ![JDA](https://img.shields.io/badge/JDA-5.2.0-green) ![License](https://img.shields.io/badge/License-MIT-brightgreen)

JDADiscordBot is a modular and flexible Discord bot built with the Java Discord API (JDA). The bot supports both prefix-based commands (e.g., `!ping`) and Discord's newer slash commands (e.g., `/ping`). This design allows for an organized and streamlined setup where you can easily add or modify commands to suit your server's needs.

## Features
- **Prefix-Based Commands**: Traditional commands activated by a customizable prefix, such as `!ping`.
- **Slash Commands**: Built-in support for Discord's modern slash commands (e.g., `/greet`).
- **Easy to Configure**: Use environment variables to configure sensitive information like the bot token and command prefix.
- **Scalable Command Management**: Handlers are in place to simplify adding and managing both prefix and slash commands.
- **Support Server**: Join our [support server](https://discord.gg/sakora) for assistance or to offer suggestions.

## Getting Started

### Prerequisites
- Java 17 or higher installed on your system.
- [Gradle](https://gradle.org/) for dependency management and building the project.

### Clone the Repository
To get started, clone the repository to your local machine.
```bash
git clone https://github.com/ferrymehdi/JDADiscordBot.git
cd JDADiscordBot
```
### Setting Up Environment Variables
Create a `.env` file in the root directory to securely store the bot's token and command prefix.

Sample `.env` file:
```
TOKEN=your_discord_bot_token_here
PREFIX=!
```

### Configuring Dependencies
JDADiscordBot relies on the following main dependencies:
- [JDA (Java Discord API)](https://github.com/DV8FromTheWorld/JDA) - Version 5.2.0 for connecting and interacting with Discord.
- [dotenv-java](https://github.com/cdimascio/dotenv-java) - For handling environment variables securely.


### Running the Bot
Once your environment variables are set up and dependencies are installed, you can start the bot using Gradle:
```bash
./gradlew run
```

## Bot Structure and Command Handling

JDADiscordBot has a clear structure for handling both prefix and slash commands. The bot is split into two main handlers:
- **PrefixCommandsHandler**: Handles commands prefixed by the customizable `PREFIX` (e.g., `!ping`).
- **SlashCommandsHandler**: Manages Discord's native slash commands (e.g., `/greet`).

### Adding Commands

#### Prefix Commands
1. Create a new class in `org.ferry.PrefixCommands.Commands` that implements `PrefixCommand`.
2. Implement the `execute` method to define the command's action.
3. Add your command to `PrefixCommandsHandler` by calling `addCommand(new YourCommand())`.

#### Slash Commands
1. Create a new class in `org.ferry.SlashCommands.Commands` that implements `SlashCommand`.
2. Implement the `execute` method and define the `getCommand` method to register the command with Discord.
3. Add your slash command to `SlashCommandsHandler` by calling `commands.add(new YourCommand())` in its constructor.

## Support and Community
If you have questions, encounter issues, or want to contribute, join our [support Discord server](https://discord.gg/sakora). We’re here to help and appreciate feedback.

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.

## Contributing
Feel free to fork this project, submit issues, or suggest enhancements. Contributions are welcome, and detailed pull requests will be reviewed as soon as possible.

---

Enjoy customizing and running JDADiscordBot for your Discord server!
