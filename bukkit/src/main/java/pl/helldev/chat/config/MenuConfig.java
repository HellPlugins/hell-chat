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
    public BukkitMenuBuilder chatMenu = new BukkitMenuBuilder("HellDev - ChatManager",
            3,
            new MapBuilder<Integer, ItemStack>()
                    .put(0, new ItemBuilder(XMaterial.APPLE.parseItem())
                            .setName("&c&lHellDev")
                            .setLore("&eHeellldevik")
                            .toItemStack())
                    .build());

    @Comment("Wyglad itemu ktory wlacza czat.")
    public ItemStack onItem = ItemBuilder.of(XMaterial.PAPER.parseMaterial())
            .setName("On")
            .setLore(
                    "Kliknij aby wlaczyc czat"
            )
            .toItemStack();

    @Comment("Slot na ktorym ma wyswietlac item od wlaczania czatu:")
    public int onSlot = 5;

    @Comment("Wyglad itemu ktory wylacza czat.")
    public ItemStack offItem = ItemBuilder.of(XMaterial.PAPER.parseMaterial())
            .setName("Off")
            .setLore(
                    "Kliknij aby wylaczyc czat"
            )
            .toItemStack();

    @Comment("Slot na ktorym ma wyswietlac item od wylaczania czatu::")
    public int offSlot = 5;

    @Comment("Wyglad itemu ktory przelacza czat w tryb premium.")
    public ItemStack premiumItem = ItemBuilder.of(XMaterial.DIAMOND.parseMaterial())
            .setName("Premium")
            .setLore(
                    "Kliknij aby przelaczyc czat w tryb premium"

            )
            .toItemStack();

    @Comment("Slot na ktorym ma wyswietlac item od wlaczania czatu w trybie premium:")
    public int premiumSlot = 5;

    @Comment("Wyglad itemu ktory czysci czat.")
    public ItemStack clearItem = ItemBuilder.of(XMaterial.DIAMOND_SWORD.parseMaterial())
            .setName("Wyczysc czat:")
            .setLore(
                    "Kliknij aby wyczyscic czat"
            )
            .toItemStack();

    @Comment("Slot na ktorym ma wyswietlac item od czyszczenia czatu:")
    public int clearSlot = 5;


    @Comment("Wyglad itemu ktory pokazuje status czatu.")
    public ItemStack informItem = ItemBuilder.of(XMaterial.PAPER.parseMaterial())
            .setName("Status czatu:")
            .setLore(
                    "&eStatus: &7{status}"
            )
            .toItemStack();

    @Comment("Slot na ktorym ma wyswietlac status czatu:")
    public int informSlot = 4;

}
