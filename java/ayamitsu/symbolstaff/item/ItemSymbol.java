package ayamitsu.symbolstaff.item;

import ayamitsu.symbolstaff.SymbolStaff;
import ayamitsu.symbolstaff.symbol.EffectSymbol;
import ayamitsu.symbolstaff.symbol.Symbol;
import ayamitsu.symbolstaff.symbol.Symbols;
import ayamitsu.symbolstaff.symbol.TargetSymbol;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by ayamitsu0321 on 2015/11/21.
 */
public class ItemSymbol extends Item {

    public ItemSymbol() {
        super();
    }

    public String getUnlocalizedName(ItemStack stack) {
        NBTTagCompound nbt = stack.getTagCompound();
        if (nbt != null && nbt.hasKey("Category")) {
            String category = nbt.getString("Category");

            if (category.equals(Symbol.SymbolCategory.TARGET.name())) {
                return super.getUnlocalizedName() + "." + "target";
            } else if (category.equals(Symbol.SymbolCategory.EFFECT.name())) {
                return super.getUnlocalizedName() + "." + "effect";
            }
        }

        return super.getUnlocalizedName(stack);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
        if (stack.hasTagCompound()) {
            NBTTagCompound nbt = stack.getTagCompound();
            tooltip.add("Category: " + StatCollector.translateToLocal(nbt.getString("Category")));
            tooltip.add("Symbol: " + StatCollector.translateToLocal(nbt.getString("Symbol")));
        }
    }

    @SuppressWarnings("unchecked")
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
        //subItems.add(new ItemStack(itemIn, 1, 0));

        for (TargetSymbol symbol : Symbols.copyTargetSymbolList()) {
            ItemStack itemStack = new ItemStack(itemIn, 1, 0);
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setString("Symbol", symbol.name);
            nbt.setString("Category", symbol.category.name());
            itemStack.setTagCompound(nbt);
            subItems.add(itemStack);
        }

        for (EffectSymbol symbol : Symbols.copyEffectSymbolList()) {
            ItemStack itemStack = new ItemStack(itemIn, 1, 0);
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setString("Symbol", symbol.name);
            nbt.setString("Category", symbol.category.name());
            itemStack.setTagCompound(nbt);
            subItems.add(itemStack);
        }
    }

    public static ItemStack createTargetSymbolItemStack(TargetSymbol targetSymbol) {
        ItemStack is = new ItemStack(SymbolStaff.itemSymbol);
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString("Symbol", targetSymbol.name);
        nbt.setString("Category", targetSymbol.category.name());
        is.setTagCompound(nbt);
        return is;
    }

    public static ItemStack createEffectSymbolItemStack(EffectSymbol effectSymbol) {
        ItemStack is = new ItemStack(SymbolStaff.itemSymbol);
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString("Symbol", effectSymbol.name);
        nbt.setString("Category", effectSymbol.category.name());
        is.setTagCompound(nbt);
        return is;
    }

    public static TargetSymbol translateTargetSymbol(ItemStack itemStack) {
        NBTTagCompound nbt = itemStack.getTagCompound();

        if (nbt != null) {
            String category = nbt.getString("Category");
            String name = nbt.getString("Symbol");

            if (category.equals(Symbol.SymbolCategory.TARGET.name()) && name.length() > 0) {
                return Symbols.getTargetSymbolFromName(name);
            }
        }

        return null;
    }

    public static EffectSymbol translateEffectSymbol(ItemStack itemStack) {
        NBTTagCompound nbt = itemStack.getTagCompound();

        if (nbt != null) {
            String category = nbt.getString("Category");
            String name = nbt.getString("Symbol");

            if (category.equals(Symbol.SymbolCategory.EFFECT.name()) && name.length() > 0) {
                return Symbols.getEffectSymbolFromName(name);
            }
        }

        return null;
    }

    public static boolean isTargetSymbol(ItemStack itemStack) {
            return itemStack.getItem() instanceof ItemSymbol && translateTargetSymbol(itemStack) != null;
    }

    public static boolean isEffectSymbol(ItemStack itemStack) {
        return itemStack.getItem() instanceof ItemSymbol && translateEffectSymbol(itemStack) != null;
    }

}
