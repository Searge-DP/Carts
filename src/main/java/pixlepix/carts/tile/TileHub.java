package pixlepix.carts.tile;

import net.minecraft.block.BlockRailBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import pixlepix.carts.block.BlockRailAdv;
import pixlepix.carts.data.CoordTuple;

import java.util.ArrayList;

/**
 * Created by pixlepix on 10/12/15.
 */
public class TileHub extends TileEntity {

    public ArrayList<TileRail> connectedRails = new ArrayList<TileRail>();

    public void updateEntity(){

        //Build a network
        if(connectedRails.isEmpty() || worldObj.getTotalWorldTime() % 600 == 0){
            ArrayList queue = new ArrayList();
            queue.add(new CoordTuple(xCoord, yCoord, zCoord));
            connectedRails.clear();

            //Find all connected rails
            while(!queue.isEmpty()){
                CoordTuple t = (CoordTuple) queue.remove(0);
                if(worldObj.blockExists(t.getX(), t.getY(), t.getZ()) && t.getBlock(worldObj) instanceof BlockRailBase){

                    if(t.getBlock(worldObj) instanceof BlockRailAdv) {
                        TileRail tileRail = (TileRail) t.getTile(worldObj);
                        tileRail.hub = this;
                        connectedRails.add(tileRail);

                        for (ForgeDirection d : ForgeDirection.VALID_DIRECTIONS) {
                            queue.add(t.add(d));
                        }
                    }
                }
            }

            //Find connections between all the carts
            for(TileRail rail : connectedRails){
                queue = new ArrayList();
                queue.add(new CoordTuple(xCoord, yCoord, zCoord));
                rail.rails.clear();

                while(!queue.isEmpty()){
                    CoordTuple t = (CoordTuple) queue.remove(0);
                    if(worldObj.blockExists(t.getX(), t.getY(), t.getZ()) && t.getBlock(worldObj) instanceof BlockRailBase) {
                        if(t.getBlock(worldObj) instanceof BlockRailAdv){
                            rail.rails.add((TileRail) t.getTile(worldObj));
                        }else{
                            for (ForgeDirection d : ForgeDirection.VALID_DIRECTIONS) {
                                queue.add(t.add(d));
                            }
                        }
                    }
                }

            }
        }
    }


}
