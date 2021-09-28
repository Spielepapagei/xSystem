package de.spielepapagei.commands;

import de.spielepapagei.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;

public class NavigatorCommand implements CommandExecutor {

    public static Inventory Navigator;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "Du bist Kein Spieler!");
            return false;
        }
        Nav();
        player.openInventory(Navigator);
        return true;
    }

    private void Nav() {
        Navigator = Bukkit.createInventory(null, 9, ChatColor.DARK_GRAY.toString() + ChatColor.BOLD + "» " + ChatColor.GREEN + "Navigator");

        Navigator.setItem(2, new ItemBuilder(Material.REDSTONE)
                 .displayname(ChatColor.GREEN + "Redstone World")
                 .lore("",ChatColor.GRAY + "Das ist die Redstone World")
                 .flag(ItemFlag.HIDE_ATTRIBUTES)
                 .build());
        Navigator.setItem(4, new ItemBuilder(Material.NETHER_STAR)
                 .displayname(ChatColor.GOLD + "Lobby")
                 .lore("",ChatColor.GRAY + "Das ist die lobby")
                 .flag(ItemFlag.HIDE_ATTRIBUTES)
                 .build());
        Navigator.setItem(6, new ItemBuilder(Material.MINECART)
                 .displayname(ChatColor.DARK_BLUE + "Minekart")
                 .lore("",ChatColor.GRAY + "Ein Kart game",ChatColor.DARK_GRAY + "by " + ChatColor.BLUE + "Spielpapagei.de")
                 .flag(ItemFlag.HIDE_ATTRIBUTES)
                 .build());
    }

}
