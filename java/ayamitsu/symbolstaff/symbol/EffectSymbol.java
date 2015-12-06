package ayamitsu.symbolstaff.symbol;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by ayamitsu0321 on 2015/11/20.
 */
public abstract class EffectSymbol extends Symbol {

    public EffectSymbol(String name) {
        super(name, SymbolCategory.EFFECT);
    }

    /**
     * entity Item#itemInteractionForEntity
     * block Item#onItemUse
     *
     * @return trueを返すと使用したように手を振る
     */
    /*public boolean onRightClickTarget(EntityPlayer player, MovingObjectPosition target, ItemStack staffItem) {
        return false;
    }*/

    /**
     * entity Item#itemInteractionForEntity
     *
     * @return trueを返すと使用したように手を振る
     */
    public boolean onRightClickEntity(ItemStack stack, EntityPlayer playerIn, Entity target) {
        return false;
    }

    /**
     * block Item#onItemUse
     *
     * @return trueを返すと使用したように手を振る
     */
    public boolean onRightClickBlock(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        return false;
    }

    /**
     * entity Item#onLeftClicnEntity
     * block TODO:Block固有のものがわからない。onEntitySwingで呼ぶと無差別になってしまう
     *
     * @return trueを返すとtargetがentityの場合、ダメージが入らない
     */
    /*public boolean onLeftClickTarget(EntityPlayer player, MovingObjectPosition target, ItemStack staffItem) {
        return false;
    }*/

    /**
     * entity Item#onLeftClicnEntity
     *
     * @return trueを返すとtargetにダメージが入らない
     */
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        return false;
    }

    /**
     * block TODO:Block固有のものがわからない。onEntitySwingで呼ぶと無差別になってしまう
     *
     * @return
     */
    public boolean onLeftClickBlock() {
        return false;
    }

    /**
     * Item#onItemRightClick
     */
    public void onRightClick(EntityPlayer player, ItemStack staffItem) {
    }

    /**
     * TODO:onEntitySwingで呼ぶとするとBlockを破壊時に連続してよばれるので保留
     */
    public void onLeftClick(EntityPlayer player, ItemStack staffItem) {
    }

    /**
     * Item#onUpdate
     */
    public void onUpdate(Entity entity, ItemStack staffItem, boolean isSelected) {
    }

}
