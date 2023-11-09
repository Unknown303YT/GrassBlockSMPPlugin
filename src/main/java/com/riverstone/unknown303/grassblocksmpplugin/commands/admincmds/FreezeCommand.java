package com.riverstone.unknown303.grassblocksmpplugin.commands.admincmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class FreezeCommand implements CommandExecutor, Listener {

    private static final ArrayList<Player> frozenPlayers = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (args.length == 2) {
            Player target = Bukkit.getPlayer(args[1]);
            if (args[0] == "freeze") {
                if (target == null) {
                    sender.sendMessage(ChatColor.DARK_RED + "Player Not Online or Not Real. Usage: ");
                    sender.sendMessage(ChatColor.GRAY + "/frz [<freeze> or <unfreeze>] <playerUsername>");
                }
                assert target != null;
                if (!frozenPlayers.contains(target)) {
                    frozenPlayers.add(target);
                    sender.sendMessage(ChatColor.GREEN + "You Have Frozen " + target.getDisplayName());
                    target.sendMessage(ChatColor.RED + "You Have Been Frozen By Staff!");
                } else {
                    if (frozenPlayers.contains(target)) {
                        sender.sendMessage(ChatColor.DARK_GREEN + "Player Already Frozen. Use "
                        + ChatColor.GRAY + "/frz <unfreeze> <playerUsername>" + ChatColor.DARK_GREEN + " to unfreeze them");
                    } else {
                        sender.sendMessage(ChatColor.DARK_RED + "Error: Player neither in nor out of ArrayList Frozen Players.");
                        sender.sendMessage(ChatColor.DARK_RED + "Please Alert The Plugin Maker.");
                    }
                }
            } else {
                if (args[0] == "unfreeze") {
                    if (target == null) {
                        sender.sendMessage(ChatColor.DARK_RED + "Player Not Online or Not Real. Usage: ");
                        sender.sendMessage(ChatColor.GRAY + "/frz [<freeze> or <unfreeze>] <playerUsername>");
                    }
                    assert target != null;
                    if (frozenPlayers.contains(target)) {
                        frozenPlayers.remove(target);
                        sender.sendMessage(ChatColor.GREEN + "You Have UnFrozen " + target.getDisplayName());
                        target.sendMessage(ChatColor.GREEN + "You Have Been UnFrozen By Staff!");
                    } else {
                        if (!frozenPlayers.contains(target)) {
                            sender.sendMessage(ChatColor.DARK_GREEN + "Player Already UnFrozen. Use "
                                    + ChatColor.GRAY + "/frz <freeze> <playerUsername>" + ChatColor.DARK_GREEN + " to freeze them");
                        } else {
                            sender.sendMessage(ChatColor.DARK_RED + "Error: Player neither in nor out of ArrayList Frozen Players.");
                            sender.sendMessage(ChatColor.DARK_RED + "Please Alert The Plugin Maker.");
                        }
                    }

                } else {
                    sender.sendMessage(ChatColor.DARK_RED + "Error In Argument 1 Value: Must Be freeze or unfreeze, lowercase. Usage: ");
                    sender.sendMessage(ChatColor.GRAY + "/frz [<freeze> or <unfreeze>] <playerUsername>");
                }
            }
        } else {
            sender.sendMessage(ChatColor.DARK_RED + "Error In Arguments Length: Must Be Have 2 Arguments. Usage: ");
            sender.sendMessage(ChatColor.GRAY + "/frz [<freeze> or <unfreeze>] <playerUsername>");
        }

        return true;
    }

    @EventHandler
    void onPlayerMove(PlayerMoveEvent event) {
        Player target = event.getPlayer();
        if (frozenPlayers.contains(target)) {
            event.setCancelled(true);
            target.sendMessage(ChatColor.RED + "You Have Been Frozen By Staff And Cannot Move!");
        }
    }

    @EventHandler
    void onPlayerHarvest(PlayerHarvestBlockEvent event) {
        Player target = event.getPlayer();
        if (frozenPlayers.contains(target)) {
            event.setCancelled(true);
            target.sendMessage(ChatColor.RED + "You Have Been Frozen By Staff And Cannot Break Blocks!");
        }
    }

    @EventHandler
    void onPlayerPlace(PlayerInteractEvent event) {
        Player target = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (frozenPlayers.contains(target)) {
                event.setCancelled(true);
                target.sendMessage(ChatColor.RED + "You Have Been Frozen By Staff And Cannot Place Blocks!");
            }
        }
    }
}
