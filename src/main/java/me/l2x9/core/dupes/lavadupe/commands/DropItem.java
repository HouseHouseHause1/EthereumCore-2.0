/*    */ package me.l2x9.core.dupes.lavadupe.commands;
/*    */
         import me.l2x9.core.L2X9RebootCore;
         import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerDropItemEvent;
/*    */ 
/*    */ public class DropItem
/*    */   implements Listener {
/*    */   private L2X9RebootCore plugin;
/*    */
/*    */   public DropItem(L2X9RebootCore instance) {
/* 13 */     this.plugin = instance;
/*    */   }
/*    */
/*    */   @EventHandler
/*    */   public void onItemDrop(PlayerDropItemEvent event) {
             if (plugin.getConfig().getBoolean("LavaDupe.Enabled", true)) {
/* 18 */     this.plugin.droppers.put(event.getItemDrop(), event.getPlayer());
/*    */   }
/*    */ }
       }

