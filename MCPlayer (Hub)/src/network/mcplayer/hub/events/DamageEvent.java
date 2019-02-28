package network.mcplayer.hub.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageEvent implements Listener {

    @EventHandler
    public void EntDmg(EntityDamageEvent e){
        e.setCancelled(true);

    }


    @EventHandler
    public void BlckDmg(EntityDamageByBlockEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void entDam(EntityDamageByEntityEvent e){
        e.setCancelled(true);
    }


}
