package pl.helldev.chat.gui;

import cc.dreamcode.menu.bukkit.BukkitMenuBuilder;
import cc.dreamcode.menu.bukkit.base.BukkitMenu;
import cc.dreamcode.menu.bukkit.setup.BukkitMenuPlayerSetup;
import cc.dreamcode.utilities.builder.MapBuilder;
import cc.dreamcode.utilities.bukkit.builder.ItemBuilder;
import eu.okaeri.injector.annotation.Inject;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;
import pl.helldev.chat.config.MenuConfig;
import pl.helldev.chat.config.MessageConfig;
import pl.helldev.chat.config.PluginConfig;
import pl.helldev.chat.utility.ChatHandleUtility;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ChatMenu implements BukkitMenuPlayerSetup {

    private final PluginConfig pluginConfig;
    private final MessageConfig messageConfig;

    @Override
    public BukkitMenu build(@NonNull HumanEntity humanEntity) {
        MenuConfig menuConfig = pluginConfig.menuConfig;

        BukkitMenuBuilder bukkitMenuBuilder = menuConfig.chatMenu;
        final BukkitMenu bukkitMenu = bukkitMenuBuilder.buildWithItems();

        ItemStack fixedInformItem = getFixedInformItem(menuConfig);

        bukkitMenu.setItem(menuConfig.informSlot, fixedInformItem);

        bukkitMenu.setItem(menuConfig.onSlot, menuConfig.onItem, event -> ChatHandleUtility.handleOn(event, pluginConfig, messageConfig));
        bukkitMenu.setItem(menuConfig.offSlot, menuConfig.offItem, event -> ChatHandleUtility.handleOff(event, pluginConfig, messageConfig));
        bukkitMenu.setItem(menuConfig.premiumSlot, menuConfig.premiumItem, event -> ChatHandleUtility.handlePremium(event, pluginConfig, messageConfig));
        bukkitMenu.setItem(menuConfig.clearSlot, menuConfig.clearItem, event -> ChatHandleUtility.handleClear(event, messageConfig, pluginConfig));

        return bukkitMenu;
    }

    private ItemStack getFixedInformItem(MenuConfig menuConfig) {
        String stateText;

        switch (pluginConfig.chatState) {
            case OFF:
                stateText = pluginConfig.chatStates.get(1);
                break;
            case ON:
                stateText = pluginConfig.chatStates.get(0);
                break;
            case PREMIUM:
                stateText = pluginConfig.chatStates.get(2);
                break;
            default:
                stateText = "";
                break;
        }

        return ItemBuilder.of(menuConfig.informItem)
                .fixColors(new MapBuilder<String, Object>()
                        .put("status", stateText)
                        .build()).toItemStack();
    }
}
