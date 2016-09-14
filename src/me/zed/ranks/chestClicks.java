package me.zed.ranks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class chestClicks implements Listener {

    Ranks plugin;
    chestClicks(Ranks plugin){
        this.plugin = plugin;
    }

    /*
    This is by far, the worst thing I have ever done.
     */

    String aquaName = "§b[MVP§c+§b] ";
    String greenName = "§2[MVP§c+§2] ";
    String blackName = "§0[MVP§c+§0] ";
    String blueName = "§1[MVP§c+§1] ";
    String whiteName = "§f[MVP§c+§f] ";
    String goldName = "§6[MVP§c+§6] ";

    ItemStack aqua = new ItemStack(Material.INK_SACK, 1, (byte)12);
    ItemStack green = new ItemStack(Material.INK_SACK, 1, (byte)2);
    ItemStack black = new ItemStack(Material.INK_SACK);
    ItemStack blue = new ItemStack(Material.INK_SACK, 1, (byte)4);
    ItemStack white = new ItemStack(Material.INK_SACK, 1, (byte)15);
    ItemStack gold = new ItemStack(Material.INK_SACK, 1, (byte)14);

    @EventHandler
    public void chest(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        if(e.getCurrentItem().getType() == Material.WOOL && e.getInventory() != p.getInventory()){
            e.setCancelled(true);
            colorsInv(p, p.getInventory());
        }
        if(e.getInventory().getTitle() == "Rank Colors"){
            e.setCancelled(true);
        }
        if(e.getInventory().getTitle() == "Rank Colors" && e.getCurrentItem().equals(aqua)){
            p.setDisplayName(aquaName + ChatColor.AQUA + p.getName());
            p.sendMessage("§eChanged Rank Title to " + aquaName + "§e!");
            setLores(green, black, blue, white, gold, aqua);
            e.getWhoClicked().closeInventory();
        }
        if(e.getInventory().getTitle() == "Rank Colors" && e.getCurrentItem().equals(green)){
            p.setDisplayName(greenName + ChatColor.AQUA + p.getName());
            p.sendMessage("§eChanged Rank Title to " + greenName + "§e!");
            setLores(aqua, black, blue, white, gold, green);
            e.getWhoClicked().closeInventory();
        }
        if(e.getInventory().getTitle() == "Rank Colors" && e.getCurrentItem().equals(black)){
            p.setDisplayName(blackName + ChatColor.AQUA + p.getName());
            p.sendMessage("§eChanged Rank Title to " + blackName + "§e!");
            setLores(green, aqua, blue, white, gold, black);
            e.getWhoClicked().closeInventory();
        }
        if(e.getInventory().getTitle() == "Rank Colors" && e.getCurrentItem().equals(blue)){
            p.setDisplayName(blueName + ChatColor.AQUA + p.getName());
            p.sendMessage("§eChanged Rank Title to " + blueName + "§e!");
            setLores(green, black, aqua, white, gold, blue);
            e.getWhoClicked().closeInventory();
        }
        if(e.getInventory().getTitle() == "Rank Colors" && e.getCurrentItem().equals(white)){
            p.setDisplayName(whiteName + ChatColor.AQUA + p.getName());
            p.sendMessage("§eChanged Rank Title to " + whiteName + "§e!");
            setLores(green, black, blue, aqua, gold, white);
            e.getWhoClicked().closeInventory();
        }
        if(e.getInventory().getTitle() == "Rank Colors" && e.getCurrentItem().equals(gold)){
            p.setDisplayName(goldName + ChatColor.AQUA + p.getName());
            p.sendMessage("§eChanged Rank Title to " + goldName + "§e!");
            setLores(green, black, blue, white, aqua, gold);
            e.getWhoClicked().closeInventory();
        }
    }

    public void colorsInv(Player player, Inventory inventory){
        Inventory inv = Bukkit.createInventory(player, 9*4, "Rank Colors");
        addItems(inv);
        player.openInventory(inv);
    }

    public void addItems(Inventory inventory){
        ItemMeta aquaMeta = aqua.getItemMeta();
        aquaMeta.setDisplayName(aquaName);
        aqua.setItemMeta(aquaMeta);

        ItemMeta greenMeta = green.getItemMeta();
        greenMeta.setDisplayName(greenName);
        green.setItemMeta(greenMeta);

        ItemMeta blackMeta = black.getItemMeta();
        blackMeta.setDisplayName(blackName);
        black.setItemMeta(blackMeta);

        ItemMeta blueMeta = blue.getItemMeta();
        blueMeta.setDisplayName(blueName);
        blue.setItemMeta(blueMeta);

        ItemMeta whiteMeta = white.getItemMeta();
        whiteMeta.setDisplayName(whiteName);
        white.setItemMeta(whiteMeta);

        ItemMeta goldMeta = gold.getItemMeta();
        goldMeta.setDisplayName(goldName);
        gold.setItemMeta(goldMeta);

        inventory.addItem(aqua, green, black, blue, white, gold);
    }

    public void setLores(ItemStack item1, ItemStack item2, ItemStack item3, ItemStack item4, ItemStack item5, ItemStack selected){
        ItemMeta item1meta = item1.getItemMeta();
        item1meta.setLore(Ranks.activate);
        item1.setItemMeta(item1meta);

        ItemMeta item2meta = item2.getItemMeta();
        item2meta.setLore(Ranks.activate);
        item2.setItemMeta(item2meta);

        ItemMeta item3meta = item3.getItemMeta();
        item3meta.setLore(Ranks.activate);
        item3.setItemMeta(item3meta);

        ItemMeta item4meta = item1.getItemMeta();
        item4meta.setLore(Ranks.activate);
        item4.setItemMeta(item4meta);

        ItemMeta item5meta = item5.getItemMeta();
        item5meta.setLore(Ranks.activate);
        item5.setItemMeta(item5meta);

        ItemMeta selectedMeta = selected.getItemMeta();
        selectedMeta.setLore(Ranks.selected);
        selected.setItemMeta(selectedMeta);
    }
}
