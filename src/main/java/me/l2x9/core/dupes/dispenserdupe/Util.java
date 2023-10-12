package me.l2x9.core.dupes.dispenserdupe;

import java.util.Random;

import me.l2x9.core.L2X9RebootCore;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;

public class Util
{
    private static Integer chance;
    
    public static void load() {
        L2X9RebootCore.getPlugin().saveDefaultConfig();
        if (L2X9RebootCore.getPlugin().getConfig().getBoolean("DispenserDupe.enable.dispenser")) {
            Bukkit.getServer().getPluginManager().registerEvents((Listener)new Dispenser(), (Plugin)L2X9RebootCore.getPlugin());
        }
        if (L2X9RebootCore.getPlugin().getConfig().getBoolean("DispenserDupe.enable.dropper")) {
            Bukkit.getServer().getPluginManager().registerEvents((Listener)new Dropper(), (Plugin)L2X9RebootCore.getPlugin());
        }
        Util.chance = L2X9RebootCore.getPlugin().getConfig().getInt("DispenserDupe.settings.probability");
    }
    
    public static Boolean chanceOf() {
        final Random r = new Random();
        final int g = r.nextInt(100);
        if (g <= Util.chance) {
            return true;
        }
        return false;
    }
}
