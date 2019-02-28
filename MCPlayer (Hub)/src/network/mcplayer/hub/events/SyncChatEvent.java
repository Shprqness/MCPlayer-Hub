package network.mcplayer.hub.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class SyncChatEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        if(!p.hasPermission("hub.bypass")){
            e.setCancelled(true);
            p.sendMessage(ChatColor.GRAY + "(" + ChatColor.RED + "" + ChatColor.BOLD + "!" + ChatColor.GRAY + ")"
            + ChatColor.WHITE + " Chat is disabled in the hub, please purchase a rank to bypass this!");

        }
    }

}
