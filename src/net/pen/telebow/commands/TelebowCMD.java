package net.pen.telebow.commands;

import net.pen.telebow.main.Telebow;
import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TelebowCMD implements CommandExecutor, Listener {
  Telebow plugin;
  
  public TelebowCMD(Telebow plugin) {
    this.plugin = plugin;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
    if (sender instanceof Player) {
      Player player = (Player)sender;
      if (player.hasPermission("bow.tp")) {
        ItemStack bow = new ItemStack(Material.BOW);
        bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 666);
        ItemMeta meta = bow.getItemMeta();
		meta.setDisplayName("§aTelebow");
        ArrayList<String> lore = new ArrayList<>();
		lore.add(" ");
		lore.add("§6Item Ability: Teleport Bow §l§eSHOOT");
		lore.add("§7Teleport §ato §7your arrow");
		lore.add("§7you and gain §a+50 §fSpeed");
		lore.add("§7for §a3 seconds§7.");
        meta.setLore(lore);
        bow.setItemMeta(meta);
        player.getInventory().addItem(new ItemStack[] { bow });
        player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW) });
      } else {
        System.out.println("You have no permissions");
      } 
      return true;
    } 
    return false;
  }
}