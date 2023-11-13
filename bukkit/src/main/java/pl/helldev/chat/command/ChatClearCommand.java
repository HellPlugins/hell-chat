package pl.helldev.chat.command;

import cc.dreamcode.command.bukkit.BukkitCommand;
import cc.dreamcode.utilities.builder.MapBuilder;
import eu.okaeri.injector.annotation.Inject;
import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.helldev.chat.config.MessageConfig;

import java.util.List;

public class ChatClearCommand extends BukkitCommand {

    private @Inject MessageConfig messageConfig;

    public ChatClearCommand() {
        super("cc", "chatclear");
    }

    @Override
    public void content(@NonNull CommandSender sender, @NonNull String[] args) {

        clearMessages();

        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
            messageConfig.chatCleared.send(onlinePlayers, new MapBuilder<String, Object>()
                    .put("admin", sender.getName())
                    .build());
        }

    }

    private void clearMessages() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            for (int i = 0; i < 80; i++) {
                player.sendMessage("");
            }
        }
    }

    @Override
    public List<String> tab(@NonNull CommandSender sender, @NonNull String[] args) {
        return null;
    }
}
