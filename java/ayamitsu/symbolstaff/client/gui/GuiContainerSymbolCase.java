package ayamitsu.symbolstaff.client.gui;

import ayamitsu.symbolstaff.SymbolStaff;
import ayamitsu.symbolstaff.inventory.ContainerSymbolCase;
import ayamitsu.symbolstaff.item.ItemSymbol;
import ayamitsu.symbolstaff.item.ItemSymbolStaff;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.io.IOException;

/**
 * Created by ayamitsu0321 on 2015/11/22.
 */
public class GuiContainerSymbolCase extends GuiContainer {

    private static final ResourceLocation backgroundTexture = new ResourceLocation("symbolstaff", "/gui/symbolcase.png");

    public GuiContainerSymbolCase(InventoryPlayer playerInventory, World world) {
        super(new ContainerSymbolCase(playerInventory, world));
    }

    @Override
    public void initGui() {
        super.initGui();
        //this.buttonList.add(new GuiButton(0, 16, 42, 18, 10, "Done"));
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(backgroundTexture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}
