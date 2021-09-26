package de.spielepapagei.commands;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import de.spielepapagei.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ConnectCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "Du bist Kein Spieler!");
            return false;
        }
        if (args.length != 1) {
            sender.sendMessage(ChatColor.RED + "Syntax Error benutze /jump <SERVER>");
            return false;
        }
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(args[0]);

        sender.sendMessage(ChatColor.GREEN + "Connecting to " + args[0] + "...");
        player.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
        return true;
    }
}
