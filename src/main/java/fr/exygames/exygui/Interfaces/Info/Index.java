package fr.exygames.exygui.Interfaces.Info;

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

import java.util.*;

public class Index implements Listener {
    private Inventory inventory;
    private Player player;

    private HashMap<Integer, List<Object>> socials = new HashMap<>();

    public Index(Player player) {
        this.player = player;
        this.inventory = Bukkit.createInventory(player, 9, ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Informations");

        this.socials.put(0, Arrays.asList(Gui.createItemGui(
                Material.STAINED_GLASS,
                1,
                Short.parseShort("5"),
                ChatColor.GREEN + "" + ChatColor.BOLD + "ExyGames.fr",
                ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + "https://exygames.fr"
        ), ChatColor.BOLD + " ▶ " + ChatColor.GREEN + "Notre site internet : " + ChatColor.UNDERLINE + "" + ChatColor.GOLD + "https://exygames.fr"
        ));

        this.socials.put(1, Arrays.asList(Gui.createItemGui(
                Material.STAINED_GLASS,
                1,
                Short.parseShort("3"),
                ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Twitter",
                ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + "@exygamesmc"
        ), ChatColor.BOLD + " ▶ " + ChatColor.AQUA + "Notre Twitter : " + ChatColor.UNDERLINE + "" + ChatColor.GOLD + "https://twitter.com/exygamesmc"
        ));

        this.socials.put(2, Arrays.asList(Gui.createItemGui(
                Material.STAINED_GLASS,
                1,
                Short.parseShort("11"),
                ChatColor.BLUE + "" + ChatColor.BOLD + "Discord",
                ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + "https://discord.gg/qh2u726"
                ), ChatColor.BOLD + " ▶ " + ChatColor.BLUE + "Notre Discord : " + ChatColor.UNDERLINE + "" + ChatColor.GOLD + "https://discord.gg/qh2u726"
        ));

        this.socials.put(3, Arrays.asList(Gui.createItemGui(
                Material.STAINED_GLASS,
                1,
                Short.parseShort("1"),
                ChatColor.DARK_RED + "" + ChatColor.BOLD + "Forum",
                ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + "https://exygames.fr/forum"
                ), ChatColor.BOLD + " ▶ " + ChatColor.DARK_RED + "Notre Forum : " + ChatColor.UNDERLINE + "" + ChatColor.GOLD + "https://exygames.fr/forum"
        ));

        this.socials.put(4, Arrays.asList(Gui.createItemGui(
                Material.STAINED_GLASS,
                1,
                Short.parseShort("10"),
                ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Instagram (bientôt)",
                ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + "instagram.com"
                ), ChatColor.BOLD + " ▶ " + ChatColor.LIGHT_PURPLE + "Bientôt"
        ));

        this.socials.put(5, Arrays.asList(Gui.createItemGui(
                Material.STAINED_GLASS,
                1,
                Short.parseShort("11"),
                ChatColor.BLUE + "" + ChatColor.BOLD + "Facebook (bientôt)",
                ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + "facebook.com"
                ), ChatColor.BOLD + " ▶ " + ChatColor.BLUE + "Bientôt"
        ));

        this.socials.put(6, Arrays.asList(Gui.createItemGui(
                Material.STAINED_GLASS,
                1,
                Short.parseShort("14"),
                ChatColor.RED + "" + ChatColor.BOLD + "Youtube (bientôt)",
                ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + "youtube.com"
                ), ChatColor.BOLD + " ▶ " + ChatColor.RED + "Bientôt"
        ));

        for(Map.Entry<Integer, List<Object>> entry : socials.entrySet()){
            this.inventory.setItem(entry.getKey(), (ItemStack) entry.getValue().get(0));
        }

        run();
    }

    public void run() {
        player.openInventory(inventory);
    }

    @EventHandler
    private void onClick(InventoryClickEvent e){
        try {
            if (e.getInventory().equals(inventory)) {
                for(Map.Entry<Integer, List<Object>> entry : socials.entrySet()) {
                    if(e.getCurrentItem().equals(entry.getValue().get(0))){
                        player.closeInventory();
                        player.sendMessage((String) entry.getValue().get(1));
                    }
                }
                e.setCancelled(true);
            }
        }catch (Exception ignore){
        }
    }
}