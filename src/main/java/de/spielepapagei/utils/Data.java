package de.spielepapagei.utils;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Data {

    private final File file;
    private final YamlConfiguration data;

    public Data() {

        File dir = new File("./plugins/xSystem/");

        if (!dir.exists()) {
            dir.mkdir();
        }

        this.file = new File(dir, "data.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.data = YamlConfiguration.loadConfiguration(file);
    }

    public File getFile() {
        return file;
    }

    public YamlConfiguration getconfig() {
        return data;
    }

    public void save() {
        try {
            data.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}