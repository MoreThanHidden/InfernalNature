package com.github.morethanhidden.MolecularGems.blocks;

import ibxm.Player;

import java.util.Random;

import com.github.morethanhidden.MolecularGems.MainRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockLiquidElectricOoze extends BlockFluidClassic{

        @SideOnly(Side.CLIENT)
        protected IIcon stillIcon;
        @SideOnly(Side.CLIENT)
        protected IIcon flowingIcon;
        
        public BlockLiquidElectricOoze(Fluid fluid, Material material) {
                super(fluid, material);
                setCreativeTab(MainRegistry.tabmoleculargems);
                setLightLevel(0.625F);
        }
        
        @Override
        public IIcon getIcon(int side, int meta) {
                return (side == 0 || side == 1)? stillIcon : flowingIcon;
        }
        
        @SideOnly(Side.CLIENT)
        @Override
        public void registerBlockIcons(IIconRegister register) {
                stillIcon = register.registerIcon("moleculargems:fluidStill");
                flowingIcon = register.registerIcon("moleculargems:fluidFlowing");
        }
        
        @Override
        public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
                if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
                return super.canDisplace(world, x, y, z);
        }
        
        @Override
        public boolean displaceIfPossible(World world, int x, int y, int z) {
                if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
                return super.displaceIfPossible(world, x, y, z);
        }
        
        @Override
        public void onEntityWalking(World world, int x, int y, int z, Entity e) {
        	if (MainRegistry.ShockingLiquid = true){
        	
        	world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z));   
        	EntityPlayer player = world.getClosestPlayer(x, y, z, 3);
        	
        	if (player != null){
        	player.addStat(MainRegistry.electrifying, 1);}
        	
        	}
        }
}
