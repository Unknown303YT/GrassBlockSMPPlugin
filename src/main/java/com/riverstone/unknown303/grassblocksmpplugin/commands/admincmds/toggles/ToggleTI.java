package com.riverstone.unknown303.grassblocksmpplugin.commands.admincmds.toggles;

import com.riverstone.unknown303.grassblocksmpplugin.multiclassreferencefiles.Variables;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ToggleTI implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equals("toggle")) {
            if (args.length == 2) {
                if (args[0] == "teamItems") {
                    if (args[1] == "enable") {
                        if (Variables.teamItemsStatus == "enabled") {
                            sender.sendMessage(Variables.pmPrefix + "Team Items are Already Enabled.");
                        } else {
                            Variables.teamItemsStatus = "enabled";
                            sender.sendMessage(Variables.pmPrefix + "Team Items Enabled");
                        }
                    } else if (args[1] == "disable") {
                            if (Variables.teamItemsStatus == "disabled") {
                                sender.sendMessage(Variables.pmPrefix + "Team Items are Already Disabled.");
                            } else {
                                Variables.teamItemsStatus = "disabled";
                                sender.sendMessage(Variables.pmPrefix + "Team Items Disabled");
                            }
                    }
                }
            }
        }
        return true;
    }
}
