package org.sfsoft.jfighter2dx.screens;

import java.util.List;

import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import org.sfsoft.jfighter2dx.JFighter2DX;
import org.sfsoft.jfighter2dx.managers.ConfigurationManager;
import org.sfsoft.jfighter2dx.managers.ConfigurationManager.Score;
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
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

/**
 * Pantalla de fin de partida, donde va el usuario cuando muere su personaje
 * @author Santiago Faci
 * @version 1.0
 *
 */
public class GameOverScreen implements Screen {

	JFighter2DX game;
	Stage stage;
	
	private boolean done;
	
	public GameOverScreen(JFighter2DX game) {
		this.game = game;
		
		done = false;
	}
	
	/**
	 * Obtiene el top scores de anteriores jugadores
     * @return Los nombres y puntuaciones de las primeras posiciones
	 */
	private String loadScores() {
		
		// Lee las puntuaciones
		List<Score> scores = ConfigurationManager.getTopScores();
		
		String values = "";
		for (Score score : scores)
            values += score.name + " - " + score.score + "\n";

        return values;
	}
	
	@Override
	public void show() {

        loadScreen();
    }

    private void loadScreen() {

        stage = new Stage();

        Table table = new Table(game.getSkin());
        table.setFillParent(true);
        table.center();

        final Label title = new Label("JFIGHTER2DX TOP SCORE", game.getSkin());
        title.setFontScale(2.5f);
        // Carga la lista de puntuaciones (top 10)
        String values = loadScores();
        Label labelTopScore = new Label(values, game.getSkin());
        Label labelScore = new Label("YOUR SCORE: " + game.score, game.getSkin());

        table.row().height(50);
        table.add(title).center().pad(35f);
        table.row().height(200);
        table.add(labelTopScore).center().pad(5f);
        table.row().height(20);
        table.add(labelScore).center().pad(5f);

        // El usuario ya ha rellenado su nombre
        if (done) {
            TextButton quitButton = new TextButton("MAIN MENU", game.getSkin());
            quitButton.addListener(new ClickListener() {
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                    game.setScreen(new MainMenuScreen(game));
                }
            });

            table.row().height(70);
            table.add(quitButton).center().width(300).pad(5f);
        }
        else {
            // El usuario aún no he escrito su nombre
            final TextField nameTextField = new TextField("TYPE YOUR NAME", game.getSkin());

            TextButton quitButton = new TextButton("OK", game.getSkin());
            quitButton.addListener(new ClickListener() {
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    ConfigurationManager.addScores(nameTextField.getText(), game.score);
                    stage.clear();
                    done = true;
                    loadScreen();
                }
            });

            table.row().height(20);
            table.add(nameTextField).center().width(250).pad(55f);
            table.row().height(50);
            table.add(quitButton).center().width(300).pad(5f);
        }

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
