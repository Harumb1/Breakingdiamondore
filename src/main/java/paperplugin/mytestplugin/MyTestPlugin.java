package paperplugin.mytestplugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyTestPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.broadcastMessage("Plugin starting up!");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        Bukkit.broadcastMessage("Plugin shutting down!");
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Location location = e.getBlock().getLocation();
        Player player = e.getPlayer();
        if (e.getBlock().getType() == Material.DIAMOND_ORE || e.getBlock().getType() == Material.DEEPSLATE_DIAMOND_ORE)
        {
            blocksBroken++;
            player.sendMessage("You broke " + blocksBroken);
            if (blocksBroken == 10)
            {
                player.kickPlayer(location.toString());
            }

        }

    }
        int blocksBroken = 0;


    public int getBlocksBroken() {
        return blocksBroken;
    }

}



