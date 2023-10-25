package com.riverstone.unknown303.grassblocksmpplugin.datuse;

import com.riverstone.unknown303.grassblocksmpplugin.data.PlayerMemory;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerUtility {
    private static Map<String, PlayerMemory> playerMemory = new HashMap<>();

    public static PlayerMemory getPlayerMemory(Player p) {
        if (!playerMemory.containsKey(p.getUniqueId().toString())) {
            PlayerMemory m = new PlayerMemory();
            playerMemory.put(p.getUniqueId().toString(), m);
            return m;
        }
        return playerMemory.get(p.getUniqueId().toString());
    }

    public static void setPlayerMemory(Player p, PlayerMemory memory) {
        playerMemory.put(p.getUniqueId().toString(), memory);
    }
}
