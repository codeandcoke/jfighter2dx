package com.codeandcoke.jfighter2dx.managers;

import java.util.Random;

import com.codeandcoke.jfighter2dx.powerups.Powerup;
import com.codeandcoke.jfighter2dx.powerups.Shield;
import com.codeandcoke.jfighter2dx.util.Constants;
import com.codeandcoke.jfighter2dx.powerups.Bomb;

/**
 * Clase que genera los diferentes powerups que aparecen a lo largo de la partida
 * @author Santiago Faci
 * @version Agosto 2014
 */
public class PowerupSpawner {

	public static Powerup createPowerup(Powerup.PowerupType type) {
		
		Powerup powerup = null;
		
		switch (type) {
			case BOMB:
				powerup = new Bomb(1000, new Random().nextInt(Constants.SCREEN_HEIGHT - Constants.ITEM_HEIGHT), -100f);
				break;
			case SHIELD:
				powerup = new Shield(1000, new Random().nextInt(Constants.SCREEN_HEIGHT - Constants.ITEM_HEIGHT), -100f);
				break;
		}
		
		return powerup;
	}
}
