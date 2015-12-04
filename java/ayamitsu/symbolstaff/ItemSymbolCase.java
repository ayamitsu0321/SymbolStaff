package ayamitsu.symbolstaff;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * Created by ayamitsu0321 on 2015/11/22.
 */
public class ItemSymbolCase extends Item {

    public ItemSymbolCase() {
        super();
    }

    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        // 0 means GUI ID
        playerIn.openGui(SymbolStaff.instance, 0, worldIn, MathHelper.ceiling_double_int(playerIn.posX), MathHelper.ceiling_double_int(playerIn.posY), MathHelper.ceiling_double_int(playerIn.posX));

        return itemStackIn;
    }

}
