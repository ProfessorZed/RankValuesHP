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
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.List;

public class chestClicks implements Listener {

    Ranks plugin;
    chestClicks(Ranks plugin){
        this.plugin = plugin;
    }

    String aquaName = "§b[MVP§c+§b]";
    String greenName = "§2[MVP§c+§2]";

    @EventHandler
    public void chest(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        if(e.getCurrentItem().getType() == Material.WOOL && e.getInventory() != p.getInventory()){
            e.setCancelled(true);
            colorsInv(p, p.getInventory());
        }
        if(e.getCurrentItem().getItemMeta().getDisplayName() == greenName){
            Ranks.mvp = greenName;
        }
    }

    public void colorsInv(Player player, Inventory inventory){
        Inventory inv = Bukkit.createInventory(player, 9*4, "Rank Colors");
        addItems(inv);
        player.openInventory(inv);
    }

    public void addItems(Inventory inventory){
        ItemStack aqua = new ItemStack(Material.INK_SACK, 1, (byte)12);
        ItemMeta aquaMeta = aqua.getItemMeta();
        aquaMeta.setDisplayName(aquaName);
        aquaMeta.setLore(plugin.activate);
        aqua.setItemMeta(aquaMeta);

        inventory.setItem(10,aqua);

        ItemStack green = new ItemStack(Material.INK_SACK, 1, (byte)2);
        ItemMeta greenMeta = green.getItemMeta();
        greenMeta.setDisplayName(greenName);
        greenMeta.setLore(plugin.activate);
        green.setItemMeta(greenMeta);
        inventory.setItem(11, green);
    }
}
