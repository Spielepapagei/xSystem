package de.spielepapagei;

import de.spielepapagei.commands.ConnectCommand;
import de.spielepapagei.commands.GamemodeCommand;
import de.spielepapagei.commands.NavigatorCommand;
import de.spielepapagei.inventory.BackpackManager;
import de.spielepapagei.commands.BackpackCommand;
import de.spielepapagei.listener.JoinListener;
import de.spielepapagei.listener.NavigatorListener;
import de.spielepapagei.listener.QuitListener;
import de.spielepapagei.utils.Config;
import de.spielepapagei.utils.Data;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    private static Main instance;

    private Config config;
    private Data data;
    private BackpackManager backpackManager;

    @Override
    public void onLoad() {
        instance = this;
        config = new Config();
        data = new Data();
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + " » Initialisiere xSystem");

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        //Listener
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinListener(),this);
        manager.registerEvents(new QuitListener(),this);
        manager.registerEvents(new NavigatorListener(),this);
        //Commands
        Objects.requireNonNull(getCommand("backpack")).setExecutor(new BackpackCommand());
        Objects.requireNonNull(getCommand("jump")).setExecutor(new ConnectCommand());
        Objects.requireNonNull(getCommand("gm")).setExecutor(new GamemodeCommand ());
        Objects.requireNonNull(getCommand("navigator")).setExecutor(new NavigatorCommand());
        //Auto Complete
        Objects.requireNonNull(getCommand("gm")).setTabCompleter(new GamemodeCommand());
        //Manager
        backpackManager = new BackpackManager();
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + " » xSystem wird gesichert");

        this.getServer().getMessenger().unregisterOutgoingPluginChannel(this);

        //save
        backpackManager.save();
        data.save();
        config.save();
    }

    public Config getConfiguration() {
        return config;
    }

    public Data getData() {
        return data;
    }

    public static Main getInstance() {
        return instance;
    }

    public BackpackManager getBackpackManager() {
        return backpackManager;
    }

}
