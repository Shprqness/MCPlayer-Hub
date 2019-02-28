package network.mcplayer.hub.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceEvent implements Listener {

    @EventHandler
    public void BreakEvent(BlockPlaceEvent e){
        Player p = e.getPlayer();
        if(p.isOp() == false){
            e.setCancelled(true);
        }
        }
    }

