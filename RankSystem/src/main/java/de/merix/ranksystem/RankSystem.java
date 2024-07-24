package de.merix.ranksystem;

import de.merix.ranksystem.commands.SetRankCommand;
import de.merix.ranksystem.listeners.RankListeners;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class RankSystem extends JavaPlugin {

    private static HashMap<UUID, PermissionAttachment> perms = new HashMap<>();

    private static RankSystem main;

    @Override
    public void onEnable() {
        main = this;

        getConfig().options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents(new RankListeners(), this);
        getCommand("setrank").setExecutor(new SetRankCommand());

    }

    @Override
    public void onDisable() {
        main = null;
        perms.clear();
    }

    public static RankSystem getMain() {
        return main;
    }

    public static HashMap<UUID, PermissionAttachment> getPerms() {
        return perms;
    }

}
