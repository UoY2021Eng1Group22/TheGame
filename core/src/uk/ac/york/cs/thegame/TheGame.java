package uk.ac.york.cs.thegame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class TheGame extends Game {

	// superclass changed from ApplicationListener to Game
	// to utilise Screen interface

	//	SpriteBatch batch;
//	Texture img;
	static public Skin gameSkin;
	static public BitmapFont font;


	@Override
	public void create() {
		// load game texture
//		batch = new SpriteBatch();
//		img = new Texture("bg.png");

		gameSkin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));
		font = new BitmapFont(Gdx.files.internal("skin/font-title-export.fnt"));
		this.setScreen(new MainMenu(this));
	}

	@Override
	public void render () {
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
		super.render();

	}
	
	@Override
	public void dispose () {
//		batch.dispose();
//		img.dispose();
	}
}
