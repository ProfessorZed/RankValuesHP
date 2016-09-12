package me.zed.ranks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class chestClicks implements Listener {

    List<String> lores = new ArrayList<>();

    Ranks plugin;
    chestClicks(Ranks plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void chest(InventoryClickEvent e) {
        e.setCancelled(true);
        Player p = (Player)e.getWhoClicked();
        if(e.getCurrentItem().getType() == Material.WOOL){
            colorsInv(p, p.getInventory());
        }
    }

    public void colorsInv(Player player, Inventory inventory){
        Inventory inv = Bukkit.createInventory(player, 9*2, "Rank Colors");

        player.openInventory(inv);
    }

    public void addWool(Inventory inventory){
        for(int i = 1; i <= 15; ++i){
            ItemStack wool = new ItemStack(Material.WOOL, 1, (byte)i);
            ItemMeta woolmeta = wool.getItemMeta();
        }
    }
}
