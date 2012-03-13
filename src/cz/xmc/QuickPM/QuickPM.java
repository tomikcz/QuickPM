package cz.xmc.QuickPM;
 
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;
 
public class QuickPM extends JavaPlugin {
 
	public Logger log;
 
	public void onEnable(){
		log = this.getLogger();
		log.info("Your plugin has been enabled!");

		new QuickPMPlayerListener(this);
	}
 
	public void onDisable(){
		log.info("Your plugin has been disabled.");
	}
}
