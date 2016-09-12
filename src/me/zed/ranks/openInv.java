package me.zed.ranks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class openInv implements Listener{

    Ranks plugin;

    openInv(Ranks plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void interact(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(e.getAction() == Action.LEFT_CLICK_AIR){
            if(p.getItemInHand() != null && p.getItemInHand().getType() == Material.DIAMOND){
                open(p, p.getInventory());
            }
        }
    }

    public void open(Player p, Inventory inventory){
        Inventory inv = Bukkit.createInventory(p, 9*4, "Colors");

        new BukkitRunnable(){
            int i = 0;
            int n = 16;
            int colors = 9;
            public void run() {
                i--;
                n--;
                colors--;
                if(i % -2 == 0){
                    ItemStack wool = new ItemStack(Material.WOOL, 1, (byte)n);
                    ItemMeta woolmeta = wool.getItemMeta();
                    woolmeta.setDisplayName("§" + colors + "Rank Colors");
                    wool.setItemMeta(woolmeta);
                    inv.setItem(12, wool);
                }
                if(n == 0 ){
                    n += 16;
                }
                if(colors <= 0){
                    colors = 9;
                }
            }
        }.runTaskTimer(plugin, 0, 0);

        p.openInventory(inv);
    }
}
