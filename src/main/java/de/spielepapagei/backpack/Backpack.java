package de.spielepapagei.backpack;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import de.spielepapagei.utils.Base64;

import java.io.IOException;
import java.util.UUID;

public class Backpack {

    private final UUID uuid;
    private final Inventory inventory1;

    public Backpack(UUID uuid) {
        this.uuid = uuid;
        this.inventory1 = Bukkit.createInventory(null, 54, ChatColor.DARK_GRAY + " » " + ChatColor.GOLD.toString() + ChatColor.BOLD + "Backpack 1");
    }

    public Backpack(UUID uuid, String base64) throws IOException {
        this.uuid = uuid;
        this.inventory1 = Bukkit.createInventory(null, 54, ChatColor.DARK_GRAY + " » " + ChatColor.GOLD.toString() + ChatColor.BOLD + "Backpack 1");
        this.inventory1.setContents(Base64.itemStackArrayFromBase64(base64));
    }

    public UUID getUuid() {
        return uuid;
    }

    public Inventory getInventory() {
        return inventory1;
    }

    public String toBase64() {
        return Base64.itemStackArrayToBase64(inventory1.getContents());
    }
}
