package scarcity.captuetheflag.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import scarcity.captuetheflag.Logger;
import scarcity.captuetheflag.Models.Flag;
import scarcity.captuetheflag.Models.GameTimer;

public class StartCTFGame implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Logger.Info("StartCTFGame command run");
        //check that a player is sending the command
        if(!(sender instanceof Player)){
            Logger.Info("StartCTFGame command must be used by a player");
            return true;
        }


        Player player = (Player) sender;
        //Check that a game isn't already running
        if(!GameTimer.isGameOver()){
            player.sendMessage("Game Is Already Running");
            return true;
        }

        //Check that command wasn't malformed and get game time if it wasn't
        long gameTimeAllowed;
        if(args != null && args.length > 0){
            try{
                gameTimeAllowed = Integer.parseInt(args[0]);
            }catch (Exception ex){
                player.sendMessage("Command must be formatted as follows: /StartCTFGame [gameTime] where timer is an optional numeric parameter");
                return true;
            }
        }else{
            gameTimeAllowed = 60 * 1000 * 15;
        }
        Logger.Info("StartCTFGame GameTime set at " + gameTimeAllowed);

        //Start Game
        GameTimer.setStartTime(System.currentTimeMillis());
        GameTimer.setGameTimeAllowed(gameTimeAllowed);
        Flag.setLocation(player.getLocation());
        Flag.setWorld(player.getWorld());
        return true;
    }
}
