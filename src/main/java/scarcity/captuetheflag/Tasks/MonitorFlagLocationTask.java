package scarcity.captuetheflag.Tasks;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import scarcity.captuetheflag.CaptueTheFlag;
import scarcity.captuetheflag.Logger;
import scarcity.captuetheflag.Models.Flag;
import scarcity.captuetheflag.Models.GameTimer;

public class MonitorFlagLocationTask implements Runnable {

    CaptueTheFlag plugin;

    public MonitorFlagLocationTask(CaptueTheFlag plugin){this.plugin = plugin;}

    @Override
    public void run() {
        //Ensure the flag exists, the flag is in the world, and a game is running
        if(Flag.getWorld() == null || Flag.getLocation() == null || GameTimer.isGameOver()) {
            return;
        }

        //Put particle at flag location and above flag location
        Location flagLocation = Flag.getLocation();
        World flagWorld = Flag.getWorld();

        flagWorld.spawnParticle(Particle.SOUL_FIRE_FLAME, flagLocation, 25, 0, 0, 0, -1, null, true);
        flagWorld.spawnParticle(Particle.SOUL_FIRE_FLAME, flagLocation.add(0, 1, 0), 25, 0, 0, 0, -1, null, true);
        flagWorld.spawnParticle(Particle.SOUL_FIRE_FLAME, flagLocation.add(0, 1, 0), 25, 0, 0, 0, -1, null, true);
        flagLocation.subtract(0, 2, 0);

    }
}
