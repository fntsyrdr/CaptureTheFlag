package scarcity.captuetheflag.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import scarcity.captuetheflag.FlagProcessing;
import scarcity.captuetheflag.Logger;
import scarcity.captuetheflag.Models.Flag;

public class PickUpFlag implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //check that a player is sending the command
        if(!(sender instanceof Player)) {
            Logger.Info("PickUpFlag command must be used by a player");
            return true;
        }
        Player player = ((Player) sender);

        //Make sure player is on flag
        if(!FlagProcessing.IsOnFlag(player.getLocation())){
            player.sendMessage("You are not on the flag");
            return true;
        }

        //Pick up flag
        FlagProcessing.PickUpFlag(player);
        player.sendMessage("Picked Up flag");
        return true;
    }
}
