package scarcity.captuetheflag.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import scarcity.captuetheflag.FlagProcessing;
import scarcity.captuetheflag.Logger;
import scarcity.captuetheflag.Models.FlagCarrier;

public class DropFlag implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //check that a player is sending the command
        if(!(sender instanceof Player)) {
            Logger.Info("PickUpFlag command must be used by a player");
            return true;
        }
        Player player = ((Player) sender);
        if(!FlagCarrier.getPlayer().equals(player.getUniqueId())){
            player.sendMessage("You do not have the flag");
        }

        FlagProcessing.DropFlagAtLocation(player.getLocation());
        player.sendMessage("You have dropped the flag");

        return true;
    }
}
