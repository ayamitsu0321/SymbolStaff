package ayamitsu.symbolstaff.inventory;

import ayamitsu.symbolstaff.item.ItemSymbol;
import ayamitsu.symbolstaff.item.ItemSymbolStaff;
import ayamitsu.symbolstaff.symbol.EffectSymbol;
import ayamitsu.symbolstaff.symbol.TargetSymbol;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by ayamitsu0321 on 2015/11/22.
 */
public class ContainerSymbolCase extends Container {

    private IInventory caseInventory;
    private World worldInstance;

    public ContainerSymbolCase(InventoryPlayer playerInventory, World world) {
        super();

        this.worldInstance = world;
        this.caseInventory = new InventoryBasic("SymbolCase", false, 3) {
            @Override
            public void markDirty() {
                super.markDirty();
                ContainerSymbolCase.this.onCraftMatrixChanged(this);
            }

            @Override
            public int getInventoryStackLimit() {
                return 1;
            }
        };

        this.addSlotToContainer(new Slot(caseInventory, 0, 16, 17) {
                                    // SymbolStaffが3つめのスロット内にある状態で、いれるアイテムがTargetSymbolの場合にtrueを返し、いれられる
                                    @Override
                                    public boolean isItemValid(ItemStack stack) {
                                        return ContainerSymbolCase.this.getSlot(2) != null && ContainerSymbolCase.this.getSlot(2).getHasStack() && (ItemSymbol.isTargetSymbol(stack) || stack == null);
                                    }

                                    @Override
                                    public void onSlotChanged() {
                                        super.onSlotChanged();
                                        ItemStack is = this.getStack();

                                        if (is != null) {// SlotにItemがおかれたとき
                                            if (ItemSymbol.isTargetSymbol(is)) {
                                                ItemStack staff = ContainerSymbolCase.this.getSlot(2).getStack();

                                                if (staff != null && staff.getItem() instanceof ItemSymbolStaff) {
                                                    ItemSymbolStaff.setTargetSymbol(staff, ItemSymbol.translateTargetSymbol(is));
                                                }
                                            }
                                        } else {// このSlotからItemがなくなったとき
                                            ItemStack staff = ContainerSymbolCase.this.getSlot(2).getStack();

                                            if (staff != null && staff.getItem() instanceof ItemSymbolStaff) {
                                                ItemSymbolStaff.setTargetSymbol(staff, null);
                                            }
                                        }
                                    }
                                }
        );
        this.addSlotToContainer(new Slot(caseInventory, 1, 56, 17) {
                                    // SymbolStaffが3つめのスロット内にある状態で、いれるアイテムがEffectSymbolの場合にtrueを返し、いれられる
                                    @Override
                                    public boolean isItemValid(ItemStack stack) {
                                        return ContainerSymbolCase.this.getSlot(2) != null && ContainerSymbolCase.this.getSlot(2).getHasStack() && (ItemSymbol.isEffectSymbol(stack) || stack == null);
                                    }

                                    @Override
                                    public void onSlotChanged() {
                                        super.onSlotChanged();
                                        ItemStack is = this.getStack();

                                        if (is != null) {// SlotにItemがおかれたとき
                                            if (ItemSymbol.isEffectSymbol(is)) {
                                                ItemStack staff = ContainerSymbolCase.this.getSlot(2).getStack();

                                                if (staff != null && staff.getItem() instanceof ItemSymbolStaff) {
                                                    ItemSymbolStaff.setEffectSymbol(staff, ItemSymbol.translateEffectSymbol(is));
                                                }
                                            }
                                        } else {// このSlotからItemがなくなったとき
                                            ItemStack staff = ContainerSymbolCase.this.getSlot(2).getStack();

                                            if (staff != null && staff.getItem() instanceof ItemSymbolStaff) {
                                                ItemSymbolStaff.setEffectSymbol(staff, null);
                                            }
                                        }
                                    }
                                }
        );
        this.addSlotToContainer(new Slot(caseInventory, 2, 116, 35) {
                                    // SymbolStaffのみいれられる
                                    @Override
                                    public boolean isItemValid(ItemStack stack) {
                                        return stack.getItem() instanceof ItemSymbolStaff;
                                    }

                                    @Override
                                    public void onSlotChanged() {
                                        super.onSlotChanged();
                                        ItemStack is = this.getStack();

                                        if (is != null) {
                                            if (is.getItem() instanceof ItemSymbolStaff) {
                                                TargetSymbol targetSymbol = ItemSymbolStaff.getTargetSymbol(is);
                                                EffectSymbol effectSymbol = ItemSymbolStaff.getEffectSymbol(is);

                                                if (targetSymbol != null) {
                                                    ItemStack is1 = ItemSymbol.createTargetSymbolItemStack(targetSymbol);
                                                    ContainerSymbolCase.this.getSlot(0).putStack(is1);
                                                }

                                                if (effectSymbol != null) {
                                                    ItemStack is1 = ItemSymbol.createEffectSymbolItemStack(effectSymbol);
                                                    ContainerSymbolCase.this.getSlot(1).putStack(is1);
                                                }
                                            }
                                        } else {
                                            // TODO: SymbolStaffとItemSymbolが一致しているかの確認処理
                                            ContainerSymbolCase.this.getSlot(0).putStack(null);
                                            ContainerSymbolCase.this.getSlot(1).putStack(null);
                                        }
                                    }
                                }
        );

        int i;

        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 0 || index == 1 || index == 2) {
                if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
                    return null;
                }

            } else if (index >= 3 && index < 30) {
                if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
                    return null;
                }
            } else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(playerIn, itemstack1);
        }

        return itemstack;
    }

    public void onContainerClosed(EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);

        if (!this.worldInstance.isRemote) {
            // SymbolStaffのSlotのみ
            ItemStack itemstack = this.caseInventory.getStackInSlotOnClosing(2);

            if (itemstack != null) {
                playerIn.dropPlayerItemWithRandomChoice(itemstack, false);
            }

/*
            for (int i = 0; i < this.caseInventory.getSizeInventory(); ++i) {
                ItemStack itemstack = this.caseInventory.getStackInSlotOnClosing(i);

                if (itemstack != null) {
                    playerIn.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
*/
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }
}
