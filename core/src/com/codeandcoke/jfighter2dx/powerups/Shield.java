package com.codeandcoke.jfighter2dx.powerups;

import com.codeandcoke.jfighter2dx.managers.ResourceManager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Escudo que protege al personaje de cualquier impacto
 * @author Santiago Faci
 * @version Agosto 2014
 */
public class Shield extends Powerup {
	
	private Texture texture;
	
	public Shield(float x, float y, float speed) {
		
		super(x, y, speed);
		this.texture = ResourceManager.getTexture("shield");
		setRect(new Rectangle(x, y, this.texture.getWidth(), this.texture.getHeight()));
	}

	@Override
	public void draw(SpriteBatch batch) {

		batch.draw(texture, getX(), getY());
	}
}
