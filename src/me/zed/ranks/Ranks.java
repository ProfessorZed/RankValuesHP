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

import java.util.ArrayList;
import java.util.List;

public class Ranks extends JavaPlugin implements Listener {

    static List<String> activate = new ArrayList<>();
    static List<String> selected = new ArrayList<>();
    static List<String> karma50 = new ArrayList<>();
    static List<String> karma100 = new ArrayList<>();

    static String mvp = "§b[MVP§4+§b] ";

    public static Plugin plugin;

    public void onEnable() {
        plugin = this;
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getServer().getPluginManager().registerEvents(new openInv(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new chestClicks(this), this);

        activate.add("§6§oClick to activate!");
        selected.add("§2§oCurrently Selected!");
        karma50.add("§5Karma Required: 50,000");
        karma100.add("§5Karma Required: 100,000");
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
