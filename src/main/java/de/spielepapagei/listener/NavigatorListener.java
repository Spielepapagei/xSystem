package de.spielepapagei.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static de.spielepapagei.commands.NavigatorCommand.Navigator;

public class NavigatorListener implements Listener {

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if (e.getCurrentItem() == null) return;
        if (e.getClickedInventory() == Navigator) {
            return;
        } else
        e.setResult(Event.Result.DENY);
        Player p = (Player) e.getWhoClicked();
        if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
            p.sendMessage(ChatColor.GREEN + "Sending to Lobby");
        }
    }
}
