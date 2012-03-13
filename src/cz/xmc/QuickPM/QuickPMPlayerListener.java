package cz.xmc.QuickPM;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
//import org.bukkit.entity.Player;
//import org.bukkit.ChatColor;
//import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import java.util.logging.Logger;

public class QuickPMPlayerListener implements Listener {
    public QuickPM plugin;
    public Logger logg;
    

    public QuickPMPlayerListener(QuickPM plugin) {
		this.plugin = plugin;

		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
    
    @EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerChat(PlayerChatEvent event) {
        
		//if (event.getMessage().startsWith("/")) return;
    	event.getPlayer().damage(1);
    	event.getPlayer().sendRawMessage("test test");
    	return;
    	
	//	event.setFormat(plugin.formatMessage(event.getPlayer(),  plugin.getConfigHandler().getMessageFormat(), event.getMessage()));
	}
}
