package pixlepix.carts.tile;

import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;

/**
 * Created by pixlepix on 10/12/15.
 */
public class TileRail extends TileEntity {

    public TileHub hub;
    public ArrayList<TileRail> rails = new ArrayList<>();
}
