package scarcity.captuetheflag.Models;

import org.bukkit.Location;

public class CaptureZone {

    private static Location center;
    private static int radius;

    public static void setCenter(Location newCenter){
        center = newCenter;
    }

    public static void setRadius(int newRadius){
        radius = newRadius;
    }

    public static Location getCenter(){
        return center;
    }

    public static int getRadius(){
        return radius;
    }
}
