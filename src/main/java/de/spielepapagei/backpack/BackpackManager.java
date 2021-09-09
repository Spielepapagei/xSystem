package de.spielepapagei.backpack;

import de.spielepapagei.Main;
import de.spielepapagei.utils.Data;

import java.io.IOException;
import java.util.*;

public class BackpackManager {

    private final Map<UUID, Backpack> map;

    public BackpackManager() {
        map = new HashMap<>();

        load();
    }

    public Backpack getBackpack(UUID uuid) {
        if(map.containsKey(uuid)) {
            return map.get(uuid);
        }

        Backpack backpack = new Backpack(uuid);
        map.put(uuid, backpack);
        return backpack;
    }

    public void setBackpack(UUID uuid, Backpack backpack) {
        map.put(uuid, backpack);
    }

    private void load() {
        Data data = Main.getInstance().getData();

        List<String> uuids = data.getconfig().getStringList("backpacks");

        uuids.forEach(s -> {
            UUID uuid = UUID.fromString(s);
            String base64 = data.getconfig().getString("backpack." + s);

            try {
                map.put(uuid, new Backpack(uuid, base64));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void save() {
        Data data = Main.getInstance().getData();

        List<String> uuids = new ArrayList<>();

        for (UUID uuid : map.keySet()) {
            uuids.add(uuid.toString());
        }

        data.getconfig().set("backpacks", uuids);
        map.forEach((uuid, backpack) -> data.getconfig().set("backpack." + uuid.toString(), backpack.toBase64()));
    }
}