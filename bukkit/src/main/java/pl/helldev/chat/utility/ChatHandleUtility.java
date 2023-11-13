package pl.helldev.chat.utility;

import cc.dreamcode.utilities.builder.MapBuilder;
import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.helldev.chat.ChatState;
import pl.helldev.chat.config.MessageConfig;
import pl.helldev.chat.config.PluginConfig;

@UtilityClass
public class ChatHandleUtility {

    public void handleOn(InventoryClickEvent event, PluginConfig pluginConfig, MessageConfig messageConfig) {
        Player player = (Player) event.getWhoClicked();

        if (pluginConfig.chatState == ChatState.ON) {
            messageConfig.chatIsAlreadyOn.send(player);
            event.getWhoClicked().closeInventory();
            return;
        }

        event.getWhoClicked().closeInventory();
        if (pluginConfig.shouldClearMessages) {
            clearMessages();
        }

        pluginConfig.chatState = ChatState.ON;
        pluginConfig.save();

        if (!pluginConfig.shouldAnnounce) return;

        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
            messageConfig.chatTurnedOn.send(onlinePlayers, new MapBuilder<String, Object>()
                    .put("admin", event.getWhoClicked().getName())
                    .build());
        }

    }

    public void handleOff(InventoryClickEvent event, PluginConfig pluginConfig, MessageConfig messageConfig) {
        Player player = (Player) event.getWhoClicked();

        if (pluginConfig.chatState == ChatState.OFF) {
            messageConfig.chatIsAlreadyOff.send(player);
            event.getWhoClicked().closeInventory();
            return;
        }

        event.getWhoClicked().closeInventory();
        if (pluginConfig.shouldClearMessages) {
            clearMessages();
        }

        pluginConfig.chatState = ChatState.OFF;
        pluginConfig.save();

        if (!pluginConfig.shouldAnnounce) return;

        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
            messageConfig.chatTurnedOff.send(onlinePlayers, new MapBuilder<String, Object>()
                    .put("admin", event.getWhoClicked().getName())
                    .build());
        }

    }

    public void handlePremium(InventoryClickEvent event, PluginConfig pluginConfig, MessageConfig messageConfig) {
        Player player = (Player) event.getWhoClicked();

        if (pluginConfig.chatState == ChatState.PREMIUM) {
            messageConfig.chatIsAlreadyPremium.send(player);
            event.getWhoClicked().closeInventory();
            return;
        }

        event.getWhoClicked().closeInventory();
        if (pluginConfig.shouldClearMessages) {
            clearMessages();
        }

        pluginConfig.chatState = ChatState.PREMIUM;
        pluginConfig.save();

        if (!pluginConfig.shouldAnnounce) return;

        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
            messageConfig.chatTurnedPremium.send(onlinePlayers, new MapBuilder<String, Object>()
                    .put("admin", event.getWhoClicked().getName())
                    .build());
        }

    }

    public void handleClear(InventoryClickEvent event, MessageConfig messageConfig, PluginConfig pluginConfig) {

        event.getWhoClicked().closeInventory();
        clearMessages();

        if (!pluginConfig.shouldAnnounce) return;

        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
            messageConfig.chatCleared.send(onlinePlayers, new MapBuilder<String, Object>()
                    .put("admin", event.getWhoClicked().getName())
                    .build());
        }

    }

    private void clearMessages() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            for (int i = 0; i < 50; i++) {
                player.sendMessage("");
            }
        }
    }

}
