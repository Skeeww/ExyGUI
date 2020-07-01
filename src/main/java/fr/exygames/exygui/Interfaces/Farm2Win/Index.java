package fr.exygames.exygui.Interfaces.Farm2Win;

import fr.exygames.exygui.Main;
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

    private HashMap<Integer, List<Object>> spawners = new HashMap<>();
    private HashMap<Integer, List<Object>> kits = new HashMap<>();
    private HashMap<Integer, List<Object>> grades = new HashMap<>();

    public Index(Player player){
        this.player = player;
        this.inventory = Bukkit.createInventory(player, 54, ChatColor.GOLD + "" + ChatColor.BOLD + "Farm 2 Win");
        for(int i = 0; i < this.inventory.getSize(); i++){
            this.inventory.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7));
        }

        //  Slot Spawn

        new Gui();
        spawners.put(1, Arrays.asList(Gui.createItemGui(
                Material.MOB_SPAWNER,
                ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Spawner à Vache",
                ChatColor.LIGHT_PURPLE + "PRIX " + ChatColor.GOLD + ChatColor.UNDERLINE + "150 000 $"
        ), "zspawners add " + player.getName() + " cow 1", 150000d));
        spawners.put(2, Arrays.asList(Gui.createItemGui(
                Material.MOB_SPAWNER,
                ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Spawner à Cochon",
                ChatColor.LIGHT_PURPLE + "PRIX " + ChatColor.GOLD + ChatColor.UNDERLINE + "150 000 $"
        ), "zspawners add " + player.getName() + " pig 1", 150000d));
        spawners.put(3, Arrays.asList(Gui.createItemGui(
                Material.MOB_SPAWNER,
                ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Spawner à Zombie",
                ChatColor.LIGHT_PURPLE + "PRIX " + ChatColor.GOLD + ChatColor.UNDERLINE + "250 000 $"
        ), "zspawners add " + player.getName() + " zombie 1", 250000d));
        spawners.put(4, Arrays.asList(Gui.createItemGui(
                Material.MOB_SPAWNER,
                ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Spawner à Squelette",
                ChatColor.LIGHT_PURPLE + "PRIX " + ChatColor.GOLD + ChatColor.UNDERLINE + "250 000 $"
        ), "zspawners add " + player.getName() + " skeleton 1", 250000d));
        spawners.put(5, Arrays.asList(Gui.createItemGui(
                Material.MOB_SPAWNER,
                ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Spawner à Zombie Pigman",
                ChatColor.LIGHT_PURPLE + "PRIX " + ChatColor.GOLD + ChatColor.UNDERLINE + "350 000 $"
        ), "zspawners add " + player.getName() + " pigzombie 1", 350000d));
        spawners.put(6, Arrays.asList(Gui.createItemGui(
                Material.MOB_SPAWNER,
                ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Spawner à Blaze",
                ChatColor.LIGHT_PURPLE + "PRIX " + ChatColor.GOLD + ChatColor.UNDERLINE + "450 000 $"
        ), "zspawners add " + player.getName() + " blaze 1", 450000d));
        spawners.put(7, Arrays.asList(Gui.createItemGui(
                Material.MOB_SPAWNER,
                ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Spawner à Golem (INDISPONIBLE)",
                ChatColor.LIGHT_PURPLE + "PRIX " + ChatColor.GOLD + ChatColor.UNDERLINE + ChatColor.MAGIC + "450 000 $"
        ), "nan", 450000d));

        for(Map.Entry<Integer, List<Object>> entry : spawners.entrySet()){
            this.inventory.setItem(entry.getKey(), (ItemStack) entry.getValue().get(0));
        }

        //  Slot Kits

        kits.put(19, Arrays.asList(Gui.createItemGui(
                Material.BREWING_STAND_ITEM,
                ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Kit Druide",
                ChatColor.LIGHT_PURPLE + "PRIX " + ChatColor.GOLD + ChatColor.UNDERLINE + "300 000 $"
        ), "pex user " + player.getName() + " add essentials.kits.druide", 300000d));
        kits.put(20, Arrays.asList(Gui.createItemGui(
                Material.POTION,
                ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Kit Potions",
                ChatColor.LIGHT_PURPLE + "PRIX " + ChatColor.GOLD + ChatColor.UNDERLINE + "250 000 $"
        ), "pex user " + player.getName() + " add essentials.kits.potions", 250000d));
        kits.put(21, Arrays.asList(Gui.createItemGui(
                Material.TNT,
                ChatColor.RED + "" + ChatColor.BOLD + "Kit Explosif",
                ChatColor.LIGHT_PURPLE + "PRIX " + ChatColor.GOLD + ChatColor.UNDERLINE + "300 000 $"
        ), "pex user " + player.getName() + " add essentials.kits.explosif", 300000d));
        kits.put(22, Arrays.asList(Gui.createItemGui(
                Material.OBSIDIAN,
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Kit Construction",
                ChatColor.LIGHT_PURPLE + "PRIX " + ChatColor.GOLD + ChatColor.UNDERLINE + "200 000 $"
        ), "pex user " + player.getName() + " add essentials.kits.construction", 200000d));
        kits.put(23, Arrays.asList(Gui.createItemGui(
                Material.EMERALD_ORE,
                ChatColor.GREEN + "" + ChatColor.BOLD + "Kit Minerais",
                ChatColor.LIGHT_PURPLE + "PRIX " + ChatColor.GOLD + ChatColor.UNDERLINE + "250 000 $"
        ), "pex user " + player.getName() + " add essentials.kits.minerais", 250000d));
        kits.put(24, Arrays.asList(Gui.createItemGui(
                Material.EXP_BOTTLE,
                ChatColor.BLUE + "" + ChatColor.BOLD + "Kit XP",
                ChatColor.LIGHT_PURPLE + "PRIX " + ChatColor.GOLD + ChatColor.UNDERLINE + "200 000 $"
        ), "pex user " + player.getName() + " add essentials.kits.xp", 200000d));
        kits.put(25, Arrays.asList(Gui.createItemGui(
                Material.DIAMOND_HOE,
                ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Kit Farm",
                ChatColor.LIGHT_PURPLE + "PRIX " + ChatColor.GOLD + ChatColor.UNDERLINE + "250 000 $"
        ), "pex user " + player.getName() + " add essentials.kits.farm", 250000d));
        kits.put(31, Arrays.asList(Gui.createItemGui(
                Material.WATCH,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Kit Explorateur",
                ChatColor.LIGHT_PURPLE + "PRIX " + ChatColor.GOLD + ChatColor.UNDERLINE + "250 000 $"
        ), "pex user " + player.getName() + " add essentials.kits.explorateur", 250000d));

        for(Map.Entry<Integer, List<Object>> entry : kits.entrySet()){
            this.inventory.setItem(entry.getKey(), (ItemStack) entry.getValue().get(0));
        }

        //  Slot Grades

        grades.put(48, Arrays.asList(Gui.createItemGui(
                Material.IRON_SWORD,
                ChatColor.BLUE + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Grade Legionnaire",
                ChatColor.LIGHT_PURPLE + "PRIX " + ChatColor.GOLD + ChatColor.UNDERLINE + "500 000 $"
        ), "pex user " + player.getName() + " group set legionnaire", 500000d));
        grades.put(49, Arrays.asList(Gui.createItemGui(
                Material.GOLD_SWORD,
                ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Grade Centurion",
                ChatColor.LIGHT_PURPLE + "PRIX " + ChatColor.GOLD + ChatColor.UNDERLINE + "1 000 000 $"
        ), "pex user " + player.getName() + " group set centurion", 1000000d));
        grades.put(50, Arrays.asList(Gui.createItemGui(
                Material.DIAMOND_SWORD,
                ChatColor.DARK_RED + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Grade Empereur",
                ChatColor.LIGHT_PURPLE + "PRIX " + ChatColor.GOLD + ChatColor.UNDERLINE + "1 500 000 $"
        ), "pex user " + player.getName() + " group set empereur", 1500000d));

        for(Map.Entry<Integer, List<Object>> entry : grades.entrySet()){
            this.inventory.setItem(entry.getKey(), (ItemStack) entry.getValue().get(0));
        }

        //  Slot Argent
        this.inventory.setItem(53, Gui.createItemGui(
                Material.BARRIER,
                ChatColor.GOLD + "" + ChatColor.BOLD + "ARGENT",
                ChatColor.GREEN + "Solde: " + ChatColor.BLUE + "" + ChatColor.UNDERLINE + Main.getEco().getBalance(player) + ChatColor.RESET + "" + ChatColor.GREEN + "$"
        ));
    }

    public void run(){
        player.openInventory(inventory);
    }

    @EventHandler
    private void onClick(InventoryClickEvent e){
        try {
            if (e.getInventory().equals(inventory)) {
                e.setCancelled(true);
                for(Map.Entry<Integer, List<Object>> entry : spawners.entrySet()) {
                    if(e.getCurrentItem().equals(entry.getValue().get(0))){
                        if(entry.getValue().get(1).equals("nan")){
                            return;
                        }
                        Buy(player, (ItemStack) entry.getValue().get(0), (String) entry.getValue().get(1), (Double) entry.getValue().get(2));
                    }
                }
                for(Map.Entry<Integer, List<Object>> entry : kits.entrySet()) {
                    if(e.getCurrentItem().equals(entry.getValue().get(0))){
                        if(entry.getValue().get(1).equals("nan")){
                            return;
                        }
                        Buy(player, (ItemStack) entry.getValue().get(0), (String) entry.getValue().get(1), (Double) entry.getValue().get(2));
                    }
                }
                for(Map.Entry<Integer, List<Object>> entry : grades.entrySet()) {
                    if(e.getCurrentItem().equals(entry.getValue().get(0))){
                        if(entry.getValue().get(1).equals("nan")){
                            return;
                        }
                        Buy(player, (ItemStack) entry.getValue().get(0), (String) entry.getValue().get(1), (Double) entry.getValue().get(2));
                    }
                }
            }
        }catch (Exception ignore){
        }
    }
}
