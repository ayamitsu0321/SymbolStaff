package ayamitsu.symbolstaff.symbol;

/**
 * Created by ayamitsu0321 on 2015/11/19.
 * <p/>
 * implemented class
 * EffectSymbol
 * TargetSymbol
 */
public class Symbol {

    public static enum SymbolCategory {
        TARGET,
        EFFECT
    }

    public final String name;
    public final SymbolCategory category;

    public Symbol(String name, SymbolCategory category) {
        this.name = name;
        this.category = category;
    }

}
