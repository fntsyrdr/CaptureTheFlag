package scarcity.captuetheflag;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import scarcity.captuetheflag.Commands.DropFlag;
import scarcity.captuetheflag.Commands.PickUpFlag;
import scarcity.captuetheflag.Commands.StartCTFGame;
import scarcity.captuetheflag.Listeners.BlockPlacePrevention;
import scarcity.captuetheflag.Listeners.FlagCarrierListeners;
import scarcity.captuetheflag.Logger;
import scarcity.captuetheflag.Tasks.MonitorFlagLocationTask;

public final class CaptueTheFlag extends JavaPlugin {

    @Override
    public void onEnable() {
        Logger.Info("Enabling Plugin");
        getServer().getPluginManager().registerEvents(new BlockPlacePrevention(), this);
        getServer().getPluginManager().registerEvents(new FlagCarrierListeners(), this);
        getCommand("StartCTFGame").setExecutor(new StartCTFGame());
        getCommand("PickUpFlag").setExecutor(new PickUpFlag());
        getCommand("DropFlag").setExecutor(new DropFlag());

        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new MonitorFlagLocationTask(this), 0l, 5L);

    }

    @Override
    public void onDisable() {
        Logger.Info("Disabling Plugin");
    }
}
