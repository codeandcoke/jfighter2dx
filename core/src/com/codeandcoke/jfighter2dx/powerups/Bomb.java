package com.codeandcoke.jfighter2dx.powerups;

import com.codeandcoke.jfighter2dx.managers.ResourceManager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Las bombas son un powerup que permite eliminar a todos los enemigos de la pantalla 
 * @author Santiago Faci
 * @version Agosto 2014
 */
public class Bomb extends Powerup {
	
	private Texture texture;
	
	public Bomb(float x, float y, float speed) {
		
		super(x, y, speed);
		
		texture = ResourceManager.getTexture("bomb");
		setRect(new Rectangle(x, y, texture.getWidth(), texture.getHeight()));
	}

	@Override
	public void draw(SpriteBatch batch) {

		batch.draw(texture, getX(), getY());
	}
}
