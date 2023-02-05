package scarcity.captuetheflag.Listeners;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import scarcity.captuetheflag.CaptureZoneProcessing;
import scarcity.captuetheflag.FlagProcessing;
import scarcity.captuetheflag.Models.Flag;

public class BlockPlacePrevention implements Listener {

    @EventHandler
    /* Prevents the placement of blocks where the flag is or within the capture zone*/
    public static void onBlockPlace(BlockPlaceEvent event){
        Player player = event.getPlayer();
        Block block = event.getBlock();
        if(FlagProcessing.IsOnFlag(block.getLocation()) || CaptureZoneProcessing.IsInCaptureZone(block.getLocation())){
            event.setCancelled(true);
        }
    }

}
