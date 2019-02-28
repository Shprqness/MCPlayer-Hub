package network.mcplayer.hub.events;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.util.Vector;

public class DoubleJumpEvent implements Listener {


    @EventHandler
    public void onCrouch(PlayerToggleSneakEvent e){
        Player p = e.getPlayer();
        if(p.isSneaking() == true){
            Vector v = p.getLocation().getDirection().multiply(2).setY(1);
            p.setVelocity(v);
            p.setAllowFlight(true);
            p.getWorld().playSound(p.getLocation(), Sound.EXPLODE, 1, 1);
        }
    }

  /*
    @EventHandler

        public void onFlight(PlayerToggleFlightEvent e){
            Player p = e.getPlayer();
            if(p.getGameMode() == GameMode.ADVENTURE){

                Block b = p.getWorld().getBlockAt(p.getLocation().subtract(0, 2, 0));
                if(!b.getType().equals(Material.AIR)) {
                    Vector v = p.getLocation().getDirection().multiply(2).setY(1);
                    p.setVelocity(v);
                    p.setAllowFlight(true);
                    p.getWorld().playSound(p.getLocation(), Sound.EXPLODE, 1, 1);
                    if (p.isFlying() == false) {
                        p.setFlying(true);
                    }
                }


            }
    }
    */



}
