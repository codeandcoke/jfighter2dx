package org.sfsoft.jfighter2dx;

import org.sfsoft.jfighter2dx.util.Constants;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopJFighter2DX {

	public static void main(String[] args) {
		LwjglApplicationConfiguration configuration = new LwjglApplicationConfiguration();
		configuration.title = "JFighter2DX";
		configuration.width = Constants.SCREEN_WIDTH;
		configuration.height = Constants.SCREEN_HEIGHT;
		
		configuration.fullscreen = true;
				
		new LwjglApplication(new JFighter2DX(), configuration);
	}
}

