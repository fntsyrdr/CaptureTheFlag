package scarcity.captuetheflag.Models;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

public class Flag {

    private static World world;
    private static Location location;

    public static Location getLocation(){
        return location;
    }

    public static void setLocation(Location newLocation){
        location = newLocation;
    }


    public static void setWorld(World newWorld){
        world = newWorld;
    }

    public static World getWorld(){
        return world;
    }

}
