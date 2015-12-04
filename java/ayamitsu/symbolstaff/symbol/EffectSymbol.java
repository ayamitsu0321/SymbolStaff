package ayamitsu.symbolstaff.symbol;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;

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
    public boolean onRightClickTarget(EntityPlayer player, MovingObjectPosition target, ItemStack staffItem) {
        return false;
    }

    /**
     * entity Item#onLeftClicnEntity
     * block TODO:Block固有のものがわからない。onEntitySwingで呼ぶと無差別になってしまう
     *
     * @return trueを返すとtargetがentityの場合、ダメージが入らない
     */
    public boolean onLeftClickTarget(EntityPlayer player, MovingObjectPosition target, ItemStack staffItem) {
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
