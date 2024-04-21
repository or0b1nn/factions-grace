package com.factions.grace.commands.impl;

import com.factions.grace.GracePlugin;
import com.factions.grace.commands.impl.subcommand.*;
import com.factions.grace.commands.CustomCommand;
import com.factions.grace.utils.TimeFormatter;
import org.bukkit.command.CommandSender;

public class GraceCommand extends CustomCommand {

    public GraceCommand() {
        super("grace", null, false, "grace");

        registerSubCommands(
                new GraceStartCommand(),
                new GraceStopCommand(),
                new GraceSetTimeCommand()
        );
    }

    public void onCommand(CommandSender commandSender, String[] strings) {
        boolean isGraceActive = GracePlugin.getInstance().getConfig().getBoolean("settings.grace-enable");
        long time = GracePlugin.getInstance().getConfig().getLong("settings.grace-time");

        if (isGraceActive) {
            commandSender.sendMessage("");
            commandSender.sendMessage("§eFaltam "  + TimeFormatter.format(time - System.currentTimeMillis()) + " para acabar o grace.");
            commandSender.sendMessage("");
            return;
        }

        commandSender.sendMessage("§cO grace não está ativo...");
    }
}
