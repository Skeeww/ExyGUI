package fr.exygames.exygui.Utils;

import org.bukkit.Material;
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
}
