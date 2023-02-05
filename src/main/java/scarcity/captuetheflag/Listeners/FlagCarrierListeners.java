package scarcity.captuetheflag.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import scarcity.captuetheflag.FlagProcessing;
import scarcity.captuetheflag.Models.Flag;
import scarcity.captuetheflag.Models.FlagCarrier;

public class FlagCarrierListeners implements Listener {

    @EventHandler
    /* Drops flag when the flag carrier dies*/
    public static void onDeath(PlayerDeathEvent event){
        Player player = event.getEntity();

        //FLag carrier drops flag
        if(player.getUniqueId().equals(FlagCarrier.getPlayer())){
            FlagProcessing.DropFlagAtLocation(player.getLocation());
            FlagCarrier.removeCarrier();
        }
    }

    @EventHandler
    public static void onMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if(FlagCarrier.getPlayer() != null && player.getUniqueId().equals(FlagCarrier.getPlayer())){
            Flag.setLocation(player.getLocation());
        }
    }
}
