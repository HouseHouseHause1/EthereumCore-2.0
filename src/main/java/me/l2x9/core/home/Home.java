package me.l2x9.core.home;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bukkit.Location;

import java.util.UUID;

public class Home {
    private final String name;
    private final UUID owner;
    private Location location;

    public Home(String name, UUID owner, Location location) {
        this.name = name;
        this.owner = owner;
        this.location = location;
    }
    public String getName() {
        return this.name;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(final Location location) {
        this.location = location;
    }

    public UUID getOwner() {
        return this.owner;
    }
}
