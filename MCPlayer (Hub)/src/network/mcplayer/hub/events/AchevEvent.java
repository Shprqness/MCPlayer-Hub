package network.mcplayer.hub.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;

public class AchevEvent implements Listener {

    @EventHandler
    public void noAche(PlayerAchievementAwardedEvent e){
        e.setCancelled(true);
    }
}
