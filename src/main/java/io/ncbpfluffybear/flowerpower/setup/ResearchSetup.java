package io.ncbpfluffybear.flowerpower.setup;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.ncbpfluffybear.flowerpower.FlowerPowerItems;
import io.ncbpfluffybear.flowerpower.FlowerPowerPlugin;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

/**
 * Registers all of the research
 * @author NCBPFluffyBear
 */
public final class ResearchSetup {

    private ResearchSetup() {}

    public static void setup() {

        register("magic_crafting", 2711, "魔法合成", 5, FlowerPowerItems.MAGIC_BASIN, FlowerPowerItems.MAGICAL_WAND);
        register("experience_cauldron", 2712, "经验之釜", 5, FlowerPowerItems.EXPERIENCE_CAULDRON);
        register("glistening_resources", 2713, "闪耀的资源", 10,
                FlowerPowerItems.MAGIC_CREAM, FlowerPowerItems.GLISTENING_POPPY, FlowerPowerItems.GLISTENING_DANDELION,
                FlowerPowerItems.GLISTENING_OXEYE_DAISY, FlowerPowerItems.GLISTENING_ALLIUM, FlowerPowerItems.RED_CRYSTAL,
                FlowerPowerItems.YELLOW_CRYSTAL, FlowerPowerItems.WHITE_CRYSTAL, FlowerPowerItems.PURPLE_CRYSTAL
        );
        register("experience_storage", 2714, "经验储存", 50, FlowerPowerItems.EXPERIENCE_TOME);
        register("attribute_charms", 2715, "魔法属性", 50, FlowerPowerItems.MOVEMENT_SPEED_CHARM,
                FlowerPowerItems.ATTACK_SPEED_CHARM, FlowerPowerItems.FLY_SPEED_CHARM, FlowerPowerItems.DAMAGE_CHARM,
                FlowerPowerItems.HEALTH_CHARM
        );
        register("recall_teleportation", 2716, "传送符文", 30, FlowerPowerItems.RECALL_CHARM);
        register("infinity_magic", 2717, "无尽魔法", 30, FlowerPowerItems.INFINITY_APPLE, FlowerPowerItems.INFINITY_BANDAGE);
        register("faster_flower_growth", 2718, "花的快速生长", 10, FlowerPowerItems.OVERGROWTH_SEED);

    }

    private static void register(String key, int id, String name, int defaultCost, ItemStack... items) {
        Research research = new Research(new NamespacedKey(FlowerPowerPlugin.getInstance(), key), id, name, defaultCost);

        for (ItemStack item : items) {
            SlimefunItem sfItem = SlimefunItem.getByItem(item);

            if (sfItem != null) {
                research.addItems(sfItem);
            }
        }

        research.register();
    }
}
