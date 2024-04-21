package com.factions.grace.commands.impl.subcommand;

import com.factions.grace.GracePlugin;
import com.factions.grace.commands.CustomCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class GraceStartCommand extends CustomCommand {
    public GraceStartCommand() {
        super("start", "grace.admin", false, "iniciar");
    }

    @Override
    protected void onCommand(CommandSender commandSender, String[] arguments) {
        if (arguments.length != 0)
            return;

        boolean isGraceActive = GracePlugin.getInstance().getConfig().getBoolean("settings.grace-enable");

        if (isGraceActive) {
            commandSender.sendMessage("§cO grace já está ativo...");
            return;
        }

        GracePlugin.getInstance().getConfig().set("settings.grace-enable", true);
        GracePlugin.getInstance().saveConfig();


        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendMessage("");
            player.sendMessage("§e O grace começou!");
            player.sendMessage("");
        });
    }
}
