package network.mcplayer.hub;

import network.mcplayer.hub.cosmetics.CosmeticsGUI;
import network.mcplayer.hub.events.*;
import network.mcplayer.hub.serverSelector.ServerSelectorListeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import network.mcplayer.hub.commands.CommandHelp;
import org.bukkit.plugin.messaging.PluginMessageListener;


public class Main extends JavaPlugin {

    public void onEnable() {


        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");


        registerCommands();
        registerEvents();

    }



    private CommandHelp command = new CommandHelp();

    public void onDisable() {

    }


    public void registerEvents() {
        Bukkit.getServer().getPluginManager().registerEvents(new JoinQuitEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new CosmeticsGUI(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new BreakEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlaceEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new WeatherEvents(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new DoubleJumpEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new DropEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new HungerEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new DamageEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new AchevEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new SyncChatEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new ServerSelectorListeners(), this);




    }


    public void registerCommands() {
        getCommand(CommandHelp.help).setExecutor(command);
    }


}
