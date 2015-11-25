package pixlepix.carts;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

/**
 * Created by localmacaccount on 5/30/15.
 */
public class KeyBindings {

    public static KeyBinding jumpKeyBind;
    public static KeyBinding jumpDownKeyBind;

    public static void init() {
        jumpKeyBind = new KeyBinding("carts.angelJump", Keyboard.KEY_UP, "carts.keyBindCategory");
        jumpDownKeyBind = new KeyBinding("carts.angelJumpDown", Keyboard.KEY_DOWN, "carts.keyBindCategory");
        ClientRegistry.registerKeyBinding(jumpKeyBind);
        ClientRegistry.registerKeyBinding(jumpDownKeyBind);
    }
}
