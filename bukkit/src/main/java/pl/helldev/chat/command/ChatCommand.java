package pl.helldev.chat.command;

import cc.dreamcode.command.annotations.RequiredPermission;
import cc.dreamcode.command.annotations.RequiredPlayer;
import cc.dreamcode.command.bukkit.BukkitCommand;
import lombok.NonNull;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import pl.helldev.chat.command.subcommand.ReloadSubCommand;
import pl.helldev.chat.gui.ChatMenuHolder;

import java.util.Collections;
import java.util.List;

@RequiredPermission(permission = "helldev.chat")
@RequiredPlayer
public class ChatCommand extends BukkitCommand {

    private final ChatMenuHolder menuHolder;

    public ChatCommand(ChatMenuHolder menuHolder) {
        super("chat", "c");

        this.menuHolder = menuHolder;

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
