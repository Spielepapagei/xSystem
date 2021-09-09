package de.spielepapagei.listener;

import de.spielepapagei.scoreboard.DefaultScoreboard;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.DARK_GREEN + " » " + ChatColor.DARK_GRAY + player.getName());

        player.sendMessage(ChatColor.GOLD + "Willkommen auf dem Server! \nViel Spaß und Vergnügen (^:");

        new DefaultScoreboard(player);
    }

}
