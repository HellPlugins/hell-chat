package pl.helldev.chat.controller;

import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import pl.helldev.chat.ChatState;
import pl.helldev.chat.config.MessageConfig;
import pl.helldev.chat.config.PluginConfig;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ChatController implements Listener {

    private final PluginConfig pluginConfig;
    private final MessageConfig messageConfig;

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        ChatState chatState = pluginConfig.chatState;

        handleOff(chatState, event);
        handlePremium(chatState, event);
    }

    private void handleOff(ChatState chatState, AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (chatState != ChatState.OFF) return;
        if (player.hasPermission(pluginConfig.offPermission)) return;

        event.setCancelled(true);
        messageConfig.chatIsOff.send(player);
    }

    private void handlePremium(ChatState chatState, AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (chatState != ChatState.PREMIUM) return;
        if (player.hasPermission(pluginConfig.premiumPermission)) return;

        event.setCancelled(true);
        messageConfig.chatIsPremium.send(player);
    }
}
