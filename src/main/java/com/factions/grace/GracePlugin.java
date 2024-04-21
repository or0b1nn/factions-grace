package com.factions.grace;

import com.factions.grace.commands.CustomCommand;
import com.factions.grace.commands.impl.GraceCommand;
import com.factions.grace.listeners.PlayerListener;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

@Getter
public class GracePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.registerListeners();
        this.registerAllCommands();
    }

    private void registerAllCommands() {
        this.registerCommands(new GraceCommand());
    }

    private void registerListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new PlayerListener(), this);
    }

    @SneakyThrows
    private void registerCommands(CustomCommand... customCommands) {
        final Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
        commandMapField.setAccessible(true);

        final CommandMap commandMap = (CommandMap) commandMapField.get(Bukkit.getServer());

        for (CustomCommand customCommand : customCommands)
            commandMap.register(customCommand.getName(), customCommand);
    }

    public static GracePlugin getInstance() {
        return GracePlugin.getPlugin(GracePlugin.class);
    }
}