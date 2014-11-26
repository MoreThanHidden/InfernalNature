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
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockLiquidFlamingOoze extends BlockFluidClassic{

        @SideOnly(Side.CLIENT)
        protected IIcon stillIcon;
        @SideOnly(Side.CLIENT)
        protected IIcon flowingIcon;
        
        private int tickcount = 0;
        
        public BlockLiquidFlamingOoze(Fluid fluid, Material material) {
                super(fluid, material);
                setCreativeTab(MainRegistry.tabmoleculargems);
        }
        
        @Override
        public IIcon getIcon(int side, int meta) {
                return (side == 0 || side == 1)? stillIcon : flowingIcon;
        }
        
        @SideOnly(Side.CLIENT)
        @Override
        public void registerBlockIcons(IIconRegister register) {
                stillIcon = register.registerIcon("moleculargems:fluidFlamingStill");
                flowingIcon = register.registerIcon("moleculargems:fluidFlamingFlowing");
                MainRegistry.liquidFlamingOoze.setIcons(stillIcon, flowingIcon);
        }
        
        
        
        @Override
        public void updateTick(World world, int x, int y, int z, Random rand)
        {
            int quantaRemaining = quantaPerBlock - world.getBlockMetadata(x, y, z);
            int expQuanta = -101;
            
            //Add 1 to the tick count integer
            
            
            if(tickcount >= 5){
            	world.setBlock(x, y, z, Blocks.air);
                world.setBlock(x, y, z, Blocks.fire);
                return;
    		}else{
            tickcount++;
            }
            
            // check adjacent block levels if non-source
            if (quantaRemaining < quantaPerBlock)
            {
                int y2 = y - densityDir;

                if (world.getBlock(x,     y2, z    ) == this ||
                    world.getBlock(x - 1, y2, z    ) == this ||
                    world.getBlock(x + 1, y2, z    ) == this ||
                    world.getBlock(x,     y2, z - 1) == this ||
                    world.getBlock(x,     y2, z + 1) == this)
                {
                    expQuanta = quantaPerBlock - 1;
                }
                else
                {
                    int maxQuanta = -100;
                    maxQuanta = getLargerQuanta(world, x - 1, y, z,     maxQuanta);
                    maxQuanta = getLargerQuanta(world, x + 1, y, z,     maxQuanta);
                    maxQuanta = getLargerQuanta(world, x,     y, z - 1, maxQuanta);
                    maxQuanta = getLargerQuanta(world, x,     y, z + 1, maxQuanta);

                    expQuanta = maxQuanta - 1;
                }

                // decay calculation
                if (expQuanta != quantaRemaining)
                {
                    quantaRemaining = expQuanta;

                    if (expQuanta <= 0)
                    {
                        world.setBlock(x, y, z, Blocks.air);
                        world.setBlock(x, y, z, Blocks.fire);
                        tickcount = 0;
                    }
                    else
                    {
                        world.setBlockMetadataWithNotify(x, y, z, quantaPerBlock - expQuanta, 3);
                        world.scheduleBlockUpdate(x, y, z, this, tickRate);
                        world.notifyBlocksOfNeighborChange(x, y, z, this);
                    }
                }
            }
            // This is a "source" block, set meta to zero, and send a server only update
            else if (quantaRemaining >= quantaPerBlock)
            {
                world.setBlockMetadataWithNotify(x, y, z, 0, 2);
            }

            // Flow vertically if possible
            if (canDisplace(world, x, y + densityDir, z))
            {
                flowIntoBlock(world, x, y + densityDir, z, 1);

                return;
            }

            // Flow outward if possible
            int flowMeta = quantaPerBlock - quantaRemaining + 1;
            if (flowMeta >= quantaPerBlock)
            {
            	return;
            }

            if (isSourceBlock(world, x, y, z) || !isFlowingVertically(world, x, y, z))
            {
                if (world.getBlock(x, y - densityDir, z) == this)
                {
                    flowMeta = 1;
                }
                boolean flowTo[] = getOptimalFlowDirections(world, x, y, z);

                if (flowTo[0]) flowIntoBlock(world, x - 1, y, z,     flowMeta);
                if (flowTo[1]) flowIntoBlock(world, x + 1, y, z,     flowMeta);
                if (flowTo[2]) flowIntoBlock(world, x,     y, z - 1, flowMeta);
                if (flowTo[3]) flowIntoBlock(world, x,     y, z + 1, flowMeta);
                

            }
            


        }
                       
        @Override
        public void onBlockAdded(World world, int x, int y, int z)
        {
            world.scheduleBlockUpdate(x, y, z, this, tickRate);
            tickcount = 0;
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
        
}
