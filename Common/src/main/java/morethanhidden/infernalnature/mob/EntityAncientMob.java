package morethanhidden.infernalnature.mob;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class EntityAncientMob extends Monster {

    public static final EntityType<EntityAncientMob> ANCIENT = register("ancient", EntityType.Builder.<EntityAncientMob>of(EntityAncientMob::new, MobCategory.MONSTER).sized(0.6F, 1.8F).clientTrackingRange(8));

    public EntityAncientMob(Level world) {
		super(ANCIENT, world);
        this.goalSelector.addGoal(0, new EntityAISwimming(this));
        this.goalSelector.addGoal(1, new EntityAIAttackMelee(this, 1.0D, false));
        this.goalSelector.addGoal(2, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.goalSelector.addGoal(3, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.goalSelector.addGoal(4, new EntityAIWander(this, 1.0D));
        this.goalSelector.addGoal(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.goalSelector.addGoal(6, new EntityAILookIdle(this));
        this.targetSelector.addGoal(1, new EntityAIHurtByTarget(this, true));
        this.targetSelector.addGoal(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false, true));
	}

	@Override
	 protected Item getDropItem()
	    {
	        return Items.QUARTZ;
	    }
	
	@Override
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6D);
    }
	
    public void onLivingUpdate()
    {
        if (this.world.isDaytime() && !this.world.isRemote && !this.isChild())
        {
            float f = this.getBrightness(1.0F);

            if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.world.canBlockSeeSky(new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.posY), MathHelper.floor(this.posZ))))
            {               
                    this.setDead();
            }
        }
        super.onLivingUpdate();
    }
	
	
}
