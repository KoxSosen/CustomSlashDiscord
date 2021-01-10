package me.simon.slash.discord;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	
	@Override
	public void onEnable() {
		this.getConfig().options().copyDefaults();
		saveDefaultConfig();
		int pluginId = 8724; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);
	}
	
	@Override
	public void onDisable() {
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    if (cmd.getName().equalsIgnoreCase("discord")) {
	        if (!(sender instanceof Player)) {
	            // Console
	            sender.sendMessage("Try it ingame lul.");
	            return true;
	        }
	        Player player = (Player) sender;
	        player.sendMessage("");
	        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8- " + getConfig().getString("inviteMessage") + " " + getConfig().getString("discordLink")));
            player.sendMessage("");
	    }

	    if (cmd.getName().equalsIgnoreCase("csdreload")) {
	        if (!(sender instanceof Player)) {
	            // Console
	            sender.sendMessage("You can't use /help2");
	            return true;
	        }
	        Player player = (Player) sender;
	        if (player.hasPermission("csd.reload")) {
            reloadConfig();
	        player.sendMessage("- " + ChatColor.GREEN + "You have successfully reloaded" + ChatColor.RED + " CustomSlashDiscord's " + ChatColor.GREEN + "config.");
	    }
	  }
	    return false;
	}  
} 