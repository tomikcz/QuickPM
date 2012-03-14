package cz.xmc.QuickPM;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.ChatColor;

public class QuickPMPlayerListener implements Listener {
    public QuickPM plugin;
  
	public QuickPMPlayerListener(QuickPM plugin) {
	    this.plugin = plugin;
	    plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
    
    @EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerChat(PlayerChatEvent event) {
    	String[] msgp = event.getMessage().split(" ");
    	String nick = msgp[0].toString();
    	if (nick.endsWith(":") && event.getMessage().length()>1){
    	  nick=nick.substring(0,nick.length()-1);
    	  for (int i=0; i< plugin.getServer().getOnlinePlayers().length; i++){
    		  String cnick=plugin.getServer().getOnlinePlayers()[i].getName();
    		  if(cnick.toLowerCase().startsWith(nick.toLowerCase())){
    			  String mmsg=event.getMessage().substring(nick.length()+2);
    			  event.getPlayer().sendMessage(ChatColor.AQUA + "*** zprava: >>"+mmsg+"<< byla odeslana hraci "+cnick+" ***");
    			  plugin.getServer().getOnlinePlayers()[i].sendMessage(ChatColor.AQUA + event.getPlayer().getName() + ">>"+ ChatColor.GREEN + mmsg);
    			  event.setCancelled(true);
    			  return;
    		  }
       	  }
    	}
	}
}
