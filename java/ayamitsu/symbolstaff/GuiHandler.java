package ayamitsu.symbolstaff;

import ayamitsu.symbolstaff.client.gui.GuiContainerSymbolCase;
import ayamitsu.symbolstaff.inventory.ContainerSymbolCase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by ayamitsu0321 on 2015/11/22.
 */
public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0) {
            return new ContainerSymbolCase(player.inventory, world);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0) {
            return new GuiContainerSymbolCase(player.inventory, world);
        }

        return null;
    }

}
