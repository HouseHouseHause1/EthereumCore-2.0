package me.l2x9.core.dupes.dispenserdupe;

import me.l2x9.core.L2X9RebootCore;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.event.block.BlockDispenseEvent;
import java.util.ArrayList;
import org.bukkit.Location;
import java.util.List;
import org.bukkit.event.Listener;

public class Dropper implements Listener
{
    private List<Location> cldown;
    
    public Dropper() {
        this.cldown = new ArrayList<Location>();
    }
    
    @EventHandler
    public void onDispenser(final BlockDispenseEvent e) {
        if (!(e.getBlock().getState() instanceof org.bukkit.block.Dropper)) {
            return;
        }
        final Location _l = e.getBlock().getLocation();
        if (this.cldown.contains(_l)) {
            return;
        }
        if (Util.chanceOf()) {
            this.cldown.add(_l);
            e.getBlock().getWorld().dropItem(_l, e.getItem());
            Bukkit.getScheduler().runTaskLaterAsynchronously((Plugin)L2X9RebootCore.getPlugin(), () -> this.cldown.remove(_l), 20L * L2X9RebootCore.getPlugin().getConfig().getInt("DispenserDupe.settings.cooldown"));
        }
    }
}
