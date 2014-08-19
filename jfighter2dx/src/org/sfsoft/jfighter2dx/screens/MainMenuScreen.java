package org.sfsoft.jfighter2dx.screens;

import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import org.sfsoft.jfighter2dx.JFighter2DX;
import org.sfsoft.jfighter2dx.screens.GameScreen.GameType;
import org.sfsoft.jfighter2dx.util.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Pantalla principal del juego, donde se muestra el menú principal
 * @author Santiago Faci
 * @version Agosto 2014
 */
public class MainMenuScreen implements Screen {

	JFighter2DX game;
	Stage stage;
	
	public MainMenuScreen(JFighter2DX game) {
		this.game = game;
	}

	@Override
	public void show() {

        stage = new Stage();

        Table table = new Table(game.getSkin());
        table.setFillParent(true);
        table.center();

        Label title = new Label("JFIGHTER2DX\nMAIN MENU", game.getSkin());
        title.setFontScale(2.5f);

        TextButton quickButton = new TextButton("QUICK PLAY", game.getSkin());
        quickButton.addListener(new ClickListener() {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                dispose();
                game.setScreen(new GameScreen(game, GameType.QUICK));
            }
        });
        TextButton historyButton = new TextButton("PLAY HISTORY", game.getSkin());
        historyButton.addListener(new ClickListener() {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                dispose();
                game.setScreen(new GameScreen(game, GameType.HISTORY));
            }
        });
        TextButton optionsButton = new TextButton("OPTIONS", game.getSkin());
        optionsButton.addListener(new ClickListener() {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                dispose();
                game.setScreen(new ConfigurationScreen(game));

            }
        });
        TextButton exitButton = new TextButton("QUIT GAME", game.getSkin());
        exitButton.addListener(new ClickListener() {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                dispose();
                System.exit(0);
            }
        });

        Label aboutLabel = new Label("jfighter2dx v1\n(c) Santiago Faci\nhttp://bitbucket.org/sfaci/jfighter2dx", game.getSkin());
        aboutLabel.setFontScale(1f);

        table.row().height(150);
        table.add(title).center().pad(35f);
        table.row().height(70);
        table.add(quickButton).center().width(300).pad(5f);
        table.row().height(70);
        table.add(historyButton).center().width(300).pad(5f);
        table.row().height(70);
        table.add(optionsButton).center().width(300).pad(5f);
        table.row().height(70);
        table.add(exitButton).center().width(300).pad(5f);
        table.row().height(70);
        table.add(aboutLabel).center().pad(55f);

        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);
	}
	
	@Override
	public void render(float dt) {

		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        
		// Pinta el menú
		stage.act(dt);
		stage.draw();
	}
	
	@Override
	public void dispose() {

		stage.dispose();
	}

	@Override
	public void hide() {

		
	}

	@Override
	public void pause() {

		
	}

	

	@Override
	public void resize(int width, int height) {
        stage.setViewport(width, height);
	}

	@Override
	public void resume() {
	}
}
