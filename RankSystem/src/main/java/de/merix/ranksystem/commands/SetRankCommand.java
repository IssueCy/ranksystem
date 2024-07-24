package de.merix.ranksystem.commands;

import de.merix.ranksystem.managers.RankManager;
import de.merix.ranksystem.storage.Rank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetRankCommand implements CommandExecutor {


    //              /setrank <player> <rank>


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (player.isOp()) {
                if (args.length == 2) {
                    if (Bukkit.getPlayer(args[0]) != null) {
                        Player target = Bukkit.getPlayer(args[0]);


                        switch (args[1]) {
                            case "admin":
                                RankManager.setRank(Rank.ADMIN, target);
                                target.sendMessage("§aYou now have the rank: " + RankManager.getRank(target).getPrefix());
                                return true;

                            case "srdev":
                                RankManager.setRank(Rank.SRDEV, target);
                                target.sendMessage("§aYou now have the rank: " + RankManager.getRank(target).getPrefix());
                                return true;


                            case "dev":
                                RankManager.setRank(Rank.DEV, target);
                                target.sendMessage("§aYou now have the rank: " + RankManager.getRank(target).getPrefix());
                                return true;

                            case "mod":
                                RankManager.setRank(Rank.MOD, target);
                                target.sendMessage("§aYou now have the rank: " + RankManager.getRank(target).getPrefix());
                                return true;

                            case "con":
                                RankManager.setRank(Rank.CONTENT, target);
                                target.sendMessage("§aYou now have the rank: " + RankManager.getRank(target).getPrefix());
                                return true;

                            case "tteam":
                                RankManager.setRank(Rank.TTEAM, target);
                                target.sendMessage("§aYou now have the rank: " + RankManager.getRank(target).getPrefix());

                            case "member":
                                RankManager.setRank(Rank.MEMBER, target);
                                target.sendMessage("§aYou now have the rank: " + RankManager.getRank(target).getPrefix());
                                return true;

                            default:
                                player.sendMessage(ChatColor.RED + "Player not found");
                                player.sendMessage(ChatColor.RED + "Options for ranks are: admin, srdev, dev, mod, content, tteam, member");
                        }

                    } else {
                        player.sendMessage(ChatColor.RED + "Player not found");
                    }

                } else {
                    player.sendMessage(ChatColor.RED + "Usage: /setrank <user> <rank>");
                }

            }
            return false;
        }
        return true;
    }
}