package de.spielepapagei;

import de.spielepapagei.commands.ConnectCommand;
import de.spielepapagei.inventory.backpack.BackpackManager;
import de.spielepapagei.commands.BackpackCommand;
import de.spielepapagei.listener.JoinListener;
import de.spielepapagei.listener.QuitListener;
import de.spielepapagei.utils.Config;
import de.spielepapagei.utils.Data;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

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
        manager.registerEvents(new JoinListener(), this);
        manager.registerEvents(new QuitListener(), this);
        //Manager
        backpackManager = new BackpackManager();
        //Commands
        getCommand("backpack").setExecutor(new BackpackCommand());
        getCommand("jump").setExecutor(new ConnectCommand());
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

    private void checkIfBungee() {
        if (!getServer().spigot().getConfig().getConfigurationSection("settings").getBoolean("settings.bungeecord")) {
            getLogger().severe("This server is not BungeeCord.");
            getLogger().severe("If the server is already hooked to BungeeCord, please enable it into your spigot.yml aswell.");
            getLogger().severe("Plugin disabled!");
            getServer().getPluginManager().disablePlugin(this);
        }
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
