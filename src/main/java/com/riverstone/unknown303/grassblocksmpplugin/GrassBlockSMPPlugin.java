package com.riverstone.unknown303.grassblocksmpplugin;

import com.riverstone.unknown303.grassblocksmpplugin.commands.lrcmds.*;
//import com.riverstone.unknown303.grassblocksmpplugin.commands.toggles.DisableLRCmd;
//import com.riverstone.unknown303.grassblocksmpplugin.commands.toggles.EnableLRCmd;
//import com.riverstone.unknown303.grassblocksmpplugin.commands.toggles.NoClearLRCmd;
import com.riverstone.unknown303.grassblocksmpplugin.events.LifeEvents;
import com.riverstone.unknown303.grassblocksmpplugin.multiclassreferencefiles.Variables;
import com.riverstone.unknown303.grassblocksmpplugin.items.AdminItemsManager;
import com.riverstone.unknown303.grassblocksmpplugin.items.LeadersDefenceManager;
import com.riverstone.unknown303.grassblocksmpplugin.items.LifeItemsManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class GrassBlockSMPPlugin extends JavaPlugin {
    //public FileConfiguration config = this.getConfig();
    private void lifeConfigMethod() {
        File lifeConfigFile = new File(getDataFolder(), "lifeConfig.yml");
        FileConfiguration lifeConfig = YamlConfiguration.loadConfiguration(lifeConfigFile);
        try {
            lifeConfig.save(lifeConfigFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
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

        lifeConfigMethod();
        
        Bukkit.getLogger().info(Variables.logPrefix + "Starting GrassBlockSMP Custom Plugin...");
        Bukkit.getLogger().info(Variables.logPrefix + "Thank you to Unknown_303YT for making this for the server.");
        Bukkit.getLogger().info(Variables.logPrefix + "Enabling Leaders Defence... ");
        LeadersDefenceManager.init();
        Bukkit.getLogger().info(Variables.logPrefix + "Leaders Defence Enabled");

        Bukkit.getLogger().info(Variables.logPrefix + "Enabling Life Items... ");
        LifeItemsManager.init();
        Bukkit.getLogger().info(Variables.logPrefix + "Life Items Enabled");

        Bukkit.getLogger().info(Variables.logPrefix + "Enabling Admin Items... ");
        AdminItemsManager.init();
        Bukkit.getLogger().info(Variables.logPrefix + "Admin Items Enabled");
//        Objects.requireNonNull(getCommand("ncLR")).setExecutor(new NoClearLRCmd(this));
//        Objects.requireNonNull(getCommand("enableLR")).setExecutor(new EnableLRCmd(this));
//        Objects.requireNonNull(getCommand("disableLR")).setExecutor(new DisableLRCmd(this));
//        getServer().getPluginManager().registerEvents(new OffHandSwap(), this);
        getServer().getPluginManager().registerEvents(new LifeEvents(this), this);
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

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void getUniqueId(FileConfiguration lifeconfig) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            String uuid = player.getUniqueId().toString();
            lifeconfig.addDefault(uuid + "-lives", "7");
        }
    }

}

