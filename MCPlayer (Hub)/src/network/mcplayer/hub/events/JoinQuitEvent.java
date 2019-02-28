package network.mcplayer.hub.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class JoinQuitEvent implements Listener {



    Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
    Objective o = s.registerNewObjective("dummy", "dummy");

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        p.teleport(p.getWorld().getSpawnLocation());
        p.getInventory().clear();
        p.sendMessage(ChatColor.STRIKETHROUGH + "                                                ");
        p.sendMessage(ChatColor.GRAY + "Welcome to the MCPlayer Network, please follow our rules or you will receive a punishment!");
        p.sendMessage(ChatColor.GRAY + "Join our discord: http://mcplayer.network/discord.");
        p.sendMessage(" ");
        p.sendMessage(ChatColor.GOLD + "Hub built by " + ChatColor.RED + "bliss");
        p.sendMessage(ChatColor.STRIKETHROUGH + "                                                ");
        e.setJoinMessage(null);


        ItemStack tp = new ItemStack(Material.SLIME_BALL);
        ItemMeta tp1 = tp.getItemMeta();
        tp1.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Toggle Players");
        tp.setItemMeta(tp1);
        p.getInventory().setItem(8, tp);


        ItemStack c = new ItemStack(Material.GOLD_INGOT);
        ItemMeta m = c.getItemMeta();
        m.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Cosmetics");
        c.setItemMeta(m);
        p.getInventory().setItem(4, c);





        o.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "MC" + ChatColor.RESET + ChatColor.GOLD + "Player" + ChatColor.GRAY + "" + ChatColor.BOLD + " Network");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.getScore(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "" + ChatColor.BOLD + "                               " + ChatColor.RESET).setScore(5);
        if(p.hasPermission("Hub.staff")) {
            o.getScore(ChatColor.WHITE + "Rank" + ChatColor.GRAY + ": " + ChatColor.BLUE + "" + "" + ChatColor.ITALIC + "Staff").setScore(4);
            return;
        }
        if(!p.hasPermission("hub.staff")){
            o.getScore(ChatColor.WHITE + "Rank" + ChatColor.GRAY + ": " + ChatColor.DARK_GRAY + "Default").setScore(4);
        }

        o.getScore(ChatColor.WHITE + "Mode" + ChatColor.GRAY + ": " + ChatColor.RED + "" + ChatColor.BOLD + "BETA").setScore(3);
        o.getScore(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "" + ChatColor.BOLD + "                               ").setScore(1);
        o.getScore(ChatColor.WHITE + "Server" + ChatColor.GRAY + ": " + ChatColor.DARK_GRAY + "(Hub01)").setScore(2);

        p.setScoreboard(s);




        for(Player p1 : Bukkit.getServer().getOnlinePlayers()){
            p1.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
            p1.setScoreboard(s);
        }




    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        e.setQuitMessage(null);


    }

}
