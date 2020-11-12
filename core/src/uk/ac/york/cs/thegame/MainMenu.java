package uk.ac.york.cs.thegame;

// ref: https://libgdx.info/basic_screen/

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenu implements Screen {

    private final Stage stage;
    private final Game game;
    SpriteBatch batch;
    Texture img;

    public MainMenu(Game gameInstance) {

        game = gameInstance;
        stage = new Stage(new ScreenViewport());

        batch = new SpriteBatch();
        img = new Texture("bg.png");
        img.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);

        var textureRegion = new TextureRegion(img);
        textureRegion.setRegion(0, 0, img.getWidth(), img.getWidth());
        var bg = new Image(textureRegion);
        bg.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        bg.setPosition(0, Gdx.graphics.getHeight() - bg.getHeight());
        stage.addActor(bg);

        var labelStyle = new Label.LabelStyle();
        labelStyle.font = TheGame.font;

        var title = new Label("The Game", labelStyle);
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight() * 2 / 3);
        title.setWidth(Gdx.graphics.getWidth());
        stage.addActor(title);

    }

    public void create() {

    }

    public void resize(int width, int height) {

    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();

//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
    }


    @Override
    public void dispose() {
        stage.dispose();
        batch.dispose();
        img.dispose();
    }
}
