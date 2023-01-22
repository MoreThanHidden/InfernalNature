package morethanhidden.infernalnature.registry;


import morethanhidden.infernalnature.InfernalNature;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class AchievementRegistry {
    public static Achievement electrifying;
    public static Achievement minegem;
    public static Achievement stickyooze;

    public static void init() {
        minegem = new Achievement("achievement.minegem", "minegem", 0, 0, ItemRegistry.gem, (Achievement) null).initIndependentStat().registerStat();
        //stickyooze = new Achievement("achievement.stickyooze", "stickyooze", 2, 1,  ItemRegistry.bucketliquidGrass, minegem).registerStat();
        if (powerofmagic.ShockingLiquid = true) {
            //electrifying = new Achievement("achievement.electrifying", "electrifying", 2, 3,  ItemRegistry.bucketliquidMana, minegem).registerStat();
        }

        AchievementPage.registerAchievementPage(new AchievementPage("Molecular Gems", new Achievement[]{minegem, electrifying, stickyooze}));
    }
}
