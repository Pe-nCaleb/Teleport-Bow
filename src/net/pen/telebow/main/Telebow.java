package net.pen.telebow.main;

import net.pen.telebow.commands.TelebowCMD;
import net.pen.telebow.listeners.TeleportBowEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Telebow extends JavaPlugin {
  private static Telebow mainInstance;
  
  public void onEnable() {
    getCommand("Bow").setExecutor((CommandExecutor)new TelebowCMD(this));
    Bukkit.getPluginManager().registerEvents((Listener)new TeleportBowEvent(), (Plugin)this);
    getConfig().options().copyDefaults();
    saveDefaultConfig();
    mainInstance = this;
  }
  
  public static Telebow getMainInstance() {
    return mainInstance;
  }
  
  public void onDisable() {}
}
