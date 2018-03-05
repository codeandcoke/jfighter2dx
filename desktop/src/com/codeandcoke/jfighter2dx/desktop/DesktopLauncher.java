package com.codeandcoke.jfighter2dx.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.codeandcoke.jfighter2dx.JFighter2DX;
import com.codeandcoke.jfighter2dx.util.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "JFighter2DX";
		config.width = Constants.SCREEN_WIDTH;
		config.height = Constants.SCREEN_HEIGHT;

		config.fullscreen = false;

		new LwjglApplication(new JFighter2DX(), config);
	}
}
