package net.pen.telebow.listeners;

import net.pen.telebow.main.Telebow;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class TeleportBowEvent implements Listener {
  @EventHandler
  public void onHit(ProjectileHitEvent e) {
	  
	  
    if (e.getEntity() instanceof org.bukkit.entity.Arrow) {
    	
    	
      Player player = (Player)e.getEntity().getShooter();
      
      Location location = e.getEntity().getLocation();
      
	  if(player.getItemInHand().getItemMeta().getDisplayName().equals("§aTelebow")) {
		  
		  player.playSound(player.getLocation(), Sound.ENTITY_CAT_HISS, 1.0F, 1.0F);
		  player.teleport(location);
		  player.sendMessage(ChatColor.translateAlternateColorCodes('&', Telebow.getMainInstance().getConfig().getString("BowTeleport")));
    } 
  }
}}