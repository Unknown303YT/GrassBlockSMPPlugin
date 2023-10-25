package com.riverstone.unknown303.grassblocksmpplugin;

import com.riverstone.unknown303.grassblocksmpplugin.commands.lrcmds.*;
//import com.riverstone.unknown303.grassblocksmpplugin.commands.toggles.DisableLRCmd;
//import com.riverstone.unknown303.grassblocksmpplugin.commands.toggles.EnableLRCmd;
//import com.riverstone.unknown303.grassblocksmpplugin.commands.toggles.NoClearLRCmd;
import com.riverstone.unknown303.grassblocksmpplugin.items.AdminItemsManager;
import com.riverstone.unknown303.grassblocksmpplugin.items.LeadersDefenceManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class GrassBlockSMPPlugin extends JavaPlugin {
    //public FileConfiguration config = this.getConfig();

    @Override
    public void onEnable() {
        // Plugin startup logic
//        List<String> comment1 = new ArrayList<String>();
//        comment1.add("Determines whether Leaders Defence is enabled or not. Can be enabled, disabled or no-clear");
//        config.setInlineComments("leadersdefence", comment1);
//        //config.getComments("leadersdefence").add("Determines whether Leaders Defence is enabled or not. Can be enabled, disabled or no-clear");
//        config.addDefault("leadersdefence", "enabled");
//        config.options().copyDefaults(true);
//        saveConfig();
//        reloadConfig();
//        boolean trueBoolean = true;
        Bukkit.getLogger().info(Variables.logPrefix + "Starting GrassBlockSMP Custom Plugin...");
        Bukkit.getLogger().info(Variables.logPrefix + "Thank you to Unknown_303YT for making this for the server.");
        Bukkit.getLogger().info(Variables.logPrefix + "Enabling Leaders Defence... ");
        LeadersDefenceManager.init();
        AdminItemsManager.init();
        Bukkit.getLogger().info(Variables.logPrefix + "Leaders Defence Enabled");
//        Objects.requireNonNull(getCommand("ncLR")).setExecutor(new NoClearLRCmd(this));
//        Objects.requireNonNull(getCommand("enableLR")).setExecutor(new EnableLRCmd(this));
//        Objects.requireNonNull(getCommand("disableLR")).setExecutor(new DisableLRCmd(this));
//        getServer().getPluginManager().registerEvents(new OffHandSwap(), this);
//        String configLRValue = String.valueOf(config.getDefaults().getString("leadersdefence"));
//        if (configLRValue == "enabled") {
//            Variables.leadersDefenceEnabled = 1;
//        } else {
//            if (configLRValue == "disabled") {
//                Variables.leadersDefenceEnabled = 0;
//            } else {
//                if (configLRValue == "no-clear") {
//                    Variables.leadersDefenceEnabled = 2;
//                } else {
//                    Bukkit.getLogger().info("§l§4Error: §fLeader's Defence Config Value can only be Enabled, Disabled or No-Clear. Please alert the plugin maker of the following information:\n§7Error: leadersDefenceEnabled == !0,1,2");
//                }
//            }
//        }

        Objects.requireNonNull(getCommand("getLDHelm")).setExecutor(new LDHCmd());
        Objects.requireNonNull(getCommand("getLDBoots")).setExecutor(new LDBCmd());
        Objects.requireNonNull(getCommand("getLDChestplate")).setExecutor(new LDCCmd());
        Objects.requireNonNull(getCommand("getLDLeggings")).setExecutor(new LDLCmd());
        Objects.requireNonNull(getCommand("getLDSet")).setExecutor(new LDSCmd());
//        Objects.requireNonNull(getCommand("getKickSword")).setExecutor(new KickSword());
        //Bukkit.getBanList(BanList.Type.NAME).addBan("Unknown_303YT", "§4§lYou Have Lost All Your Lives.\n§r§fYou can be unbanned by a player using the Beacon of Mercy.", null, "console");
        //Bukkit.getBanList(BanList.Type.NAME).pardon("Unknown_303YT");

//        loopcmd();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

//    public void loopCmd() {
//        Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
//            @Override
//            public void run(){
//              try {
//                  wait(60000);
//              } catch (InterruptedException e) {
//                  throw new RuntimeException(e);
//              }
//              while (true) {
//                    if (Variables.leadersDefenesEnabled == 0) {
//                        for (Player player : Bukkit.getOnlinePlayers()) {
//                            player.getInventory().removeItem(LeadersDefenceManager.leadersHat);
//                            player.getInventory().removeItem(LeadersDefenceManager.leadersShirt);
//                            player.getInventory().removeItem(LeadersDefenceManager.leadersPants);
//                            player.getInventory().removeItem(LeadersDefenceManager.leadersShoes);
//                            try {
//                                wait(60000);
//                            } catch (InterruptedException e) {
//                                throw new RuntimeException(e);
//                            }
//                        }
//                    }
//                }
//            }
//        });
//    }
}

