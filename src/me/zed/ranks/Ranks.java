package me.zed.ranks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Ranks extends JavaPlugin implements Listener {

    String mvp = ChatColor.AQUA + "[MVP" + ChatColor.RED + "+" + ChatColor.AQUA + "] ";

    public static Plugin plugin;

    public void onEnable() {
        plugin = this;
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getServer().getPluginManager().registerEvents(new openInv(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new chestClicks(this), this);
    }

    @EventHandler
    public void join(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.setDisplayName(mvp + p.getName());

        if (p.getInventory().contains(Material.DIAMOND)) {
            p.sendMessage(ChatColor.RED + "You already have a diamond.");
        } else {
            p.getInventory().addItem(new ItemStack(Material.DIAMOND));
            p.sendMessage(ChatColor.GREEN + "Granted a diamond.");
        }
    }
}
