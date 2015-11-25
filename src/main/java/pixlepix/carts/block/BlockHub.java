package pixlepix.carts.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import pixlepix.carts.registry.ITTinkererBlock;
import pixlepix.carts.registry.ThaumicTinkererRecipe;
import pixlepix.carts.tile.TileHub;

import java.util.ArrayList;

/**
 * Created by pixlepix on 10/12/15.
 */
public class BlockHub extends Block implements ITTinkererBlock, ITileEntityProvider {

    public BlockHub() {
        super(Material.iron);
    }

    @Override
    public ArrayList<Object> getSpecialParameters() {
        return null;
    }

    @Override
    public String getBlockName() {
        return "railHub";
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
        return TileHub.class;
    }

    @Override
    public ThaumicTinkererRecipe getRecipeItem() {
        return null;
    }

    @Override
    public int getCreativeTabPriority() {
        return 0;
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     *
     * @param world
     * @param meta
     */
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
}
