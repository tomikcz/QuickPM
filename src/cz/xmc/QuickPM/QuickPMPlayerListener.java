package cz.xmc.QuickPM;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class QuickPMPlayerListener implements Listener {
    public QuickPM plugin;
	public String msg;     
	
	public QuickPMPlayerListener(QuickPM plugin) {
	    this.plugin = plugin;
	    plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
    
    @EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerChat(PlayerChatEvent event) {
    	msg = event.getMessage();
    	String[] msgp = msg.split(" ");
    	String nick = msgp[0].toString();
    	if (nick.endsWith(":") && msg.length()>1){
    	  nick=nick.substring(0,nick.length()-1);
    	  for (int i=0; i< plugin.getServer().getOnlinePlayers().length; i++){
    		  String cnick=plugin.getServer().getOnlinePlayers()[i].getDisplayName();
    		  if(cnick.toLowerCase().startsWith(nick.toLowerCase())){
    			  String mmsg=msg.substring(nick.length()+1);
    			  event.getPlayer().sendMessage(ChatColor.AQUA + "zprava odeslana");
    			  plugin.getServer().getOnlinePlayers()[i].sendMessage("PM od: " + ChatColor.AQUA + event.getPlayer().getDisplayName());
    			  plugin.getServer().getOnlinePlayers()[i].sendMessage(ChatColor.GREEN + mmsg);
    			  event.setCancelled(true);
    			  return;
    		  }
       	  }
    	}
	}
}
