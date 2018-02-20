package org.sfsoft.jfighter2dx.managers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.sfsoft.jfighter2dx.util.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Clase que gestiona la configuración del juego
 * @author Santiago Faci
 * @version Agosto 2014
 */
public class ConfigurationManager {

	private Preferences prefs;
	
	public ConfigurationManager() {
		prefs = Gdx.app.getPreferences(Constants.APP);
	}
	
	public boolean isSoundEnabled() {
		
		return prefs.getBoolean("sound");
	}
	
	/**
	 * Añade la puntuación de un jugador a la base de datos
	 * Si la tabla no existe se crea (la primera vez)
	 */
	public static void addScores(String name, int score) {
		
		try {
			Class.forName("org.sqlite.JDBC");
			
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:sqlite:" + Gdx.files.internal("scores.db"));

			String sql = "CREATE TABLE IF NOT EXISTS scores (id integer primary key autoincrement, name text, score int)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.executeUpdate();

			sql = "INSERT INTO scores (name, score) VALUES (?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setInt(2, score);
			statement.executeUpdate();

			if (statement != null)
				statement.close();
			if (connection != null)
				connection.close();
		
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	/**
	 * Devuelve la lista de las diez mejores puntuaciones del juego
	 * @return La lista de puntuaciones
	 */
	public static List<Score> getTopScores() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:sqlite:" + Gdx.files.internal("scores.db"));

			String sql = "SELECT name, score FROM scores ORDER BY score DESC LIMIT 10";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet res = statement.executeQuery();
			List<Score> scores = new ArrayList<Score>();
			Score score;
			while (res.next()) {
				score = new Score();
				score.name = res.getString("name");
				score.score = res.getInt("score");
				scores.add(score);
			}
			
			if (statement != null)
				statement.close();
			if (res != null)
				res.close();
			if (connection != null)
				connection.close();
			
			return scores;
		
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return new ArrayList<Score>();
	}
	
	public static class Score {
		public String name;
		public int score;
	}
}
