package ayamitsu.symbolstaff.init;

import ayamitsu.symbolstaff.symbol.EffectSymbol;
import net.minecraft.block.*;
import ayamitsu.symbolstaff.symbol.TargetSymbol;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityMinecartCommandBlock;
import net.minecraft.entity.ai.EntityMinecartMobSpawner;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.*;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemColored;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

import static ayamitsu.symbolstaff.symbol.Symbols.*;

/**
 * Created by ayamitsu0321 on 2015/12/01.
 */
public final class SymbolLoader {

    public static void init() {
        addTargetSymbols();
        addEffectSymbols();
    }

    private static void addTargetSymbols() {
        // entity
        // from EntityList
        addTargetSymbol(new TargetSymbol("Item") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityItem.class);
            }
        });

        addTargetSymbol(new TargetSymbol("XPOrb") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityXPOrb.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Painting") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityPainting.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Arrow") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityArrow.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Snowball") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntitySnowball.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Fireball") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityFireball.class);
            }
        });

        addTargetSymbol(new TargetSymbol("SmallFireball") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntitySmallFireball.class);
            }
        });

        addTargetSymbol(new TargetSymbol("EnderPearl") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityEnderPearl.class);
            }
        });

        addTargetSymbol(new TargetSymbol("EnderEye") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityEnderEye.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Potion") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityPotion.class);
            }
        });

        addTargetSymbol(new TargetSymbol("ExpBottle") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityExpBottle.class);
            }
        });

        addTargetSymbol(new TargetSymbol("ItemFrame") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityItemFrame.class);
            }
        });

        addTargetSymbol(new TargetSymbol("WitherSkull") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityWitherSkull.class);
            }
        });

        addTargetSymbol(new TargetSymbol("PrimedTNT") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityTNTPrimed.class);
            }
        });

        addTargetSymbol(new TargetSymbol("FallingBlock") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityFallingBlock.class);
            }
        });

        addTargetSymbol(new TargetSymbol("FireworkRocket") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityFireworkRocket.class);
            }
        });

        addTargetSymbol(new TargetSymbol("ArmorStand") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityArmorStand.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Boat") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityBoat.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Minecart") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit instanceof EntityMinecart;
            }
        });

        addTargetSymbol(new TargetSymbol("MinecartRidable") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityMinecartEmpty.class);
            }
        });

        addTargetSymbol(new TargetSymbol("MinecartChest") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityMinecartChest.class);
            }
        });

        addTargetSymbol(new TargetSymbol("MinecartFurnace") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityMinecartFurnace.class);
            }
        });

        addTargetSymbol(new TargetSymbol("MinecartTNT") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityMinecartTNT.class);
            }
        });

        addTargetSymbol(new TargetSymbol("MinecartSpawner") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityMinecartMobSpawner.class);
            }
        });

        addTargetSymbol(new TargetSymbol("MinecartHopper") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityMinecartHopper.class);
            }
        });

        addTargetSymbol(new TargetSymbol("MinecartCommandBlock") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityMinecartCommandBlock.class);
            }
        });

        addTargetSymbol(new TargetSymbol("EnderCrystal") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityEnderCrystal.class);
            }
        });

        // mob
        addTargetSymbol(new TargetSymbol("Creeper") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityCreeper.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Skeleton") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntitySkeleton.class)
                        && ((EntitySkeleton)target.entityHit).getSkeletonType() == 0;
            }
        });

        addTargetSymbol(new TargetSymbol("WitherSkeleton") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntitySkeleton.class)
                        && ((EntitySkeleton)target.entityHit).getSkeletonType() == 1;
            }
        });

        addTargetSymbol(new TargetSymbol("Spider") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().getClass().equals(EntitySpider.class);
            }
        });

        addTargetSymbol(new TargetSymbol("GiantZombie") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityGiantZombie.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Zombie") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityZombie.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Slime") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntitySlime.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Ghast") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityGhast.class);
            }
        });

        addTargetSymbol(new TargetSymbol("PigZombie") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityPigZombie.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Enderman") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityEnderman.class);
            }
        });

        addTargetSymbol(new TargetSymbol("CaveSpider") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityCaveSpider.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Silverfish") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntitySilverfish.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Blaze") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityBlaze.class);
            }
        });

        addTargetSymbol(new TargetSymbol("MagmaCube") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityMagmaCube.class);
            }
        });

        addTargetSymbol(new TargetSymbol("EnderDragon") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityDragon.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Wither") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityWither.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Bat") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityBat.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Witch") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityWitch.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Endermite") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityEndermite.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Guardian") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityGuardian.class)
                        && !((EntityGuardian)target.entityHit).isElder();
            }
        });

        addTargetSymbol(new TargetSymbol("ElderGuardian") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityGuardian.class)
                        && ((EntityGuardian)target.entityHit).isElder();
            }
        });

        addTargetSymbol(new TargetSymbol("Pig") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityPig.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Sheep") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntitySheep.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Cow") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityCow.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Chicken") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityChicken.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Squid") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntitySquid.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Wolf") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityWolf.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Mooshroom") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityMooshroom.class);
            }
        });

        addTargetSymbol(new TargetSymbol("SnowGolem") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntitySnowman.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Ocelot") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityOcelot.class);
            }
        });

        addTargetSymbol(new TargetSymbol("IronGolem") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityIronGolem.class);
            }
        });

        addTargetSymbol(new TargetSymbol("HorseType") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityHorse.class);
            }
        });

        addTargetSymbol(new TargetSymbol("FriendlyHorse") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityHorse.class)
                        && (((EntityHorse)target.entityHit).getHorseType() == 0
                        || ((EntityHorse)target.entityHit).getHorseType() == 1
                        || ((EntityHorse)target.entityHit).getHorseType() == 2);
            }
        });

        addTargetSymbol(new TargetSymbol("HostileHorse") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityHorse.class)
                        && (((EntityHorse)target.entityHit).getHorseType() == 3
                        || ((EntityHorse)target.entityHit).getHorseType() == 4);
            }
        });

        addTargetSymbol(new TargetSymbol("Horse") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityHorse.class)
                        && ((EntityHorse)target.entityHit).getHorseType() == 0;
            }
        });

        addTargetSymbol(new TargetSymbol("Donkey") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityHorse.class)
                        && ((EntityHorse)target.entityHit).getHorseType() == 1;
            }
        });

        addTargetSymbol(new TargetSymbol("Mule") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityHorse.class)
                        && ((EntityHorse)target.entityHit).getHorseType() == 2;
            }
        });

        addTargetSymbol(new TargetSymbol("ZombieHorse") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityHorse.class)
                        && ((EntityHorse)target.entityHit).getHorseType() == 3;
            }
        });

        addTargetSymbol(new TargetSymbol("SkeletonHorse") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityHorse.class)
                        && ((EntityHorse)target.entityHit).getHorseType() == 4;
            }
        });

        addTargetSymbol(new TargetSymbol("Rabbit") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityRabbit.class);
            }
        });

        addTargetSymbol(new TargetSymbol("Villager") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                return target.typeOfHit == MovingObjectType.ENTITY
                        && target.entityHit != null
                        && target.entityHit.getClass().equals(EntityVillager.class);
            }
        });
