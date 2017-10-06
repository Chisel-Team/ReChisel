package team.chisel.common.block;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class BlockCarvablePumpkin extends BlockPumpkin {
    public final static PropertyBool IS_LIGHTED = PropertyBool.create("lighted");

    BlockCarvablePumpkin() {
        this.setDefaultState(this.blockState.getBaseState()
                .withProperty(IS_LIGHTED, false)
                .withProperty(BlockPumpkin.FACING, EnumFacing.NORTH));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, BlockPumpkin.FACING, IS_LIGHTED);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return (state.getValue(BlockPumpkin.FACING).ordinal() - 2) | (state.getValue(IS_LIGHTED) ? 1 : 0) << 2;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState()
                .withProperty(BlockPumpkin.FACING, EnumFacing.values()[((meta & 0b0011) + 2)])
                .withProperty(IS_LIGHTED, ((meta >> 2) & 0b0001) == 1);
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        items.add(new ItemStack(this));
        items.add(new ItemStack(this,1, 1));
    }

    public enum PumpkinVariants {
        SURPRISED,
        HAPPY,
        JOY,
        MORTIFIED,
        CRINGING,
        AGAPE,
        GASP,
        UNAMUSED,
        SAD,
        UPSET,
        ELATED,
        DEPRESSED,
        ANTICIPATING,
        CONFUSED,
        SCREAMING,
        DERP,
        SINISTER
    }
}
