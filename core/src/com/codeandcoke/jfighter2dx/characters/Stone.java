package com.codeandcoke.jfighter2dx.characters;

import com.codeandcoke.jfighter2dx.managers.ResourceManager;
import com.codeandcoke.jfighter2dx.util.Constants;

import com.badlogic.gdx.math.Rectangle;

/**
 * Representa a rocas y piedras que pueden aparecer durante el juego en la pantalla
 * @author Santiago Faci
 * @version Agosto 2014
 */
public class Stone extends Enemy {

	/**
	 * 
	 * @param x Posición inicial x
	 * @param y Posición inicial y
	 * @param speed Velocidad en x
	 */
	public Stone(float x, float y, float speed) {
		super(x, y, speed);
	
		animation = ResourceManager.getAnimation("stone");
		setRect(new Rectangle(x, y, Constants.STONE_WIDTH, Constants.STONE_HEIGHT));
	}

	@Override
	public void update(float dt) {
		
		super.update(dt);
		
		setX(getX() + getSpeed() * dt);
		setRectX(getX());
	}
}
