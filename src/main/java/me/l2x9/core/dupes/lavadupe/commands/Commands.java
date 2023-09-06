/*    */ package me.l2x9.core.dupes.lavadupe.commands;
/*    */ 
/*    */ import me.l2x9.core.L2X9RebootCore;
/*    */
import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ 
/*    */ public class Commands
/*    */   implements CommandExecutor {
/*    */   private L2X9RebootCore plugin;
/*    */
/*    */   public Commands(L2X9RebootCore instance) {
/* 14 */     this.plugin = instance;
/*    */   }
/*    */
/* 17 */   public static String PREFIX = "&6[&7&o&l2L2C&8&o&lLavaDupe&r&6]&r&7&r ";
/*    */
/*    */
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 21 */     if (!cmd.getName().equalsIgnoreCase("lavadupe"))
/* 22 */       return true;
/* 23 */     if (args.length == 0) {
/* 24 */       sender.sendMessage(ChatColor.translateAlternateColorCodes('&', String.valueOf(PREFIX) + "&cUsage: &l/ld reload"));
/* 25 */       return true;
/*    */     }
/* 27 */     if (args[0].equalsIgnoreCase("reload")) {
/* 28 */       if (!sender.hasPermission("ld.reload")) {
/* 29 */         sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
/* 30 */               String.valueOf(PREFIX) + "&cYou don't have permissions to run this command."));
/* 31 */         return true;
/*    */       }
/* 33 */       L2X9RebootCore.getInstance().reloadConfig();
/* 34 */       sender.sendMessage(ChatColor.translateAlternateColorCodes('&', String.valueOf(PREFIX) + "&aConfig reloaded!"));
/* 35 */       return true;
/*    */
/*    */   }
/*    */
          return false;
      }
  }
