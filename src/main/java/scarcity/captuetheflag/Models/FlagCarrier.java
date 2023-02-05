package scarcity.captuetheflag.Models;

import org.bukkit.entity.Player;
import scarcity.captuetheflag.Logger;

import java.util.UUID;

public class FlagCarrier {

    private static UUID player;

    public static UUID getPlayer(){
        return player;
    }

    public static void setPlayer(Player newPLayer){
        Logger.Info(newPLayer.getUniqueId() + " is UUID");
        player = newPLayer.getUniqueId();
    }

    public static void setPlayer(UUID newPlayerUUID){
        player = newPlayerUUID;
    }

    public static void removeCarrier(){
        player = null;
    }
}
