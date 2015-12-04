package ayamitsu.symbolstaff.symbol;

import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by ayamitsu0321 on 2015/11/20.
 */
public abstract class TargetSymbol extends Symbol {

    public TargetSymbol(String name) {
        super(name, SymbolCategory.TARGET);
    }

    public abstract boolean matchTarget(MovingObjectPosition target, World world);

}
