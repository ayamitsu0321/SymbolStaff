package ayamitsu.symbolstaff.symbol;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayamitsu0321 on 2015/11/19.
 */
public final class Symbols {

    private static Map<String, TargetSymbol> targetSymbolMap = new HashMap<String, TargetSymbol>();
    private static Map<String, EffectSymbol> effectSymbolMap = new HashMap<String, EffectSymbol>();


    public static void addEffectSymbol(EffectSymbol symbol) {
        effectSymbolMap.put(symbol.name, symbol);
    }

    public static EffectSymbol getEffectSymbolFromName(String name) {
        return effectSymbolMap.get(name);
    }

    public static void addTargetSymbol(TargetSymbol symbol) {
        targetSymbolMap.put(symbol.name, symbol);
    }

    public static TargetSymbol getTargetSymbolFromName(String name) {
        return targetSymbolMap.get(name);
    }

    public static Collection<TargetSymbol> copyTargetSymbolList() {
        return targetSymbolMap.values();
    }

    public static Collection<EffectSymbol> copyEffectSymbolList() {
        return effectSymbolMap.values();
    }

}
