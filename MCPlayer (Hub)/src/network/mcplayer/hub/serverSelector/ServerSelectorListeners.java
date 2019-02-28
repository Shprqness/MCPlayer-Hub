package network.mcplayer.hub.serverSelector;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static org.bukkit.Material.AIR;
import static org.bukkit.Material.SLIME_BALL;

public class ServerSelectorListeners implements Listener {

    /*

    public void serverGUI(Player p){
        String name = ChatColor.GREEN + "" + ChatColor.BOLD + "Server Selector";
        Inventory inv = Bukkit.createInventory(null, 9*8, name);

        ArrayList<String> lore = new ArrayList<String>();
        ArrayList<String> lore2 = new ArrayList<String>();
        ArrayList<String> lore3 = new ArrayList<String>();



        ItemStack PvP = new ItemStack(Material.DIAMOND_CHESTPLATE);
        lore.add(ChatColor.RED + "PvP Server.");
        lore.add(ChatColor.RED + "Made for the best of the best!");
        lore.add(ChatColor.RED + "Do you have what it takes?");
        ItemMeta k1 = PvP.getItemMeta();
        k1.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "PvP");
        k1.setLore(lore);
        PvP.setItemMeta(k1);
        inv.setItem(12, PvP);


        p.openInventory(inv);



    }


    @EventHandler
    public void Interact(PlayerInteractEvent e){
        Player p = e.getPlayer();
        Action a = e.getAction();

        if(a == Action.PHYSICAL || e.getItem() == null || e.getItem().getType() == AIR)
            return;


        if(e.getItem().getType() == Material.COMPASS){
            String server = ChatColor.GRAY + "[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Server" + ChatColor.GRAY + "] ";

            p.sendMessage(server + "Opening Server Selector!");

            serverGUI(p);
        }


    }


    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        String server = ChatColor.GRAY + "[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Server" + ChatColor.GRAY + "] ";

        e.setCancelled(true);
        if (ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Server Selector")) {
            Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);
            if (e.getCurrentItem() == null || e.getCurrentItem().getType() == AIR) {
                p.sendMessage(server + "Oops, that item is not valid, don't worry, we will have many more gamemodes released soon!");
                p.closeInventory();
                return;
            }


            switch (e.getCurrentItem().getType()) {
                case DIAMOND_CHESTPLATE:

                    ByteArrayOutputStream b = new ByteArrayOutputStream();
                    DataOutputStream out = new DataOutputStream(b);
                    try {
                        out.writeUTF("Connect");
                        out.writeUTF("pvp"); // Target Server
                    } catch (IOException ev) {
                        // Can never happen
                    }

            }
            String server1 = ChatColor.GRAY + "[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Server" + ChatColor.GRAY + "] ";

            p.sendMessage(server1 + "Awaiting response from server 'PvP', please wait...");
                    }







    }
    */


}
