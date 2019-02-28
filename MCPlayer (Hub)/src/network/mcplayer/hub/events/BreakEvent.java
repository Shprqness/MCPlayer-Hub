package network.mcplayer.hub.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakEvent implements Listener {



    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(!p.hasPermission("hub.break")){
            e.setCancelled(true);
        }else{
            return;
        }
    }


}
