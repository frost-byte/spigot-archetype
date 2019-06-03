#set( $symbol_dollar = '$' )
package ${package};

import co.aikar.commands.BukkitCommandManager;
import com.google.inject.Injector;

import ${package}.commands.PluginCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * The ${mainClass} Plugin
 *
 * @author ${pluginAuthor}
 */
public class ${mainClass} extends JavaPlugin implements Listener
{
	/**
	 * Guice Injector
	 */
	private Injector injector;

	private boolean isActive;

	/**
	 * ACF CommandManager for Bukkit used for
	 * registering in game and console commands, contexts,
	 * completions, and replacements
	 *
	 * @see co.aikar.commands.BukkitCommandManager
	 * @see co.aikar.commands.CommandManager
	 */
	private BukkitCommandManager commandManager;

	@Override
	public void onEnable()
	{
		// Initialize the ACF Command Manger
		commandManager=new BukkitCommandManager(this);
		//noinspection deprecation
		commandManager.enableUnstableAPI("help");

		// Create the Guice Bindings.
		createBindings();

		// Create the default config.yml
		this.saveDefaultConfig();

		readConfig(false);
		getServer().getPluginManager().registerEvents(this, this);

		registerCommands();
	}

	public void readConfig(boolean doReload) {
		if (doReload)
			reloadConfig();

		isActive = getConfig().getBoolean("active");
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void handlePlayerJoin(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();
		// Add your event handling code here...
	}

	/**
	 * Generates the Guice Bindings for the Plugin's Module
	 */
	private void createBindings() {
		getLogger().info("Creating Bindings...");

		PluginBinderModule module = new PluginBinderModule(this, getLogger(), commandManager);
		injector = module.createInjector();
		injector.injectMembers(this);
	}

	/**
	* Registers all the Commands for the plugin with Aikar's Command Framework
	*/
	private void registerCommands() {
		getLogger().info("Registering Commands...");

		ACFSetup setup = injector.getInstance(ACFSetup.class);
		setup.register();
		setup.registerCommand(injector.getInstance(PluginCommand.class));
	}
}
