package ayamitsu.symbolstaff.item;

import ayamitsu.symbolstaff.SymbolStaff;
import ayamitsu.symbolstaff.symbol.EffectSymbol;
import ayamitsu.symbolstaff.symbol.Symbols;
import ayamitsu.symbolstaff.symbol.TargetSymbol;
import static ayamitsu.symbolstaff.item.ItemSymbol.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by ayamitsu0321 on 2015/11/20.
 */
public class ItemSymbolStaff extends Item {

    public ItemSymbolStaff() {
        super();
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
        if (stack.hasTagCompound()) {
            NBTTagCompound nbt = stack.getTagCompound();
            tooltip.add("Target: " + nbt.getString("Target"));
            tooltip.add("Effect: " + nbt.getString("Effect"));
        }
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
        ItemStack itemStack = new ItemStack(itemIn, 1, 0);
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString("Target", "");
        nbt.setString("Effect", "");
        itemStack.setTagCompound(nbt);
        subItems.add(itemStack);
/*
        // test code
        itemStack = new ItemStack(itemIn, 1, 0);
        nbt = new NBTTagCompound();
        nbt.setString("Target", "VillagerOnly");
        nbt.setString("Effect", "LeftClickKill");
        itemStack.setTagCompound(nbt);
        subItems.add(itemStack);

        itemStack = new ItemStack(itemIn, 1, 0);
        nbt = new NBTTagCompound();
        nbt.setString("Target", "VillagerOnly");
        nbt.setString("Effect", "RightClickKill");
        itemStack.setTagCompound(nbt);
        subItems.add(itemStack);

        itemStack = new ItemStack(itemIn, 1, 0);
        nbt = new NBTTagCompound();
        nbt.setString("Target", "ZombieOnly");
        nbt.setString("Effect", "LeftClickKill");
        itemStack.setTagCompound(nbt);
        subItems.add(itemStack);

        itemStack = new ItemStack(itemIn, 1, 0);
        nbt = new NBTTagCompound();
        nbt.setString("Target", "ZombieOnly");
        nbt.setString("Effect", "RightClickKill");
        itemStack.setTagCompound(nbt);
        subItems.add(itemStack);
*/
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        TargetSymbol targetSymbol = getTargetSymbol(stack);

        if (targetSymbol != null) {
            // TODO:引数のVec3の値があっているか
            MovingObjectPosition mov = new MovingObjectPosition(new Vec3(pos.getX(), pos.getY(), pos.getZ()), side, pos);

            if (targetSymbol.matchTarget(mov, worldIn)) {
                EffectSymbol effectSymbol = getEffectSymbol(stack);

                if (effectSymbol != null) {
                    // event
                    return effectSymbol.onRightClickTarget(playerIn, mov, stack);
                }
            }
        }

        return false;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        EffectSymbol effectSymbol = getEffectSymbol(itemStackIn);

        if (effectSymbol != null) {
            // event
            effectSymbol.onRightClick(playerIn, itemStackIn);
        }

        return itemStackIn;
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target) {
        TargetSymbol targetSymbol = getTargetSymbol(stack);

        if (targetSymbol != null) {
            MovingObjectPosition mov = new MovingObjectPosition(target);

            if (targetSymbol.matchTarget(mov, playerIn.worldObj)) {
                EffectSymbol effectSymbol = getEffectSymbol(stack);

                if (effectSymbol != null) {
                    // event
                    return effectSymbol.onRightClickTarget(playerIn, mov, stack);
                }
            }
        }

        return false;
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        EffectSymbol effectSymbol = getEffectSymbol(stack);

        if (effectSymbol != null) {
            // event
            effectSymbol.onUpdate(entityIn, stack, isSelected);
        }
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        TargetSymbol targetSymbol = getTargetSymbol(stack);

        if (targetSymbol != null) {
            MovingObjectPosition mov = new MovingObjectPosition(entity);

            if (targetSymbol.matchTarget(mov, player.worldObj)) {
                EffectSymbol effectSymbol = getEffectSymbol(stack);

                if (effectSymbol != null) {
                    // event
                    effectSymbol.onLeftClickTarget(player, mov, stack);
                }
            }
        }

        return false;
    }
/*
    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        return false;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, BlockPos pos, EntityLivingBase playerIn) {
        return false;
    }

    @Override
    public boolean canHarvestBlock(Block blockIn) {
        return false;
    }

    @Override
    public float getDigSpeed(ItemStack itemstack, net.minecraft.block.state.IBlockState state) {
        return getStrVsBlock(itemstack, state.getBlock());
    }

    @Override
    public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem) {
        return false;
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        return false;
    }
*/

    public static NBTTagCompound createSymbolStaffNBT(TargetSymbol targetSymbol, EffectSymbol effectSymbol) {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString("Target", targetSymbol.name);
        nbt.setString("Effect", effectSymbol.name);
        return nbt;
    }

    public static ItemStack createSymbolStaffItemStack(TargetSymbol targetSymbol, EffectSymbol effectSymbol) {
        ItemStack itemStack = new ItemStack(SymbolStaff.itemSymbolStaff);
        NBTTagCompound nbt = createSymbolStaffNBT(targetSymbol, effectSymbol);
        itemStack.setTagCompound(nbt);
        return itemStack;
    }

    public static TargetSymbol getTargetSymbol(ItemStack staff) {
        NBTTagCompound nbt = staff.getTagCompound();

        if (nbt == null) {
            return null;
        }

        return Symbols.getTargetSymbolFromName(nbt.getString("Target"));
    }

    public static EffectSymbol getEffectSymbol(ItemStack staff) {
        NBTTagCompound nbt = staff.getTagCompound();

        if (nbt == null) {
            return null;
        }

        return Symbols.getEffectSymbolFromName(nbt.getString("Effect"));
    }

    public static void setTargetSymbol(ItemStack staff, TargetSymbol targetSymbol) {
        NBTTagCompound nbt = staff.getTagCompound();

        if (nbt == null) {
            nbt = new NBTTagCompound();
            staff.setTagCompound(nbt);
        }

        if (targetSymbol != null) {
            nbt.setString("Target", targetSymbol.name);
        } else {
            nbt.setString("Target", "");
        }
    }

    public static void setEffectSymbol(ItemStack staff, EffectSymbol effectSymbol) {
        NBTTagCompound nbt = staff.getTagCompound();

        if (nbt == null) {
            nbt = new NBTTagCompound();
            staff.setTagCompound(nbt);
        }

        if (effectSymbol != null) {
            nbt.setString("Effect", effectSymbol.name);
        } else {
            nbt.setString("Effect", "");
        }
    }

}
