package ayamitsu.symbolstaff.client;

import ayamitsu.symbolstaff.AbstractProxy;
import ayamitsu.symbolstaff.GuiHandler;
import ayamitsu.symbolstaff.SymbolStaff;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * Created by ayamitsu0321 on 2015/11/19.
 */
public class ClientProxy extends AbstractProxy {
    @Override
    public void preInit() {
        ModelLoader.setCustomModelResourceLocation(SymbolStaff.itemSymbol, 0, new ModelResourceLocation(new ResourceLocation(SymbolStaff.MODID, "symbol"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(SymbolStaff.itemSymbolStaff, 0, new ModelResourceLocation(new ResourceLocation(SymbolStaff.MODID, "symbol_staff"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(SymbolStaff.itemSymbolCase, 0, new ModelResourceLocation(new ResourceLocation(SymbolStaff.MODID, "symbol_case"), "inventory"));
    }

    @Override
    public void init() {

    }

    @Override
    public void postInit() {

    }
}
