package uk.ac.york.cs.thegame;

// ref: https://libgdx.info/basic_screen/

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenu implements Screen {

    private final Stage stage;
    private final Game game;
    SpriteBatch batch;
    Texture bgTexture;

    public MainMenu(Game gameInstance) {

        // parent game instance, to control the game (ApplicationListener)
        game = gameInstance;

        // setup the stage
        stage = new Stage(new ScreenViewport());

        // background, wraps + repeats
        bgTexture = new Texture("skin/dirt.png");
        bgTexture.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);

        // setup
        var textureRegion = new TextureRegion(bgTexture);
        textureRegion.setRegion(0, 0, bgTexture.getWidth(), bgTexture.getWidth());
        var bgImage = new Image(textureRegion);
        bgImage.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        bgImage.setPosition(0, Gdx.graphics.getHeight() - bgImage.getHeight());
        stage.addActor(bgImage);

        var labelStyle = new Label.LabelStyle();
        labelStyle.font = TheGame.font;

        var title = new Label("boatcraft", labelStyle);
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight() * 2 / 3);
        title.setWidth(Gdx.graphics.getWidth());
        stage.addActor(title);

        var playButton = new TextButton("play", TheGame.gameSkin);
        playButton.setWidth(Gdx.graphics.getWidth() / 2);
        playButton.setPosition(
                Gdx.graphics.getWidth() / 2 - playButton.getWidth() / 2,
                Gdx.graphics.getHeight() / 2 - playButton.getHeight() / 2
        );
        playButton.addListener(new InputListener() {

            @Override
            public void touchUp(InputEvent ev, float x, float y, int pointer, int button) {
                game.setScreen(new PlayScreen(game));
            }

            @Override
            public boolean touchDown(InputEvent ev, float x, float y, int pointer, int button) {
                return true;
            }

        });

        stage.addActor(playButton);

        var quitButton = new TextButton("quit", TheGame.gameSkin);
        quitButton.setWidth(Gdx.graphics.getWidth() / 2);
        quitButton.setPosition(
                Gdx.graphics.getWidth() / 2 - quitButton.getWidth() / 2,
                Gdx.graphics.getHeight() / 3 - quitButton.getHeight() / 2
        );
        quitButton.addListener(new InputListener() {

            @Override
            public void touchUp(InputEvent ev, float x, float y, int pointer, int button) {
                dispose();
            }

            @Override
            public boolean touchDown(InputEvent ev, float x, float y, int pointer, int button) {
                return true;
            }

        });

        stage.addActor(quitButton);

    }

    public void create() {

    }

    @Override
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
        Gdx.app.exit();
    }
}
