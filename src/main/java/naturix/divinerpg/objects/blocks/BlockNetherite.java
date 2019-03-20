package naturix.divinerpg.objects.blocks;

import java.util.List;
import java.util.Random;

import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockNetherite extends BlockOreNether {

	public BlockNetherite(String name) {
		super(name);
        setTickRandomly(true);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	} 

	
	@Override
    public int tickRate(World worldIn) {
        return 5;
    }
 
    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        detectInBB(pos, world);
        world.scheduleUpdate(pos, this, 5);
    }
 
    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        world.scheduleUpdate(pos, this, 5);
    }

    public void detectInBB (BlockPos pos, World world){
        double x = (double)pos.getX();
        double y = (double)pos.getY();
        double z = (double)pos.getZ();
        AxisAlignedBB extendBB = new AxisAlignedBB(x -0.1, y -0.1, z -0.1, x + 1.1,y +  1.1,z +  1.1);
        List<EntityLivingBase> entities = world.getEntitiesWithinAABB(EntityLivingBase.class, extendBB);
        for (EntityLivingBase entity : world.getEntitiesWithinAABB(EntityLivingBase.class, extendBB)) {
        	if (entity instanceof EntityLivingBase) {
                entity.attackEntityFrom(DamageSource.GENERIC, 1);
            }
        }
        List<EntityItem> items = world.getEntitiesWithinAABB(EntityItem.class, extendBB);
        for (EntityItem entityItem : world.getEntitiesWithinAABB(EntityItem.class, extendBB)) {
            entityItem.attackEntityFrom(DamageSource.ON_FIRE, 10);
        }
    }
}