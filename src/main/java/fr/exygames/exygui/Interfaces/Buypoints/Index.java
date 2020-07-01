package fr.exygames.exygui.Interfaces.Buypoints;

import fr.exygames.exygui.Utils.Gui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static fr.exygames.exygui.Utils.Gui.Buy;

public class Index implements Listener {
    private Inventory inventory;
    private Player player;

    private HashMap<Integer, List<Object>> items = new HashMap<>();

    public Index(Player player) {
        this.inventory = Bukkit.createInventory(player, 9, ChatColor.BOLD + "" + ChatColor.DARK_GREEN + "Acheter des points Faction");
        this.player = player;
        items.put(1, Arrays.asList(Gui.createItemGui(
                Material.STONE_PICKAXE,
                ChatColor.DARK_PURPLE + "1 POINT FACTION",
                ChatColor.ITALIC + "PRIX: " + ChatColor.LIGHT_PURPLE + "20 000 $"
        ), "f points add " + player.getName() + " 1", 20000d));

        items.put(4, Arrays.asList(Gui.createItemGui(
                Material.IRON_PICKAXE,
                ChatColor.DARK_PURPLE + "3 POINTS FACTION",
                ChatColor.ITALIC + "PRIX: " + ChatColor.LIGHT_PURPLE + "55 000 $"
        ), "f points add " + player.getName() + " 3", 55000d));

        items.put(7, Arrays.asList(Gui.createItemGui(
                Material.DIAMOND_PICKAXE,
                ChatColor.DARK_PURPLE + "5 POINTS FACTION",
                ChatColor.ITALIC + "PRIX: " + ChatColor.LIGHT_PURPLE + "90 000 $"
        ), "f points add " + player.getName() + " 5", 90000d));

        for(Map.Entry<Integer, List<Object>> entry : items.entrySet()){
            inventory.setItem(entry.getKey(), (ItemStack) entry.getValue().get(0));
        }
    }

    public void run(){
        player.openInventory(inventory);
    }

    @EventHandler
    private void onClick(InventoryClickEvent e){
        try {
            if (e.getInventory().equals(inventory)) {
                e.setCancelled(true);
                for(Map.Entry<Integer, List<Object>> entry : items.entrySet()) {
                    if(e.getCurrentItem().equals(entry.getValue().get(0))){
                        Buy(player, (ItemStack) entry.getValue().get(0), (String) entry.getValue().get(1), (Double) entry.getValue().get(2));
                    }
                }
            }
        }catch (Exception ignore){
        }
    }
}