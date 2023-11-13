package pl.helldev.chat;

import cc.dreamcode.command.bukkit.BukkitCommandProvider;
import cc.dreamcode.menu.bukkit.BukkitMenuProvider;
import cc.dreamcode.menu.bukkit.okaeri.MenuBuilderSerdes;
import cc.dreamcode.notice.minecraft.bukkit.serdes.BukkitNoticeSerdes;
import cc.dreamcode.platform.DreamVersion;
import cc.dreamcode.platform.bukkit.DreamBukkitConfig;
import cc.dreamcode.platform.bukkit.DreamBukkitPlatform;
import cc.dreamcode.platform.bukkit.component.CommandComponentResolver;
import cc.dreamcode.platform.bukkit.component.ConfigurationComponentResolver;
import cc.dreamcode.platform.bukkit.component.ListenerComponentResolver;
import cc.dreamcode.platform.component.ComponentManager;
import pl.helldev.chat.command.ChatClearCommand;
import pl.helldev.chat.command.ChatCommand;
import pl.helldev.chat.config.MessageConfig;
import pl.helldev.chat.config.PluginConfig;

import eu.okaeri.configs.serdes.OkaeriSerdesPack;
import lombok.Getter;
import lombok.NonNull;
import pl.helldev.chat.controller.ChatController;
import pl.helldev.chat.gui.ChatMenuHolder;

public final class ChatPlugin extends DreamBukkitPlatform implements DreamBukkitConfig {

    @Getter private static ChatPlugin chatPlugin;

    @Override
    public void load(@NonNull ComponentManager componentManager) {
        chatPlugin = this;
    }

    @Override
    public void enable(@NonNull ComponentManager componentManager) {

        this.registerInjectable(BukkitMenuProvider.create(this));
        this.registerInjectable(BukkitCommandProvider.create(this, this.getInjector()));

        componentManager.registerResolver(CommandComponentResolver.class);
        componentManager.registerResolver(ListenerComponentResolver.class);

        componentManager.registerResolver(ConfigurationComponentResolver.class);
        componentManager.registerComponent(MessageConfig.class, messageConfig ->
                this.getInject(BukkitCommandProvider.class).ifPresent(bukkitCommandProvider -> {
                    bukkitCommandProvider.setRequiredPermissionMessage(messageConfig.noPermission.getText());
                    bukkitCommandProvider.setRequiredPlayerMessage(messageConfig.notPlayer.getText());
                }));

        componentManager.registerComponent(PluginConfig.class);

        componentManager.registerComponent(ChatMenuHolder.class);

        componentManager.registerComponent(ChatCommand.class);
        componentManager.registerComponent(ChatClearCommand.class);

        componentManager.registerComponent(ChatController.class);

    }

    @Override
    public void disable() {}

    @Override
    public @NonNull DreamVersion getDreamVersion() {
        return DreamVersion.create("Hell-Chat", "1.0", "Nightusio");
    }

    @Override
    public @NonNull OkaeriSerdesPack getConfigSerdesPack() {
        return registry -> {
            registry.register(new BukkitNoticeSerdes());
            registry.register(new MenuBuilderSerdes());
        };
    }

}
