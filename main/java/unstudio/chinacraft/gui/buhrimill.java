//Power by tdiant
//ʯĥGUI
package unstudio.chinacraft.gui;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;

public class buhrimill extends GuiScreen {
	 private GuiScreen parentScreen;
	 private GuiTextField tfInput;
	 
	 @Override
	 public boolean doesGuiPauseGame() {  //��GUI�ڵ���ģʽ�²�����ͣ��Ϸ����浵
	     return false;
	 }
	 
	    public buhrimill(GuiScreen currentScreen) {
		// TODO �Զ����ɵĹ��캯�����
	}
	 
	    public void initGui()
	    {
	    	Keyboard.enableRepeatEvents(true);
	    	tfInput = new GuiTextField(fontRendererObj, (int)(width*0.5)-150, (int)(height*0.85), 300, 20);
	    	tfInput.setMaxStringLength(64);
	    	tfInput.setFocused(false);
	    	tfInput.setCanLoseFocus(true); 
	    }
	 
	    public void drawScreen(int par1, int par2, float par3)
	    {
	        drawDefaultBackground();
	        //�ᱻ�ؼ�(������)��ס.
	        super.drawScreen(par1,par2,par3);
	        //�ڿؼ�(������)֮��.
	        tfInput.drawTextBox();
	    }
}
