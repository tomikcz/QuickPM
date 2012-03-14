package cz.xmc.QuickPM;
 
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;
 
public class QuickPM extends JavaPlugin {
 
	public Logger log;
 
	public void onEnable(){
		log = this.getLogger();
		log.info("QuickPM loaded");

		new QuickPMPlayerListener(this);
	}
 
	public void onDisable(){
		
		log.info("QuickPM has been disabled.");
	}
}
