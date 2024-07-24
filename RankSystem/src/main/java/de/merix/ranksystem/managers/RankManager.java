package de.merix.ranksystem.managers;

import de.merix.ranksystem.RankSystem;
import de.merix.ranksystem.storage.Rank;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.UUID;

public class RankManager {

    public static void setRank(Rank rank, Player player) {
        RankSystem main = RankSystem.getMain();
        FileConfiguration config = main.getConfig();
        String uuid = player.getUniqueId().toString();

        if (config.contains(uuid)) {
            removePermissions(player);
        }
        config.set(uuid, rank.name());
        main.saveConfig();
        setPermissions(player);

        NametagManager.setNametag(player);
        NametagManager.newTag(player);
    }

    public static Rank getRank(Player player) {
        RankSystem main = RankSystem.getMain();
        FileConfiguration config = main.getConfig();

        return Rank.valueOf(config.getString(player.getUniqueId().toString()));
    }

    public static void setPermissions(Player player) {
        RankSystem main = RankSystem.getMain();
        FileConfiguration config = main.getConfig();
        UUID uuid = player.getUniqueId();
        Rank rank = getRank(player);

        PermissionAttachment attachment = player.addAttachment(main);
        RankSystem.getPerms().put(uuid, attachment);

        for (String perm : rank.getPermissions()) {
            attachment.setPermission(perm, true);
        }

    }

    public static void removePermissions(Player player) {
        RankSystem main = RankSystem.getMain();
        FileConfiguration config = main.getConfig();
        UUID uuid = player.getUniqueId();
        Rank rank = getRank(player);

        PermissionAttachment attachment = RankSystem.getPerms().get(uuid);
        if (attachment != null) {
            for (String perm : rank.getPermissions()) {
                attachment.unsetPermission(perm);
            }
        }
    }
}
