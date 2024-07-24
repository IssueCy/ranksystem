package de.merix.ranksystem.listeners;

import de.merix.ranksystem.RankSystem;
import de.merix.ranksystem.managers.NametagManager;
import de.merix.ranksystem.managers.RankManager;
import de.merix.ranksystem.storage.Rank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class RankListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        RankSystem main = RankSystem.getMain();
        FileConfiguration config = main.getConfig();
        Player player = e.getPlayer();
        String uuid = player.getUniqueId().toString();

        if (!config.contains(uuid)) {
            RankManager.setRank(Rank.MEMBER, player);
        } else {
            RankManager.removePermissions(player);
            RankManager.setPermissions(player);
        }

        NametagManager.setNametag(player);
        NametagManager.newTag(player);

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        NametagManager.removeTag(e.getPlayer());
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        String message = e.getMessage();
        String name =  player.getName();

        e.setCancelled(true);
        Bukkit.broadcastMessage(RankManager.getRank(player).getPrefix() + name + " » " + ChatColor.WHITE + message);

    }
}

















