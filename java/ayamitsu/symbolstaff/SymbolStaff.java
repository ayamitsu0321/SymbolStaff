package ayamitsu.symbolstaff;

import ayamitsu.symbolstaff.init.SymbolLoader;
import ayamitsu.symbolstaff.item.ItemSymbol;
import ayamitsu.symbolstaff.item.ItemSymbolStaff;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
        modid = SymbolStaff.MODID,
        name = SymbolStaff.NAME,
        version = SymbolStaff.VERSION
)
public class SymbolStaff {

    public static final String MODID = "symbolstaff";
    public static final String NAME = "SymbolStaff";
    public static final String VERSION = "1.0.0";

    @Mod.Instance("symbolstaff")
    public static SymbolStaff instance;

    @SidedProxy(clientSide = "ayamitsu.symbolstaff.client.ClientProxy", serverSide = "ayamitsu.symbolstaff.server.ServerProxy")
    public static AbstractProxy proxy;

    public static Item itemSymbol;
    public static Item itemSymbolStaff;
    public static Item itemSymbolCase;

    public static CreativeTabs tabSymbolStaff = new CreativeTabs("symbolstaff") {
        @Override
        public Item getTabIconItem() {
            return SymbolStaff.itemSymbol;
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        itemSymbol = new ItemSymbol().setUnlocalizedName("symbolstaff.symbol").setCreativeTab(tabSymbolStaff);
        itemSymbolStaff = new ItemSymbolStaff().setUnlocalizedName("symbolstaff.symbolstaff").setCreativeTab(tabSymbolStaff);
        itemSymbolCase = new ItemSymbolCase().setUnlocalizedName("symbolstaff.symbolcase").setCreativeTab(tabSymbolStaff);

        GameRegistry.registerItem(itemSymbol, "symbol");
        GameRegistry.registerItem(itemSymbolStaff, "symbol_staff");
        GameRegistry.registerItem(itemSymbolCase, "symbol_case");

        this.proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(SymbolStaff.instance, new GuiHandler());
        this.proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        SymbolLoader.init();
        this.proxy.postInit();
    }

}