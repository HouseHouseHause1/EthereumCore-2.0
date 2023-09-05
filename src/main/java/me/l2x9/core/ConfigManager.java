package me.l2x9.core;

import org.bukkit.configuration.file.FileConfiguration;

public interface ConfigManager
{
    public static final L2X9RebootCore plugin = L2X9RebootCore.getPlugin();
    public static final FileConfiguration config = ConfigManager.plugin.getConfig();
}
