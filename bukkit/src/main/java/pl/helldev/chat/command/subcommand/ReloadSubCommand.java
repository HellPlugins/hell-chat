package pl.helldev.chat.command.subcommand;

import cc.dreamcode.command.annotations.RequiredPermission;
import cc.dreamcode.command.bukkit.BukkitCommand;
import eu.okaeri.configs.exception.OkaeriException;
import eu.okaeri.injector.annotation.Inject;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.CommandSender;
import pl.helldev.chat.config.MenuConfig;
import pl.helldev.chat.config.MessageConfig;
import pl.helldev.chat.config.PluginConfig;

import java.util.List;

@RequiredPermission(permission = "helldev.chat.reload")
public class ReloadSubCommand extends BukkitCommand {

    private @Inject MessageConfig messageConfig;
    private @Inject PluginConfig pluginConfig;

    public ReloadSubCommand() {
        super("reload");
    }

    @Override
    public void content(@NonNull CommandSender sender, @NonNull String[] args) {
        try {

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
