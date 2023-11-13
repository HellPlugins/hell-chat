package pl.helldev.chat.command.subcommand;

import cc.dreamcode.command.annotations.RequiredPermission;
import cc.dreamcode.command.bukkit.BukkitCommand;
import eu.okaeri.configs.exception.OkaeriException;
import lombok.NonNull;
import org.bukkit.command.CommandSender;
import pl.helldev.chat.config.MenuConfig;
import pl.helldev.chat.config.MessageConfig;
import pl.helldev.chat.config.PluginConfig;

import java.util.List;

@RequiredPermission(permission = "helldev.chat.reload")
public class ReloadSubCommand extends BukkitCommand {

    private final MenuConfig menuConfig;
    private final MessageConfig messageConfig;
    private final PluginConfig pluginConfig;

    public ReloadSubCommand(MenuConfig menuConfig, MessageConfig messageConfig, PluginConfig pluginConfig) {
        super("reload");

        this.messageConfig = messageConfig;
        this.menuConfig = menuConfig;
        this.pluginConfig = pluginConfig;
    }

    @Override
    public void content(@NonNull CommandSender sender, @NonNull String[] args) {
        try {

            menuConfig.load();
            messageConfig.load();
            pluginConfig.load();

            messageConfig.reloadComplete.send(sender);

        } catch (NullPointerException | OkaeriException exception) {
            exception.printStackTrace();

            messageConfig.reloadFailed.send(sender);
        }
    }

    @Override
    public List<String> tab(@NonNull CommandSender sender, @NonNull String[] args) {
        return null;
    }
}
