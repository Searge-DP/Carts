package pixlepix.carts.block;

import net.minecraft.block.BlockRailBase;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import pixlepix.carts.registry.ITTinkererBlock;
import pixlepix.carts.registry.ThaumicTinkererRecipe;
import pixlepix.carts.tile.TileRail;

import java.util.ArrayList;

/**
 * Created by pixlepix on 10/12/15.
 */
public class BlockRailAdv extends BlockRailBase implements ITTinkererBlock, ITileEntityProvider {
    public BlockRailAdv() {
        super(true);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        try {
            return getTileEntity().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Object> getSpecialParameters() {
        return null;
    }

    @Override
    public String getBlockName() {
        return "railRouter";
    }

    @Override
    public boolean shouldRegister() {
        return true;
    }

    @Override
    public boolean shouldDisplayInTab() {
        return true;
    }

    @Override
    public Class<? extends ItemBlock> getItemBlock() {
        return null;
    }

    @Override
    public Class<? extends TileEntity> getTileEntity() {
        return TileRail.class;
    }

    @Override
    public ThaumicTinkererRecipe getRecipeItem() {
        return null;
    }

    @Override
    public int getCreativeTabPriority() {
        return 0;
    }
}
