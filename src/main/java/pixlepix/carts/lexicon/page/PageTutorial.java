package pixlepix.carts.lexicon.page;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import pixlepix.carts.lexicon.GuiLexicon;
import pixlepix.carts.lexicon.IGuiLexiconEntry;

import static net.minecraft.client.Minecraft.getMinecraft;

/**
 * Created by localmacaccount on 6/2/15.
 */
public class PageTutorial extends PageText {

    GuiButton button;

    public PageTutorial(String unlocalizedName) {
        super(unlocalizedName);
    }

    @Override
    public void onOpened(IGuiLexiconEntry gui) {
        button = new GuiButton(101, gui.getLeft() + 30, gui.getTop() + gui.getHeight() - 50, gui.getWidth() - 60, 20, StatCollector.translateToLocal("carts.startTutorial"));
        gui.getButtonList().add(button);
    }

    @Override
    public void onClosed(IGuiLexiconEntry gui) {
        gui.getButtonList().remove(button);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onActionPerformed(GuiButton button) {
        if (button == this.button) {
            GuiLexicon.startTutorial();
            getMinecraft().displayGuiScreen(new GuiLexicon());
            getMinecraft().thePlayer.addChatMessage(new ChatComponentTranslation("carts.tutorialStarted").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
        }
    }

}