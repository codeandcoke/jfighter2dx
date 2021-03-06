package com.codeandcoke.jfighter2dx.screens;

import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.codeandcoke.jfighter2dx.JFighter2DX;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Menú 'in-game'
 * Se muestra cuando el jugador pulsa la tecla ESCAPE y muestra algunas opciones de la partida
 * y la opción de salir del juego
 * @author Santiago Faci
 * @version Agosto 2014
 */
public class InGameMenuScreen implements Screen {

	JFighter2DX game;
	GameScreen gameScreen;
	Stage stage;
	
	public InGameMenuScreen(JFighter2DX game, GameScreen gameScreen) {
		this.game = game;
		this.gameScreen = gameScreen;
	}
	
	@Override
	public void show() {

        stage = new Stage();

        Table table = new Table(game.getSkin());
        table.setFillParent(true);
        table.center();

        Label title = new Label("JFIGHTER2DX", game.getSkin());
        title.setFontScale(2.5f);

        TextButton quickButton = new TextButton("RESUME", game.getSkin());
        quickButton.addListener(new ClickListener() {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                dispose();
                game.setScreen(gameScreen);
            }
        });
        TextButton historyButton = new TextButton("RETURN TO MAIN MENU", game.getSkin());
        historyButton.addListener(new ClickListener() {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                dispose();
                game.setScreen(new MainMenuScreen(game));
            }
        });
        TextButton exitButton = new TextButton("QUIT GAME", game.getSkin());
        exitButton.addListener(new ClickListener() {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                dispose();
                System.exit(0);
            }
        });

        table.row().height(150);
        table.add(title).center().pad(35f);
        table.row().height(70);
        table.add(quickButton).center().width(300).pad(5f);
        table.row().height(70);
        table.add(historyButton).center().width(300).pad(5f);
        table.row().height(70);
        table.add(exitButton).center().width(300).pad(5f);

        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);
	}
	
	@Override
	public void render(float dt) {
	
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
		// Pinta el menú
		stage.act(dt);
		stage.draw();
	}
	
	@Override
	public void dispose() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {	
	}

	@Override
	public void resize(int width, int height) {
        //stage.setViewport(width, height);
	}

	@Override
	public void resume() {		
	}
}
