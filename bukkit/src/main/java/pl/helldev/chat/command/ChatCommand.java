package pl.helldev.chat.command;

import cc.dreamcode.command.annotations.RequiredPermission;
import cc.dreamcode.command.annotations.RequiredPlayer;
import cc.dreamcode.command.bukkit.BukkitCommand;
import eu.okaeri.injector.annotation.Inject;
import lombok.NonNull;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import pl.helldev.chat.command.subcommand.ReloadSubCommand;
import pl.helldev.chat.gui.ChatMenuHolder;

import java.util.Collections;
import java.util.List;

@RequiredPlayer
@RequiredPermission(permission = "helldev.chat")
public class ChatCommand extends BukkitCommand {

    private @Inject ChatMenuHolder menuHolder;

    public ChatCommand() {
        super("chat", "c");

        this.registerSubcommand(ReloadSubCommand.class);
    }

    @Override
    public void content(@NonNull CommandSender sender, @NonNull String[] args) {
        if (args.length == 0) menuHolder.openMenu((HumanEntity) sender);
    }

    @Override
    public List<String> tab(@NonNull CommandSender sender, @NonNull String[] args) {
        if (args.length == 0) return Collections.singletonList("reload");

        return null;
    }
}
