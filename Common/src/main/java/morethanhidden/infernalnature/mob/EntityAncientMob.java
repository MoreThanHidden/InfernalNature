package morethanhidden.infernalnature.mob;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

import static net.minecraft.core.Registry.register;

public class EntityAncientMob extends Monster {

    //public static final EntityType<EntityAncientMob> ANCIENT = register("ancient", EntityType.Builder.<EntityAncientMob>of(EntityAncientMob::new, MobCategory.MONSTER).sized(0.6F, 1.8F).clientTrackingRange(8));

    protected EntityAncientMob(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    //public EntityAncientMob(Level world) {
		//super(ANCIENT, world);
        //this.goalSelector.addGoal(0, new EntityAISwimming(this));
        //this.goalSelector.addGoal(1, new EntityAIAttackMelee(this, 1.0D, false));
        //this.goalSelector.addGoal(2, new EntityAIMoveTowardsRestriction(this, 1.0D));
        //this.goalSelector.addGoal(3, new EntityAIMoveThroughVillage(this, 1.0D, false));
        //this.goalSelector.addGoal(4, new EntityAIWander(this, 1.0D));
        //this.goalSelector.addGoal(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        //this.goalSelector.addGoal(6, new EntityAILookIdle(this));
        //this.targetSelector.addGoal(1, new EntityAIHurtByTarget(this, true));
        //this.targetSelector.addGoal(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false, true));
	//}


}
