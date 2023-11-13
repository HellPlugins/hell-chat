package pl.helldev.chat.config;

import cc.dreamcode.notice.minecraft.MinecraftNoticeType;
import cc.dreamcode.notice.minecraft.bukkit.BukkitNotice;
import cc.dreamcode.platform.bukkit.component.configuration.Configuration;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Header;
import eu.okaeri.configs.annotation.Headers;
import eu.okaeri.configs.annotation.NameModifier;
import eu.okaeri.configs.annotation.NameStrategy;
import eu.okaeri.configs.annotation.Names;

@Configuration(
        child = "message.yml"
)
@Headers({
        @Header("## Hell-Chat (Message-Config) ##"),
        @Header("Dostepne type: (DO_NOT_SEND, CHAT, ACTION_BAR, SUBTITLE, TITLE, TITLE_SUBTITLE)")
})
@Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
public class MessageConfig extends OkaeriConfig {

    public BukkitNotice noPermission = new BukkitNotice(MinecraftNoticeType.CHAT, "&4Nie posiadasz uprawnien.");
    public BukkitNotice notPlayer = new BukkitNotice(MinecraftNoticeType.CHAT, "&4Nie jestes graczem.");
    public BukkitNotice reloadComplete = new BukkitNotice(MinecraftNoticeType.CHAT, "&aPomyslnie przeladowales konfiguracje pluginu!");
    public BukkitNotice reloadFailed = new BukkitNotice(MinecraftNoticeType.CHAT, "&4Cos poszlo nie tak! Sprawdz konsole.");

    public BukkitNotice chatIsAlreadyOn = new BukkitNotice(MinecraftNoticeType.CHAT, "&4Chat juz jest wlaczony!");
    public BukkitNotice chatIsAlreadyOff = new BukkitNotice(MinecraftNoticeType.CHAT, "&4Chat juz jest wylaczony!");

    public BukkitNotice chatIsAlreadyPremium = new BukkitNotice(MinecraftNoticeType.CHAT, "&4Chat juz jest w trybie premium!");


    public BukkitNotice chatTurnedOn = new BukkitNotice(MinecraftNoticeType.CHAT, "&aChat zostal wlaczony przez administratora {admin}!");
    public BukkitNotice chatTurnedOff = new BukkitNotice(MinecraftNoticeType.CHAT, "&aChat zostal wylaczony przez administratora {admin}!");

    public BukkitNotice chatTurnedPremium = new BukkitNotice(MinecraftNoticeType.CHAT, "&aChat zostal przelaczony w tryb PREMIUM przez administratora {admin}!");

    public BukkitNotice chatCleared = new BukkitNotice(MinecraftNoticeType.CHAT, "&aChat zostal wyczyszczony przez administratora {admin}!");

    public BukkitNotice chatIsOff = new BukkitNotice(MinecraftNoticeType.CHAT, "&aChat jest aktualnie wylaczony!");
    public BukkitNotice chatIsPremium = new BukkitNotice(MinecraftNoticeType.CHAT, "&aChat jest aktualnie w trybie PREMIUM!");


}
