package com.factions.grace.commands.impl.subcommand;

import com.factions.grace.GracePlugin;
import com.factions.grace.commands.CustomCommand;
import com.factions.grace.utils.TimeFormatter;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.util.concurrent.TimeUnit;

public class GraceSetTimeCommand extends CustomCommand {
    public GraceSetTimeCommand() {
        super("settime", "grace.admin", false, "");
    }

    @Override
    protected void onCommand(CommandSender commandSender, String[] arguments) {
        if (arguments.length != 1)
            return;


        if (arguments[0] == null) {
            commandSender.sendMessage("§cUtilize, /grace settime <tempo>");
            return;
        }

        int time = Integer.parseInt(arguments[0]);

        boolean isGraceActive = GracePlugin.getInstance().getConfig().getBoolean("settings.grace-enable");

        if (isGraceActive) {
            long highTime = System.currentTimeMillis() + TimeUnit.HOURS.toMillis(time);
            Bukkit.getOnlinePlayers().forEach(player -> {
                player.sendMessage("");
                player.sendMessage("§eO tempo do grace foi alterado para " + TimeFormatter.format(highTime - System.currentTimeMillis()));
                player.sendMessage("");
            });
        }

        GracePlugin.getInstance().getConfig().set("settings.grace-time", System.currentTimeMillis() + TimeUnit.HOURS.toMillis(time));
        GracePlugin.getInstance().saveConfig();
        commandSender.sendMessage("§aO Tempo do grace foi setado com sucesso.");
    }
}
