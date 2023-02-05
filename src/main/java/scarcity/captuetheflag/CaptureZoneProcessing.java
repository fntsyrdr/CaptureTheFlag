package scarcity.captuetheflag;

import org.bukkit.Location;
import scarcity.captuetheflag.Models.CaptureZone;

public class CaptureZoneProcessing {

    public static boolean IsInCaptureZone(Location location){
        Location zoneLocation = CaptureZone.getCenter();
        int radius = CaptureZone.getRadius();

        return zoneLocation.getBlockX() + radius > location.getBlockX() && zoneLocation.getBlockZ() + radius > location.getBlockZ() && zoneLocation.getBlockX() - radius < location.getBlockX() && zoneLocation.getBlockZ() - radius < location.getBlockZ();

    }
}
