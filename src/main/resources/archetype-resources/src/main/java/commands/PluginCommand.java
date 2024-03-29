#set( $symbol_dollar = '$' )
package ${package}.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.*;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import ${package}.${mainPlugin};
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import lombok.AllArgsConstructor;
import java.util.logging.Logger;

@SuppressWarnings("unused")
@Singleton
@CommandAlias("${commandAlias}")
@CommandPermission("${commandPermission}")
@AllArgsConstructor(onConstructor = @__({@Inject}))
public class PluginCommand extends BaseCommand
{
    private final ${mainClass} plugin;

    @Named("${mainClass}Logger")
    private final Logger logger;

    @Subcommand("reload")
    @Description("Reload the plugin's configuration.")
    public void reload(CommandSender sender) {
        sender.sendMessage("Reloading config...");
        plugin.readConfig(true);
    }

    /**
     * Provides Descriptions and Syntax for the command and its subcommands.
     *
     * @param sender The player or console who issued the command
     * @param help   The CommandHelp provided by ACF to generate the help
     *               descriptions and usages for this command and its subcommands.
     */
    @SuppressWarnings("unused")
    @HelpCommand
    public void doHelp(CommandSender sender, CommandHelp help)
    {
        help.showHelp();
    }
}
