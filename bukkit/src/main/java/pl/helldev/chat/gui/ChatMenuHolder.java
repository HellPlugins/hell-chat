package pl.helldev.chat.gui;

import cc.dreamcode.menu.bukkit.base.BukkitMenu;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.HumanEntity;
import pl.helldev.chat.ChatPlugin;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ChatMenuHolder {

    private final ChatPlugin chatPlugin;

    public void openMenu(HumanEntity entity) {
        ChatMenu chatMenu = chatPlugin.createInstance(ChatMenu.class);
        BukkitMenu bukkitMenu = chatMenu.build(entity);
        bukkitMenu.open(entity);
    }


}
