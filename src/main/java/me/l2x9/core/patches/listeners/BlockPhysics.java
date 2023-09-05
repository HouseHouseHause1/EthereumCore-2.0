package me.l2x9.core.patches.listeners;

import lombok.RequiredArgsConstructor;
import me.l2x9.core.patches.PatchManager;
import me.l2x9.core.util.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

/**
 * @author 254n_m
 * @since 2023/03/03 3:53 PM
 * This file was created as a part of L2X9RebootCore
 */
public class BlockPhysics implements Listener {
    private final PatchManager main;

    public BlockPhysics(final PatchManager main) {
        this.main = main;
    }

    @EventHandler
    public void onLiquid(BlockFromToEvent event) {
        int disableTPS = main.getConfig().getInt("BlockPhysics-disable-tps");
        if (Utils.getTPS() > disableTPS) return;
        event.setCancelled(event.getBlock().isLiquid());
    }
}