/*
        // block
        //addTargetSymbolSimpleBllock(Blocks.air);




*/
        for (Object obj : Block.blockRegistry) {
            if (obj instanceof Block) {
                final Block block = (Block)obj;
                BlockState blockstate = block.getBlockState();

                if (blockstate.getProperties().size() <= 0) {// Propertyを持たないBlock
                    Item item = Item.getItemFromBlock(block);

                    // Blocks.air にはItemがないのでチェックしておく
                    if (item != null) {
                        addTargetSymbol(new TargetSymbol(item.getUnlocalizedName() + ".name") {
                            @Override
                            public boolean matchTarget(MovingObjectPosition target, World world) {
                                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                                    IBlockState state = world.getBlockState(target.getBlockPos());
                                    return state != null && state.getBlock() == block;
                                }

                                return false;
                            }
                        });
                    }
                } else {
                    Item item = Item.getItemFromBlock(block);

                    if (item != null) {
                        //System.out.println(item.getUnlocalizedName());
                    }
                }
            }
        }

        // 個別対応とかいう地獄の始まりだよ
        // Propertyを持つBlock

        addTargetSymbolSimpleBllock(Blocks.stone, "StoneType");

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.stone.getUnlocalizedName(), BlockStone.EnumType.byMetadata(0).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.stone
                                && ((BlockStone.EnumType)state.getValue(BlockStone.VARIANT)).getMetadata() == 0;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.stone.getUnlocalizedName(), BlockStone.EnumType.byMetadata(1).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.stone
                                && ((BlockStone.EnumType)state.getValue(BlockStone.VARIANT)).getMetadata() == 1;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.stone.getUnlocalizedName(), BlockStone.EnumType.byMetadata(2).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.stone
                                && ((BlockStone.EnumType)state.getValue(BlockStone.VARIANT)).getMetadata() == 2;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.stone.getUnlocalizedName(), BlockStone.EnumType.byMetadata(3).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.stone
                                && ((BlockStone.EnumType)state.getValue(BlockStone.VARIANT)).getMetadata() == 3;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.stone.getUnlocalizedName(), BlockStone.EnumType.byMetadata(4).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.stone
                                && ((BlockStone.EnumType)state.getValue(BlockStone.VARIANT)).getMetadata() == 4;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.stone.getUnlocalizedName(), BlockStone.EnumType.byMetadata(5).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.stone
                                && ((BlockStone.EnumType)state.getValue(BlockStone.VARIANT)).getMetadata() == 5;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.stone.getUnlocalizedName(), BlockStone.EnumType.byMetadata(6).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.stone
                                && ((BlockStone.EnumType)state.getValue(BlockStone.VARIANT)).getMetadata() == 6;
                    }
                }

                return false;
            }
        });

        addTargetSymbolSimpleBllock(Blocks.grass);

        addTargetSymbolSimpleBllock(Blocks.dirt, "DirtType");

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.dirt.getUnlocalizedName(), BlockDirt.DirtType.byMetadata(0).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.dirt
                                && ((BlockDirt.DirtType)state.getValue(BlockDirt.VARIANT)).getMetadata() == 0;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.dirt.getUnlocalizedName(), BlockDirt.DirtType.byMetadata(1).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.dirt
                                && ((BlockDirt.DirtType)state.getValue(BlockDirt.VARIANT)).getMetadata() == 1;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.dirt.getUnlocalizedName(), BlockDirt.DirtType.byMetadata(2).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.dirt
                                && ((BlockDirt.DirtType)state.getValue(BlockDirt.VARIANT)).getMetadata() == 2;
                    }
                }

                return false;
            }
        });

        //addTargetSymbolSimpleBllock(Blocks.cobblestone);

        addTargetSymbolSimpleBllock(Blocks.planks, "WoodenPlanksType");

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.planks.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(0).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.planks
                                && ((BlockPlanks.EnumType)state.getValue(BlockPlanks.VARIANT)).getMetadata() == 0;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.planks.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(1).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.planks
                                && ((BlockPlanks.EnumType)state.getValue(BlockPlanks.VARIANT)).getMetadata() == 1;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.planks.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(2).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.planks
                                && ((BlockPlanks.EnumType)state.getValue(BlockPlanks.VARIANT)).getMetadata() == 2;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.planks.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(3).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.planks
                                && ((BlockPlanks.EnumType)state.getValue(BlockPlanks.VARIANT)).getMetadata() == 3;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.planks.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(4).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.planks
                                && ((BlockPlanks.EnumType)state.getValue(BlockPlanks.VARIANT)).getMetadata() == 4;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.planks.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(5).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.planks
                                && ((BlockPlanks.EnumType)state.getValue(BlockPlanks.VARIANT)).getMetadata() == 5;
                    }
                }

                return false;
            }
        });

        addTargetSymbolSimpleBllock(Blocks.sapling, "SaplingType");

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.sapling.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(0).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.sapling
                                && ((BlockPlanks.EnumType)state.getValue(BlockSapling.TYPE)).getMetadata() == 0;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.sapling.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(1).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.sapling
                                && ((BlockPlanks.EnumType)state.getValue(BlockSapling.TYPE)).getMetadata() == 1;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.sapling.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(2).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.sapling
                                && ((BlockPlanks.EnumType)state.getValue(BlockSapling.TYPE)).getMetadata() == 2;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.sapling.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(3).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.sapling
                                && ((BlockPlanks.EnumType)state.getValue(BlockSapling.TYPE)).getMetadata() == 3;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.sapling.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(4).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.sapling
                                && ((BlockPlanks.EnumType)state.getValue(BlockSapling.TYPE)).getMetadata() == 4;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.sapling.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(5).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.sapling
                                && ((BlockPlanks.EnumType)state.getValue(BlockSapling.TYPE)).getMetadata() == 5;
                    }
                }

                return false;
            }
        });

        //addTargetSymbolSimpleBllock(Blocks.bedrock);

        addTargetSymbolSimpleBllock(Blocks.sand, "SandType");

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.sand.getUnlocalizedName(), BlockSand.EnumType.byMetadata(0).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.sand
                                && ((BlockSand.EnumType)state.getValue(BlockSand.VARIANT)).getMetadata() == 0;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.sand.getUnlocalizedName(), BlockSand.EnumType.byMetadata(1).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.sand
                                && ((BlockSand.EnumType)state.getValue(BlockSand.VARIANT)).getMetadata() == 1;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol("LogType") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());
                    return state != null
                            && (state.getBlock() == Blocks.log
                            || state.getBlock() == Blocks.log2);
                }

                return false;
            }

            ;
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.log.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(0).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.log
                                && ((BlockPlanks.EnumType)state.getValue(BlockPlanks.VARIANT)).getMetadata() == 0;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.log.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(1).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.log
                                && ((BlockPlanks.EnumType)state.getValue(BlockPlanks.VARIANT)).getMetadata() == 1;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.log.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(2).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.log
                                && ((BlockPlanks.EnumType)state.getValue(BlockPlanks.VARIANT)).getMetadata() == 2;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.log.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(3).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.log
                                && ((BlockPlanks.EnumType)state.getValue(BlockPlanks.VARIANT)).getMetadata() == 3;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.log2.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(0).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.log2
                                && ((BlockPlanks.EnumType)state.getValue(BlockPlanks.VARIANT)).getMetadata() == 0;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.log2.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(1).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.log2
                                && ((BlockPlanks.EnumType)state.getValue(BlockPlanks.VARIANT)).getMetadata() == 1;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol("LeavesType") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());
                    return state != null
                            && (state.getBlock() == Blocks.leaves
                            || state.getBlock() == Blocks.leaves2);
                }

                return false;
            }

            ;
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.leaves.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(0).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.leaves
                                && ((BlockPlanks.EnumType)state.getValue(BlockPlanks.VARIANT)).getMetadata() == 0;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.leaves.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(1).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.leaves
                                && ((BlockPlanks.EnumType)state.getValue(BlockPlanks.VARIANT)).getMetadata() == 1;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.leaves.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(2).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.leaves
                                && ((BlockPlanks.EnumType)state.getValue(BlockPlanks.VARIANT)).getMetadata() == 2;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.leaves.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(3).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.leaves
                                && ((BlockPlanks.EnumType)state.getValue(BlockPlanks.VARIANT)).getMetadata() == 3;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.leaves2.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(0).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.leaves2
                                && ((BlockPlanks.EnumType)state.getValue(BlockPlanks.VARIANT)).getMetadata() == 0;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.leaves2.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(1).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.leaves2
                                && ((BlockPlanks.EnumType)state.getValue(BlockPlanks.VARIANT)).getMetadata() == 1;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.leaves2.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(1).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.leaves2
                                && ((BlockPlanks.EnumType)state.getValue(BlockPlanks.VARIANT)).getMetadata() == 1;
                    }
                }

                return false;
            }
        });

        addTargetSymbolSimpleBllock(Blocks.sponge, "SpongeType");

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.sponge.getUnlocalizedName(), "dry")) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.sponge
                                && !((Boolean)state.getValue(BlockSponge.WET)).booleanValue();
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.sponge.getUnlocalizedName(), "wet")) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.sponge
                                && ((Boolean)state.getValue(BlockSponge.WET)).booleanValue();
                    }
                }

                return false;
            }
        });

        addTargetSymbolSimpleBllock(Blocks.dispenser);

        addTargetSymbolSimpleBllock(Blocks.sandstone, "SandstoneType");

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.sandstone.getUnlocalizedName(), BlockSandStone.EnumType.byMetadata(0).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.sandstone
                                && ((BlockSandStone.EnumType)state.getValue(BlockSandStone.TYPE)).getMetadata() == 0;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.sandstone.getUnlocalizedName(), BlockSandStone.EnumType.byMetadata(1).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.sandstone
                                && ((BlockSandStone.EnumType)state.getValue(BlockSandStone.TYPE)).getMetadata() == 1;
                    }
                }

                return false;
            }
        });

        addTargetSymbolSimpleBllock(Blocks.golden_rail);

        addTargetSymbolSimpleBllock(Blocks.detector_rail);

        addTargetSymbolSimpleBllock(Blocks.sticky_piston);

        addTargetSymbolSimpleBllock(Blocks.tallgrass, "TallGrassType");

        ItemColored tall_grass = (ItemColored)Item.getItemFromBlock(Blocks.tallgrass);
        ItemStack is_tall_grass = new ItemStack(tall_grass, 1, 0);

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(tall_grass.getUnlocalizedName(is_tall_grass))) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.tallgrass
                                && ((BlockTallGrass.EnumType)state.getValue(BlockTallGrass.TYPE)).getMeta() == 0;
                    }
                }

                return false;
            }
        });

        is_tall_grass = new ItemStack(tall_grass, 1, 1);

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(tall_grass.getUnlocalizedName(is_tall_grass))) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.tallgrass
                                && ((BlockTallGrass.EnumType)state.getValue(BlockTallGrass.TYPE)).getMeta() == 1;
                    }
                }

                return false;
            }
        });

        is_tall_grass = new ItemStack(tall_grass, 1, 2);

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(tall_grass.getUnlocalizedName(is_tall_grass))) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.tallgrass
                                && ((BlockTallGrass.EnumType)state.getValue(BlockTallGrass.TYPE)).getMeta() == 2;
                    }
                }

                return false;
            }
        });

        addTargetSymbolSimpleBllock(Blocks.piston);

        addTargetSymbolSimpleBllock(Blocks.wool, "WoolType");

        int i;
        int value = EnumDyeColor.values().length;// 16
        for (i = 0; i < value; i++) {
            addBlockColoredTarget(Blocks.wool, i);
        }

        addTargetSymbol(new TargetSymbol("FlowerType") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());
                    return state != null
                            && (state.getBlock() == Blocks.yellow_flower
                            || state.getBlock() == Blocks.red_flower);
                }

                return false;
            }

            ;
        });

        addBlockFlower(Blocks.yellow_flower, 0);

        value = 8;
        for (i = 0; i < value; i++) {
            addBlockFlower(Blocks.red_flower, i);
        }

        addTargetSymbol(new TargetSymbol("StoneSlabType") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());
                    return state != null
                            && (state.getBlock() == Blocks.stone_slab
                            || state.getBlock() == Blocks.double_stone_slab
                            || state.getBlock() == Blocks.stone_slab2
                            ||state.getBlock() == Blocks.double_stone_slab2);
                }

                return false;
            };
        });

        value = BlockStoneSlab.EnumType.values().length;
        for (i = 0; i < value; i++) {
            addBlockStoneSlab(Blocks.stone_slab, Blocks.double_stone_slab, i);
        }

        value = BlockStoneSlabNew.EnumType.values().length;
        for (i = 0; i < value; i++) {
            addBlockStoneSlab2(Blocks.double_stone_slab2, Blocks.stone_slab2, i);
        }

        addTargetSymbolSimpleBllock(Blocks.tnt);

        addTargetSymbolSimpleBllock(Blocks.torch);

        addTargetSymbolSimpleBllock(Blocks.oak_stairs);

        addTargetSymbolSimpleBllock(Blocks.chest);

        addTargetSymbolSimpleBllock(Blocks.farmland);//

        addTargetSymbol(new TargetSymbol(Blocks.furnace.getUnlocalizedName() + ".name") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());
                    return state != null
                            && (state.getBlock() == Blocks.furnace
                            || state.getBlock() == Blocks.lit_furnace);
                }

                return false;
            };
        });

        addTargetSymbolSimpleBllock(Blocks.ladder);

        addTargetSymbolSimpleBllock(Blocks.rail);

        addTargetSymbolSimpleBllock(Blocks.stone_stairs);

        addTargetSymbolSimpleBllock(Blocks.lever);

        addTargetSymbolSimpleBllock(Blocks.stone_pressure_plate);

        addTargetSymbolSimpleBllock(Blocks.wooden_pressure_plate);

        addTargetSymbolSimpleBllock(Blocks.redstone_torch);

        addTargetSymbolSimpleBllock(Blocks.stone_button);

        addTargetSymbolSimpleBllock(Blocks.snow_layer);

        addTargetSymbolSimpleBllock(Blocks.cactus);

        addTargetSymbolSimpleBllock(Blocks.jukebox);

        addTargetSymbolSimpleBllock(Blocks.oak_fence);

        addTargetSymbolSimpleBllock(Blocks.pumpkin);

        addTargetSymbolSimpleBllock(Blocks.lit_pumpkin);

        addTargetSymbolSimpleBllock(Blocks.stained_glass, "StainedGlassType");

        value = EnumDyeColor.values().length;
        for (i = 0; i < value; i++) {
            addBlockStainedGlass(Blocks.stained_glass, i);
        }

        addTargetSymbolSimpleBllock(Blocks.trapdoor);

        addTargetSymbolSimpleBllock(Blocks.monster_egg, "MonsterEggBlockType");

        value = BlockSilverfish.EnumType.values().length;
        for (i = 0; i < value; i++) {
            addBlockSilverfish(i);
        }

        addTargetSymbolSimpleBllock(Blocks.stonebrick, "StoneBricksType");

        value = BlockStoneBrick.EnumType.values().length;
        for (i = 0; i< value; i++) {
            addStoneBrick(i);
        }

        addTargetSymbolSimpleBllock(Blocks.brown_mushroom_block);

        addTargetSymbolSimpleBllock(Blocks.red_mushroom_block);

        addTargetSymbolSimpleBllock(Blocks.iron_bars);

        addTargetSymbolSimpleBllock(Blocks.glass_pane);

        addTargetSymbolSimpleBllock(Blocks.vine);

        addTargetSymbolSimpleBllock(Blocks.oak_fence_gate);

        addTargetSymbolSimpleBllock(Blocks.brick_stairs);

        addTargetSymbolSimpleBllock(Blocks.stone_brick_stairs);

        addTargetSymbolSimpleBllock(Blocks.mycelium);

        addTargetSymbolSimpleBllock(Blocks.nether_brick_fence);

        addTargetSymbolSimpleBllock(Blocks.nether_brick_stairs);

        addTargetSymbolSimpleBllock(Blocks.end_portal_frame);

        addTargetSymbol(new TargetSymbol("WoodenSlabType") {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());
                    return state != null
                            && (state.getBlock() == Blocks.wooden_slab
                            || state.getBlock() == Blocks.double_wooden_slab);
                }

                return false;
            };
        });

        value = BlockPlanks.EnumType.values().length;
        for (i = 0; i < value; i++) {
            addBlockWoodSlab(Blocks.wooden_slab, Blocks.double_wooden_slab, i);
        }

        addTargetSymbolSimpleBllock(Blocks.sandstone_stairs);

        addTargetSymbolSimpleBllock(Blocks.ender_chest);

        addTargetSymbolSimpleBllock(Blocks.tripwire);

        addTargetSymbolSimpleBllock(Blocks.spruce_stairs);

        addTargetSymbolSimpleBllock(Blocks.birch_stairs);

        addTargetSymbolSimpleBllock(Blocks.jungle_stairs);

        addTargetSymbolSimpleBllock(Blocks.command_block);

        addTargetSymbolSimpleBllock(Blocks.birch_stairs);

        addTargetSymbolSimpleBllock(Blocks.cobblestone_wall, "WallBlockType");

        value = BlockWall.EnumType.values().length;
        for (i = 0; i < value; i++) {
            addWall(i);
        }

        addTargetSymbolSimpleBllock(Blocks.wooden_button);

        addTargetSymbolSimpleBllock(Blocks.anvil);

        addTargetSymbolSimpleBllock(Blocks.trapped_chest);

        addTargetSymbolSimpleBllock(Blocks.light_weighted_pressure_plate);

        addTargetSymbolSimpleBllock(Blocks.heavy_weighted_pressure_plate);

        addTargetSymbolSimpleBllock(Blocks.daylight_detector);

        addTargetSymbolSimpleBllock(Blocks.quartz_block, "QuartzBlockType");

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.quartz_block.getUnlocalizedName(), BlockQuartz.EnumType.byMetadata(0).toString())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.quartz_block
                                && ((BlockQuartz.EnumType)state.getValue(BlockQuartz.VARIANT)).getMetadata() == 0;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.quartz_block.getUnlocalizedName(), BlockQuartz.EnumType.byMetadata(1).toString())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.quartz_block
                                && ((BlockQuartz.EnumType)state.getValue(BlockQuartz.VARIANT)).getMetadata() == 1;
                    }
                }

                return false;
            }
        });

        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.quartz_block.getUnlocalizedName(), BlockQuartz.EnumType.byMetadata(2).toString())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.quartz_block
                                && (((BlockQuartz.EnumType)state.getValue(BlockQuartz.VARIANT)).getMetadata() == 2
                                || ((BlockQuartz.EnumType)state.getValue(BlockQuartz.VARIANT)).getMetadata() == 3
                                || ((BlockQuartz.EnumType)state.getValue(BlockQuartz.VARIANT)).getMetadata() == 4);
                    }
                }

                return false;
            }
        });

        addTargetSymbolSimpleBllock(Blocks.quartz_stairs);

        addTargetSymbolSimpleBllock(Blocks.activator_rail);

        addTargetSymbolSimpleBllock(Blocks.dropper);

        addTargetSymbolSimpleBllock(Blocks.stained_hardened_clay, "StainedClayType");

        value = EnumDyeColor.values().length;

        for (i = 0; i < value; i++) {
            addBlockColoredTarget(Blocks.stained_hardened_clay, i);
        }

        addTargetSymbolSimpleBllock(Blocks.stained_glass_pane, "StainedGlassPaneType");

        value = EnumDyeColor.values().length;
        for (i = 0; i < value; i++) {
            addBlockStainedGlassPane(Blocks.stained_glass_pane, i);
        }

        addTargetSymbolSimpleBllock(Blocks.acacia_stairs);

        addTargetSymbolSimpleBllock(Blocks.dark_oak_stairs);

        addTargetSymbolSimpleBllock(Blocks.iron_trapdoor);

        addTargetSymbolSimpleBllock(Blocks.dropper);

        addTargetSymbolSimpleBllock(Blocks.prismarine, "PrismarineType");

        value = BlockPrismarine.EnumType.values().length;
        for (i = 0; i < value; i++) {
            addBlockPrismarine(i);
        }

        addTargetSymbolSimpleBllock(Blocks.hay_block);

        addTargetSymbolSimpleBllock(Blocks.carpet, "CarpetType");

        value = EnumDyeColor.values().length;
        for (i = 0; i < value; i++) {
            addBlockCarpet(Blocks.carpet, i);
        }

        addTargetSymbolSimpleBllock(Blocks.double_plant, "DoublePlantType");

        value = BlockDoublePlant.EnumPlantType.values().length;
        for (i = 0; i < value; i++) {
            addBlockDoublePlant(Blocks.double_plant, i);
        }

        addTargetSymbolSimpleBllock(Blocks.red_sandstone, "RedSandstoneType");

        for (i = 0; i < value; i++) {
            addBlockRedSandstone(Blocks.red_sandstone, i);
        }

        addTargetSymbolSimpleBllock(Blocks.red_sandstone_stairs);

        addTargetSymbolSimpleBllock(Blocks.spruce_fence_gate);

        addTargetSymbolSimpleBllock(Blocks.birch_fence_gate);

        addTargetSymbolSimpleBllock(Blocks.jungle_fence_gate);

        addTargetSymbolSimpleBllock(Blocks.dark_oak_fence_gate);

        addTargetSymbolSimpleBllock(Blocks.acacia_fence_gate);

        addTargetSymbolSimpleBllock(Blocks.spruce_fence);

        addTargetSymbolSimpleBllock(Blocks.birch_fence);

        addTargetSymbolSimpleBllock(Blocks.jungle_fence);

        addTargetSymbolSimpleBllock(Blocks.dark_oak_fence);

        addTargetSymbolSimpleBllock(Blocks.acacia_fence);
    }

    private static void addBlockColoredTarget(final Block block, final int meta) {
        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(block.getUnlocalizedName(), EnumDyeColor.byMetadata(meta).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == block
                                && ((EnumDyeColor)state.getValue(BlockColored.COLOR)).getMetadata() == meta;
                    }
                }

                return false;
            }
        });
    }

    private static void addBlockStainedGlass(final Block block, final int meta) {
        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(block.getUnlocalizedName(), EnumDyeColor.byMetadata(meta).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == block
                                && ((EnumDyeColor)state.getValue(BlockStainedGlass.COLOR)).getMetadata() == meta;
                    }
                }

                return false;
            }
        });
    }

    private static void addBlockStainedGlassPane(final Block block, final int meta) {
        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(block.getUnlocalizedName(), EnumDyeColor.byMetadata(meta).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == block
                                && ((EnumDyeColor)state.getValue(BlockStainedGlassPane.COLOR)).getMetadata() == meta;
                    }
                }

                return false;
            }
        });
    }

    private static void addBlockCarpet(final Block block, final int meta) {
        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(block.getUnlocalizedName(), EnumDyeColor.byMetadata(meta).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == block
                                && ((EnumDyeColor)state.getValue(BlockCarpet.COLOR)).getMetadata() == meta;
                    }
                }

                return false;
            }
        });
    }

    private static void addBlockFlower(final BlockFlower block, final int meta) {
        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(block.getUnlocalizedName(), BlockFlower.EnumFlowerType.getType(block.getBlockType(), meta).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == block
                                && ((BlockFlower.EnumFlowerType)state.getValue(block.getTypeProperty())).getMeta() == meta;
                    }
                }

                return false;
            }
        });
    }

    private static void addBlockStoneSlab(final Block slab1, final Block slab2, final int meta) {
        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(slab1.getUnlocalizedName(), BlockStoneSlab.EnumType.byMetadata(meta).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return (state.getBlock() == slab1
                                || state.getBlock() == slab2)
                                && ((BlockStoneSlab.EnumType)state.getValue(BlockStoneSlab.VARIANT)).getMetadata() == meta;
                    }
                }

                return false;
            }
        });
    }

    private static void addBlockStoneSlab2(final Block slab1, final Block slab2, final int meta) {
        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(slab1.getUnlocalizedName(), BlockStoneSlabNew.EnumType.byMetadata(meta).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return (state.getBlock() == slab1
                                || state.getBlock() == slab2)
                                && ((BlockStoneSlabNew.EnumType)state.getValue(BlockStoneSlabNew.VARIANT)).getMetadata() == meta;
                    }
                }

                return false;
            }
        });
    }

    private static void addBlockWoodSlab(final Block slab1, final Block slab2, final int meta) {
        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(slab1.getUnlocalizedName(), BlockPlanks.EnumType.byMetadata(meta).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return (state.getBlock() == slab1
                                || state.getBlock() == slab2)
                                && ((BlockPlanks.EnumType)state.getValue(BlockWoodSlab.VARIANT)).getMetadata() == meta;
                    }
                }

                return false;
            }
        });
    }

    private static void addBlockSilverfish(final int meta) {
        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.monster_egg.getUnlocalizedName(), BlockSilverfish.EnumType.byMetadata(meta).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.monster_egg
                                && ((BlockSilverfish.EnumType)state.getValue(BlockSilverfish.VARIANT)).getMetadata() == meta;
                    }
                }

                return false;
            }
        });
    }

    private static void addStoneBrick(final int meta) {
        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.stonebrick.getUnlocalizedName(), BlockStoneBrick.EnumType.byMetadata(meta).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());
                    return state != null
                            && state.getBlock() == Blocks.stonebrick
                            && ((BlockStoneBrick.EnumType)state.getValue(BlockStoneBrick.VARIANT)).getMetadata() == meta;
                }

                return false;
            };
        });
    }

    private static void addWall(final int meta) {
        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.cobblestone_wall.getUnlocalizedName(), BlockWall.EnumType.byMetadata(meta).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.cobblestone_wall
                                && ((BlockWall.EnumType)state.getValue(BlockWall.VARIANT)).getMetadata() == meta;
                    }
                }

                return false;
            }
        });
    }

    private static void addBlockPrismarine(final int meta) {
        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(Blocks.prismarine.getUnlocalizedName(), BlockPrismarine.EnumType.byMetadata(meta).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == Blocks.prismarine
                                && ((BlockPrismarine.EnumType)state.getValue(BlockPrismarine.VARIANT)).getMetadata() == meta;
                    }
                }

                return false;
            }
        });
    }

    private static void addBlockDoublePlant(final Block block, final int meta) {
        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(block.getUnlocalizedName(), BlockDoublePlant.EnumPlantType.byMetadata(meta).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == block
                                && ((BlockDoublePlant.EnumPlantType)state.getValue(BlockDoublePlant.VARIANT)).getMeta() == meta;
                    }
                }

                return false;
            }
        });
    }

    private static void addBlockRedSandstone(final Block block,final int meta) {
        addTargetSymbol(new TargetSymbol(adaptUnlocalizedName(block.getUnlocalizedName(), BlockRedSandstone.EnumType.byMetadata(meta).getUnlocalizedName())) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == block
                                && ((BlockRedSandstone.EnumType)state.getValue(BlockRedSandstone.TYPE)).getMetadata() == meta;
                    }
                }

                return false;
            }
        });
    }

    private static void f(final Block block, final int i) {
        ItemStack is = new ItemStack(block, 1, i);
        Item item = Item.getItemFromBlock(block);

        addTargetSymbol(new TargetSymbol(item.getUnlocalizedName(is)) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());

                    if (state != null) {
                        return state.getBlock() == block
                                && block.getMetaFromState(state) == i;
                        //&& ((BlockStone.EnumType)state.getValue(BlockStone.VARIANT)).getMetadata() == 0;
                    }
                }

                return false;
            }
        });
    }

    private static void addEffectSymbols() {
        addEffectSymbol(new EffectSymbol("RightClickKill") {
            @Override
            public boolean onRightClickTarget(EntityPlayer player, MovingObjectPosition target, ItemStack staffItem) {
                if (target.entityHit != null) {
                    Entity entity = target.entityHit;

                    if (entity instanceof EntityLiving) {
                        EntityLiving living = (EntityLiving)entity;
                        entity.attackEntityFrom(DamageSource.causePlayerDamage(player), living.getMaxHealth());
                    } else {
                        entity.attackEntityFrom(DamageSource.causePlayerDamage(player), 1.0F);
                    }

                    return true;
                }

                return false;
            }
        });

        addEffectSymbol(new EffectSymbol("LeftClickKill") {
            @Override
            public boolean onLeftClickTarget(EntityPlayer player, MovingObjectPosition target, ItemStack staffItem) {
                if (target.entityHit != null) {
                    Entity entity = target.entityHit;

                    if (entity instanceof EntityLiving) {
                        EntityLiving living = (EntityLiving)entity;
                        entity.attackEntityFrom(DamageSource.causePlayerDamage(player), living.getMaxHealth());
                    } else {
                        entity.attackEntityFrom(DamageSource.causePlayerDamage(player), 1.0F);
                    }

                    return true;
                }

                return false;
            }
        });

        addEffectSymbol(new EffectSymbol("RightClickDelete") {
            @Override
            public boolean onRightClickTarget(EntityPlayer player, MovingObjectPosition target, ItemStack staffItem) {
                if (target.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY && target.entityHit != null) {
                    Entity entity = target.entityHit;
                    entity.setDead();
                    return true;
                } else if (target.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    player.worldObj.setBlockToAir(target.getBlockPos());
                    return true;
                }

                return false;
            }
        });


    }

    private static void addTargetSymbolSimpleBllock(final Block block) {
        addTargetSymbolSimpleBllock(block, block.getUnlocalizedName() + ".name");
    }

    private static void addTargetSymbolSimpleBllock(final Block block, String name) {
        addTargetSymbol(new TargetSymbol(name) {
            @Override
            public boolean matchTarget(MovingObjectPosition target, World world) {
                if (target.typeOfHit == MovingObjectType.BLOCK && target.getBlockPos() != null) {
                    IBlockState state = world.getBlockState(target.getBlockPos());
                    return state != null && state.getBlock() == block;
                }

                return false;
            };
        });
    }

    private static String adaptUnlocalizedName(String ... strings) {
        StringBuilder sb = new StringBuilder();

        for (String string : strings) {
            sb.append(string).append(".");
        }

        return sb.append("name").toString();
    }

}
