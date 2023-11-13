package pl.helldev.chat.command;

import cc.dreamcode.command.bukkit.BukkitCommand;
import lombok.NonNull;
import org.bukkit.command.CommandSender;

import java.util.List;

public class ChatClearCommand extends BukkitCommand {

    public ChatClearCommand() {
        super("cc", "chatclear");
    }

    @Override
    public void content(@NonNull CommandSender sender, @NonNull String[] args) {

    }

    @Override
    public List<String> tab(@NonNull CommandSender sender, @NonNull String[] args) {
        return null;
    }
}
