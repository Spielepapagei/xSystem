package de.spielepapagei.inventory;

import de.spielepapagei.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;

public class Navigator implements Listener {

    private final Inventory inv;

    public Navigator(int rows) {
        inv = Bukkit.createInventory(null, (rows * 9), ChatColor.DARK_GRAY.toString() + ChatColor.BOLD + " » " + ChatColor.GREEN + "Navigator - Wähle einen Server aus.");

        inv.setItem(4, new ItemBuilder(Material.GRASS_BLOCK)
                .displayname(ChatColor.DARK_PURPLE + "Creative")
                .lore("",ChatColor.GRAY + "Ein Crative Server!")
                .enchant(Enchantment.MENDING,1)
                .flag(ItemFlag.HIDE_ATTRIBUTES)
                .flag(ItemFlag.HIDE_ENCHANTS)
                .build());
    }

}
