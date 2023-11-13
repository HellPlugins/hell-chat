package pl.helldev.chat.config;

import cc.dreamcode.platform.bukkit.component.configuration.Configuration;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.annotation.Header;
import eu.okaeri.configs.annotation.NameModifier;
import eu.okaeri.configs.annotation.NameStrategy;
import eu.okaeri.configs.annotation.Names;
import pl.helldev.chat.ChatState;

import java.util.Arrays;
import java.util.List;

@Configuration(
        child = "config.yml"
)
@Header("## Hell-Chat (Main-Config) ##")
@Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
public class PluginConfig extends OkaeriConfig {
    @Comment("Debug pokazuje dodatkowe informacje do konsoli. Lepiej wylaczyc.")
    public boolean debug = false;

    @Comment("Konfiguracja menu.")
    public MenuConfig menuConfig = new MenuConfig();

    @Comment("Czy plugin ma wysylac wiadomosci na czacie po np. wlaczeniu czatu?")
    public boolean shouldAnnounce = true;

    @Comment("Permisja ktora ma dostep do czatu gdy jest w trybie premium:")
    public String premiumPermission = "helldev.chat.premium";

    @Comment("Permisja ktora ma dostep do czatu gdy jest wylaczony:")
    public String offPermission = "helldev.chat.off";

    @Comment("Aktualny status czatu:")
    public ChatState chatState = ChatState.ON;

    @Comment("Wyglad statusow czatu:")
    public List<String> chatStates = Arrays.asList("&2ON", "&4OFF", "&6PREMIUM");

    @Comment("Czy podczas wylaczania, wlaczania czatu i wlaczania trybu premium plugin ma clearowac czat?")
    public boolean shouldClearMessages = true;

}
