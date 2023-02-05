package scarcity.captuetheflag;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import scarcity.captuetheflag.Models.Flag;
import scarcity.captuetheflag.Models.FlagCarrier;

public class FlagProcessing {

    public static void DropFlagAtLocation(Location location){
        Flag.setLocation(location);
        FlagCarrier.removeCarrier();
    }

    public static void PickUpFlag(Player player){
        FlagCarrier.setPlayer(player);
        Flag.setLocation(player.getLocation());
    }

    public static boolean IsOnFlag(Location location){
        Location flagLocation = Flag.getLocation();
        Logger.Info("Flag coords " + flagLocation.getBlockX() + " " + flagLocation.getBlockY() + " " + flagLocation.getBlockZ());
        Logger.Info("Person coords " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
        boolean isWithinX = location.getX() > flagLocation.getX() - 1 && location.getX() < flagLocation.getX() + 1;
        boolean isWithinY = location.getY() > flagLocation.getY() - 1 && location.getY() < flagLocation.getY() + 1;
        boolean isWithinZ = location.getZ() > flagLocation.getZ() - 1 && location.getZ() < flagLocation.getZ() + 3;
        return isWithinX && isWithinY && isWithinZ;
    }
}
