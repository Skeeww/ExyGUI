package fr.exygames.exygui.Utils;

import fr.exygames.exygui.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Gui {
    public static ItemStack createItemGui(final Material material, int quantity, short id, final String title, final String... lore){
        final ItemStack item_stack = new ItemStack(material, quantity, id);
        final ItemMeta item_meta = item_stack.getItemMeta();
        item_meta.setDisplayName(title);
        item_meta.setLore(Arrays.asList(lore));
        item_stack.setItemMeta(item_meta);
        return item_stack;
    }
    public static ItemStack createItemGui(final Material material, final String title, final String... lore){
        final ItemStack item_stack = new ItemStack(material);
        final ItemMeta item_meta = item_stack.getItemMeta();
        item_meta.setDisplayName(title);
        item_meta.setLore(Arrays.asList(lore));
        item_stack.setItemMeta(item_meta);
        return item_stack;
    }
    public static ItemStack createItemGui(final Material material, int quantity, final String title, final String... lore){
        final ItemStack item_stack = new ItemStack(material, quantity);
        final ItemMeta item_meta = item_stack.getItemMeta();
        item_meta.setDisplayName(title);
        item_meta.setLore(Arrays.asList(lore));
        item_stack.setItemMeta(item_meta);
        return item_stack;
    }
    public static void Buy(Player player, ItemStack item, String command, double price){
        final String item_name = item.getItemMeta().getDisplayName();
        if(Main.getEco().getBalance(player) >= price){
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            Main.getEco().withdrawPlayer(player, price);
            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Félicitation vous venez d'acheter " + item_name + " !");
            Main.getInstance().getServer().getConsoleSender().sendMessage("[ExyGUI] Achat de " + player.getDisplayName() + ": " + item_name + "(" + price + ")");
        }else{
            player.sendMessage(ChatColor.RED + "Vous n'avez pas assez d'argent pour acheter " + item_name + ChatColor.RED + " ! " + ChatColor.RESET + "(Solde: " + ChatColor.GREEN + Main.getEco().getBalance(player) + ChatColor.RESET + "$)");
        }
        player.closeInventory();
    }
}
