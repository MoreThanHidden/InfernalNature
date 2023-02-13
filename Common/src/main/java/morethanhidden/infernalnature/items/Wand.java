package morethanhidden.infernalnature.items;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;

public class Wand extends Item {

    private static final String TAG_MYSTIC_ENERGY = "mystic_energy";
    private static final String TAG_NATURE_ENERGY = "nature_energy";
    private static final String TAG_INFERNAL_ENERGY = "infernal_energy";

    public static final String TAG_GEM_TOP = "gem_top";
    public static final String TAG_GEM_BOTTOM = "gem_bottom";

    /**
     * Wand Constructor
     */
    public Wand() {
        super(new Item.Properties().stacksTo(1));
    }

    /**
     * Get the amount of Mystic Energy stored in the wand
     * @param item Itemstack in question
     * @return Amount of Mystic Energy
     */
    public int getMysticEnergy(ItemStack item) {
        return item.getOrCreateTag().getInt(TAG_MYSTIC_ENERGY);
    }

    /**
     * Get the amount of Nature Energy stored in the wand
     * @param item Itemstack in question
     * @return Amount of Nature Energy
     */
    public int getNatureEnergy(ItemStack item) {
        return item.getOrCreateTag().getInt(TAG_NATURE_ENERGY);
    }

    /**
     * Get the amount of Infernal Energy stored in the wand
     * @param item Itemstack in question
     * @return Amount of Infernal Energy
     */
    public int getInfernalEnergy(ItemStack item) {
        return item.getOrCreateTag().getInt(TAG_INFERNAL_ENERGY);
    }

    /**
     * This is called when the item is first created, and when the item is loaded from NBT.
     * This is the place to do any NBT data validation, and to set any default values.
     * @param tag
     */
    @Override
    public void verifyTagAfterLoad(CompoundTag tag) {
        super.verifyTagAfterLoad(tag);
        if(!tag.contains(TAG_MYSTIC_ENERGY)){tag.putInt(TAG_MYSTIC_ENERGY, 0);}
        if(!tag.contains(TAG_NATURE_ENERGY)){tag.putInt(TAG_NATURE_ENERGY, 0);}
        if(!tag.contains(TAG_INFERNAL_ENERGY)){tag.putInt(TAG_INFERNAL_ENERGY, 0);}

        if(!tag.contains(TAG_GEM_TOP)){tag.putInt(TAG_GEM_TOP, 1);}
        if(!tag.contains(TAG_GEM_BOTTOM)){tag.putInt(TAG_GEM_BOTTOM, 0);}
    }

    /**
     * This is called when the item is right-clicked on a block.
     * @param useOnContext The context of the right click
     * @return The result of the right click
     */
    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        useOnContext.getLevel().playSound(useOnContext.getPlayer(), useOnContext.getClickedPos(), SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
        useOnContext.getLevel().addParticle(ParticleTypes.DRAGON_BREATH, useOnContext.getClickLocation().x, useOnContext.getClickLocation().y, useOnContext.getClickLocation().z, 0.0D, 0.0D, 0.0D);
        useOnContext.getLevel().addParticle(ParticleTypes.DRAGON_BREATH, useOnContext.getClickLocation().x+0.1, useOnContext.getClickLocation().y+0.1, useOnContext.getClickLocation().z+0.1, 0.0D, 0.0D, 0.0D);
        useOnContext.getLevel().addParticle(ParticleTypes.DRAGON_BREATH, useOnContext.getClickLocation().x-0.1, useOnContext.getClickLocation().y-0.1, useOnContext.getClickLocation().z-0.1, 0.0D, 0.0D, 0.0D);
        useOnContext.getLevel().addParticle(ParticleTypes.DRAGON_BREATH, useOnContext.getClickLocation().x+0.1, useOnContext.getClickLocation().y-0.1, useOnContext.getClickLocation().z-0.1, 0.0D, 0.0D, 0.0D);
        useOnContext.getLevel().addParticle(ParticleTypes.DRAGON_BREATH, useOnContext.getClickLocation().x-0.1, useOnContext.getClickLocation().y+0.1, useOnContext.getClickLocation().z+0.1, 0.0D, 0.0D, 0.0D);
        return InteractionResult.SUCCESS;
    }

}
