package pixlepix.carts.main;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import pixlepix.carts.AuraAnalytics;
import pixlepix.carts.LogisticsCarts;
import pixlepix.carts.data.CoordTuple;
import pixlepix.carts.lexicon.LexiconData;
import pixlepix.carts.lexicon.LexiconEntry;
import pixlepix.carts.main.event.EventHandler;
import pixlepix.carts.network.PacketBurst;
import pixlepix.carts.registry.BlockRegistry;
import pixlepix.carts.registry.ModCreativeTab;

public class CommonProxy {

    public static EventHandler eventHandler;

    public IIcon[] breakingIcons = new IIcon[10];
    public IIcon blankIcon;


    public int renderPass;
    public BlockRegistry registry;
    public SimpleNetworkWrapper networkWrapper;
    public Block chiselBookshelf;


    public void preInit(FMLPreInitializationEvent event) {
        Config.init(event);

        LogisticsCarts.analytics = new AuraAnalytics(ConstantMod.version, ConstantMod.analyticsKey, ConstantMod.analyticsKeySecret);
       
        ModCreativeTab.INSTANCE = new ModCreativeTab();
        registry = new BlockRegistry();
        registry.preInit();


        networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(ConstantMod.modId);
        networkWrapper.registerMessage(PacketBurst.class, PacketBurst.class, 0, Side.CLIENT);

    }

    public void addToTutorial(LexiconEntry entry) {
    }

    public void setEntryToOpen(LexiconEntry entry) {

    }

    public World getWorld() {
        return null;
    }

    public EntityPlayer getPlayer() {
        return null;
    }

    public void init(FMLInitializationEvent event) {
        registry.init();

        NetworkRegistry.INSTANCE.registerGuiHandler(LogisticsCarts.instance, new GuiHandler());
        eventHandler = new EventHandler();
        MinecraftForge.EVENT_BUS.register(eventHandler);
        FMLCommonHandler.instance().bus().register(eventHandler);
    }

    public void postInit(FMLPostInitializationEvent event) {
        registry.postInit();
        LexiconData.init();
    }
    public void setLexiconStack(ItemStack stack) {
    }

    public void addBlockDestroyEffects(CoordTuple tuple) {
    }

    public EffectRenderer getEffectRenderer() {
        return null;
    }

    public void addEffectBypassingLimit(EntityFX entityFX) {

    }
}
