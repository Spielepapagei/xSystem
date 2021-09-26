package de.spielepapagei.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.*;

public class GamemodeCommand implements CommandExecutor, TabCompleter {

    private static final String[] COMMANDS = { "Survival", "Creative", "Adventure", "Spectator", "0", "1", "2", "3"};

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Du bist Kein Spieler!");
            return false;
        }
        if(args.length == 0) {
            sendUsage(sender);
            return true;
        }
        Player player = (Player) sender;
        switch (args[0].toUpperCase()) {
            case "0", "S", "SURVIVAL" -> {
                if (player.getGameMode() == GameMode.SURVIVAL) {
                    player.sendMessage(ChatColor.RED + "Du bist bereits im " + ChatColor.BLUE + "SURVIVAL");
                } player.setGameMode(GameMode.SURVIVAL);
            }
            case "1", "C", "CREATIVE" -> {
                if (player.getGameMode() == GameMode.CREATIVE) {
                    player.sendMessage(ChatColor.RED + "Du bist bereits im " + ChatColor.BLUE + "CREATIVE");
                } player.setGameMode(GameMode.CREATIVE);
            }
            case "2", "A", "ADVENTURE" -> {
                if (player.getGameMode() == GameMode.ADVENTURE) {
                    player.sendMessage(ChatColor.RED + "Du bist bereits im " + ChatColor.BLUE + "ADVENTURE");
                } player.setGameMode(GameMode.ADVENTURE);
            }
            case "3", "P", "SPECTATOR" -> {
                if (player.getGameMode() == GameMode.SPECTATOR) {
                    player.sendMessage(ChatColor.RED + "Du bist bereits im " + ChatColor.BLUE + "SPECTATOR");
                } player.setGameMode(GameMode.SPECTATOR);
            }
            default -> sendUsage (sender);
        }
        return false;
    }

    private void sendUsage(CommandSender sender) {
        sender.sendMessage(ChatColor.GRAY + "Verwendung" + ChatColor.DARK_GRAY + ": " + ChatColor.BLUE + "/gm <0,1,2,3>");
    }

    //### Auto Complete ###
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        final List<String> completions = new ArrayList<>();
        StringUtil.copyPartialMatches(args[0], Arrays.asList(COMMANDS), completions);
        Collections.sort(completions);
        return completions;
    }
}
