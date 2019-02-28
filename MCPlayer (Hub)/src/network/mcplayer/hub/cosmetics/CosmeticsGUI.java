package network.mcplayer.hub.cosmetics;

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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

import static org.bukkit.Material.AIR;
import static org.bukkit.Material.SLIME_BALL;


public class CosmeticsGUI implements Listener {

    public void cosmeticGUI(Player p){
        String name = ChatColor.GOLD + "" + ChatColor.BOLD + "Hub Cosmetics";
        Inventory inv = Bukkit.createInventory(null, 9*4, name);

        ArrayList<String> lore = new ArrayList<String>();

        ItemStack fly = new ItemStack(Material.FEATHER);
        ItemMeta flymeta = fly.getItemMeta();
        flymeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Fly");
        flymeta.addEnchant(Enchantment.DURABILITY, 1, true);
        lore.add(ChatColor.LIGHT_PURPLE + "Flying Hub Cosmetic!");
        flymeta.setLore(lore);
        fly.setItemMeta(flymeta);
        inv.setItem(0, fly);

        ArrayList<String> lore1 = new ArrayList<String>();
        ItemStack flash = new ItemStack(Material.SUGAR);
        ItemMeta flashmeta = flash.getItemMeta();
        flashmeta.setLore(lore1);
        flashmeta.setDisplayName(ChatColor.RED + "Flash Speed");
        lore1.add("The speed of 100 men...");
        lore1.add("Speed Hub Cosmetic!");
        flash.setItemMeta(flashmeta);
        inv.setItem(1, flash);








        p.openInventory(inv);



    }
    String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Cosmetics" + ChatColor.DARK_GRAY + "] ";
    @EventHandler
    public void Interact(PlayerInteractEvent e){
        String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Cosmetics" + ChatColor.DARK_GRAY + "] ";
        Player p = e.getPlayer();
        Action a = e.getAction();

        if(a == Action.PHYSICAL || e.getItem() == null || e.getItem().getType() == AIR)
            return;

        if(e.getItem().getType() == SLIME_BALL){
            for(Player players : p.getServer().getOnlinePlayers()){
                p.hidePlayer(players);
            }
            String server = ChatColor.GRAY + "[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Server" + ChatColor.GRAY + "] ";
            p.sendMessage(server + ChatColor.GREEN + "Vanished All Players!");

            ItemStack GRAY_DYE = new ItemStack(Material.REDSTONE);
            ItemMeta gd1 = GRAY_DYE.getItemMeta();
            gd1.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Toggle Players");
            GRAY_DYE.setItemMeta(gd1);
            ItemStack tp = new ItemStack(SLIME_BALL);
            p.getInventory().removeItem(tp);
            p.getInventory().setItem(8, GRAY_DYE);
        }

        ItemStack GRAY_DYE = new ItemStack(Material.REDSTONE);
        if(e.getItem().getType() == Material.REDSTONE){
            for(Player players : p.getServer().getOnlinePlayers()){
                p.showPlayer(players);
            }
            String server = ChatColor.GRAY + "[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Server" + ChatColor.GRAY + "] ";
            p.sendMessage(server + ChatColor.GREEN + "Unvanished All Players!");

            ItemStack tp = new ItemStack(Material.SLIME_BALL);
            ItemMeta tp1 = tp.getItemMeta();
            tp1.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Toggle Players");
            tp.setItemMeta(tp1);
            p.getInventory().setItem(8, tp);

        }


        if(e.getItem().getType() == Material.GOLD_INGOT){

            p.sendMessage(prefix +ChatColor.YELLOW + "Opening Cosmetics...");


            cosmeticGUI(p);
        }


    }


    @EventHandler
    public void onInvClick(InventoryClickEvent e){
        e.setCancelled(true);
        if(ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Hub Cosmetics")){
            Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);
            if(e.getCurrentItem() == null || e.getCurrentItem().getType() == AIR ){
                p.sendMessage(prefix + "Oops, that item is not valid, don't worry, we are going to be adding a lot more cosmetics in the future!");
                p.closeInventory();
                return;
            }



            switch (e.getCurrentItem().getType()){
                case FEATHER:
                    if(p.hasPermission("hub.fly")){

                        if(p.isFlying() == false){
                            p.setAllowFlight(true);
                            p.setFlying(true);
                            p.sendMessage(prefix + ChatColor.GREEN + "Enabled Flight!");
                            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "NOTE:" + ChatColor.WHITE + " If you are standing on the ground you will be considered as 'Not Flying'.");

                        }else{
                            p.setAllowFlight(false);
                            p.setFlying(false);

                            p.sendMessage(prefix + ChatColor.RED + "Disabled Flight!");
                        }


                    }else{

                        p.sendMessage(prefix + "You do not have permission to fly in the hub, buy a rank and get access! '/help' for more info!");
                        p.closeInventory();

                    }

            }

            switch (e.getCurrentItem().getType()){
                case SUGAR:
                    if(p.hasPermission("hub.speed")){
                        if(p.hasPotionEffect(PotionEffectType.SPEED)){
                            p.removePotionEffect(PotionEffectType.SPEED);
                            p.sendMessage(prefix + ChatColor.RED + "Disabled Flash!");
                        }else{
                            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 5, false, false));
                            p.sendMessage(prefix + ChatColor.GREEN + "Enabled Flash!");

                        }
                    }else{
                        p.sendMessage(prefix + "You do not have permission to fly in the hub, buy a rank and get access! '/help' for more info!");
                        p.closeInventory();
                    }
            }



        }else{

        }
    }



}
