package uoy.thegame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import uoy.thegame.view.MainMenuScreen;

/**
 * TheGame is the entrypoint of the game.
 * <p>
 * This class loads the game skin and font, and sets the screen to MainMenu.
 * <p>
 * No game logic should live here.
 */
public class TheGame extends Game {

	// superclass changed from ApplicationListener to Game
	// to utilise Screen interface

	static public Skin gameSkin;
	static public BitmapFont font;

	@Override
	public void create() {

		// load game skin and font

		gameSkin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));
		font = new BitmapFont(Gdx.files.internal("skin/font-title-export.fnt"));

		// go to main menu (load the main menu screen)

		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
