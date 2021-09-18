package de.spielepapagei.scoreboard;

import de.spielepapagei.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class DefaultScoreboard extends ScoreboardBuilder {

    private int socialId;

    public DefaultScoreboard(Player player){
        super(player, ChatColor.BLUE + "     Spielepapagei#7353     ");

        //socialId = 0;
        //run();
    }


    @Override
    public void createScoreboard() {
        //MAX 64 ZEICHEN
        /*
        setScore(ChatColor.DARK_GRAY.toString(), 7);
        setScore(ChatColor.GRAY + "Dein Rang" + ChatColor.DARK_GRAY + ":", 6);

        if(player.isOp()) {
            setScore(ChatColor.RED + "Operator", 5);
        } else {
            setScore(ChatColor.GRAY + "Spieler", 5);
        }

        setScore(ChatColor.GRAY.toString(), 4);
        setScore(ChatColor.AQUA + "discord.gg/4XGwbxMf8P", 3);
        setScore(ChatColor.RED.toString(), 2);
        setScore(ChatColor.RED + Objects.requireNonNull(player.getAddress()).getHostName(), 1);
        setScore(ChatColor.AQUA.toString(), 0);
         */
    }

    @Override
    public void update() {
        switch (socialId) {
            case 0 -> setScore(ChatColor.AQUA + "discord.gg/4XGwbxMf8P", 3);
            case 1 -> setScore(ChatColor.BLUE + "Spielepapagei#7353", 3);
            case 2 -> setScore(ChatColor.DARK_PURPLE + "Spielepapagei.de", 3);
            case 3 -> setScore(ChatColor.DARK_GREEN + "play.spielepapagei.de", 3);
        }
    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                update();
                socialId++;
                if (socialId >= 4) {
                    socialId = 0;
                }
            }
        }.runTaskTimer(Main.getInstance(), 480, 20);
    }
}
