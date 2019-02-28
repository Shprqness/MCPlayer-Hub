package network.mcplayer.hub.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHelp implements CommandExecutor{




    public static String help = "help";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase(help)) {
            Player p = (Player) sender;
            p.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "                        ");
            p.sendMessage(ChatColor.WHITE + "Discord: " + ChatColor.GRAY + "https://discord.gg/DEX5EQ");
            p.sendMessage(ChatColor.WHITE + "Shop: " + ChatColor.GRAY + "http://shop.mcplayer.network");
            p.sendMessage(ChatColor.WHITE + "Website: " + ChatColor.GRAY + "http://mcplayer.network");
            p.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "                        ");
        }
        return true;
    }







}
