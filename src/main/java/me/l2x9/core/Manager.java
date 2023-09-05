package me.l2x9.core;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bukkit.configuration.ConfigurationSection;

import java.io.File;


public abstract class Manager {
    public Manager(final String name) {
        this.name = name;
    }
    private final String name;

    protected File dataFolder;

    public abstract void init(L2X9RebootCore plugin);

    public abstract void destruct(L2X9RebootCore plugin);

    public abstract void reloadConfig(ConfigurationSection config);
    public String getName() {
        return this.name;
    }
    public File getDataFolder() {
        if (dataFolder == null) dataFolder = new File(L2X9RebootCore.getInstance().getDataFolder(), getName());
        if (!dataFolder.exists()) dataFolder.mkdirs();
        return dataFolder;
    }
}
