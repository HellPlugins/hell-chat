package pl.helldev.chat.config;

import cc.dreamcode.menu.bukkit.BukkitMenuBuilder;
import cc.dreamcode.utilities.builder.MapBuilder;
import cc.dreamcode.utilities.bukkit.builder.ItemBuilder;
import com.cryptomorin.xseries.XMaterial;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.*;
import org.bukkit.inventory.ItemStack;

@Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
public class MenuConfig extends OkaeriConfig {


    @Comment("Wyglad menu chatmanagera:")
    public BukkitMenuBuilder chatMenu = new BukkitMenuBuilder("HellDev - ChatManager", 3,
            new MapBuilder<Integer, ItemStack>() {
                {
                    for (int i = 0; i <= 26; i++) {
                        put(i, new ItemBuilder(XMaterial.RED_STAINED_GLASS_PANE.parseItem())
                                .setName("&c&lHell&f&lDev")
                                .setLore("&ediscord.gg/helldev")
                                .toItemStack());
                    }
                }
            }.build());



    @Comment("Wyglad itemu ktory wlacza czat.")
    public ItemStack onItem = ItemBuilder.of(XMaterial.GREEN_DYE.parseMaterial())
            .setName("&aON")
            .setLore(
                    "&8Kliknij aby wlaczyc czat"
            )
            .fixColors()
            .toItemStack();

    @Comment("Slot na ktorym ma wyswietlac item od wlaczania czatu:")
    public int onSlot = 10;

    @Comment("Wyglad itemu ktory wylacza czat.")
    public ItemStack offItem = ItemBuilder.of(XMaterial.RED_DYE.parseMaterial())
            .setName("&4OFF")
            .setLore(
                    "&8Kliknij aby wylaczyc czat"
            )
            .fixColors()
            .toItemStack();

    @Comment("Slot na ktorym ma wyswietlac item od wylaczania czatu::")
    public int offSlot = 12;

    @Comment("Wyglad itemu ktory przelacza czat w tryb premium.")
    public ItemStack premiumItem = ItemBuilder.of(XMaterial.DIAMOND.parseMaterial())
            .setName("&6PREMIUM")
            .setLore(
                    "&8Kliknij aby przelaczyc czat w tryb premium"

            )
            .fixColors()
            .toItemStack();

    @Comment("Slot na ktorym ma wyswietlac item od wlaczania czatu w trybie premium:")
    public int premiumSlot = 14;

    @Comment("Wyglad itemu ktory czysci czat.")
    public ItemStack clearItem = ItemBuilder.of(XMaterial.DIAMOND_SWORD.parseMaterial())
            .setName("&7CLEAR:")
            .setLore(
                    "&aKliknij aby wyczyscic czat"
            )
            .fixColors()
            .toItemStack();

    @Comment("Slot na ktorym ma wyswietlac item od czyszczenia czatu:")
    public int clearSlot = 16;

    @Comment("Wyglad itemu ktory pokazuje status czatu.")
    public ItemStack informItem = ItemBuilder.of(XMaterial.PAPER.parseMaterial())
            .setName("&aStatus czatu:")
            .setLore(
                    "&eStatus: {status}"
            )
            .fixColors()
            .toItemStack();

    @Comment("Slot na ktorym ma wyswietlac status czatu:")
    public int informSlot = 4;

}
