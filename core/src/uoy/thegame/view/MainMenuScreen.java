package uoy.thegame.view;

// ref: https://libgdx.info/basic_screen/

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import uoy.thegame.TheGame;


/**
 * MainMenu is the title screen for the game.
 * It is the first thing the player will see upon booting up the game (but logically the game first goes to TheGame, which then goes here
 */
public class MainMenuScreen implements Screen {

    private final Stage stage;
    private final Game game;

    public MainMenuScreen(Game gameInstance) {

        // parent game instance, to control the game screen (ApplicationListener)
        game = gameInstance;

        // setup the stage
        stage = new Stage(new ScreenViewport());

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

    // analogous to create()
    @Override
    public void show() {

        // background, wraps + repeats
        var bgTexture = new Texture("skin/dirt.png");
        bgTexture.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);

        // setup
        var textureRegion = new TextureRegion(bgTexture);
        textureRegion.setRegion(0, 0, bgTexture.getWidth(), bgTexture.getWidth());

        // actor-ify
        var bgImage = new Image(textureRegion);
        bgImage.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        bgImage.setPosition(0, Gdx.graphics.getHeight() - bgImage.getHeight());

        // add to stage
        stage.addActor(bgImage);

        // title
        var labelStyle = new Label.LabelStyle();
        labelStyle.font = TheGame.font;

        var title = new Label("boatcraft", labelStyle);
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight() * 2f / 3f);
        title.setWidth(Gdx.graphics.getWidth());
        stage.addActor(title);

        // play button

        var playButton = new TextButton("play", TheGame.gameSkin);
        playButton.setWidth(Gdx.graphics.getWidth() / 2f);
        playButton.setPosition(
                Gdx.graphics.getWidth() / 2f - playButton.getWidth() / 2f,
                Gdx.graphics.getHeight() / 2f - playButton.getHeight() / 2f
        );

        // input event listening
        playButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent ev, float x, float y, int pointer, int button) {
                game.setScreen(new PlayScreen(game, 1)); // go to next screen (play screen)
            }

            @Override
            public boolean touchDown(InputEvent ev, float x, float y, int pointer, int button) {
                return true;
            }
        });

        stage.addActor(playButton);

        var quitButton = new TextButton("quit", TheGame.gameSkin);
        quitButton.setWidth(Gdx.graphics.getWidth() / 2f);
        quitButton.setPosition(
                Gdx.graphics.getWidth() / 2f - quitButton.getWidth() / 2f,
                Gdx.graphics.getHeight() / 3f - quitButton.getHeight() / 2f
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

        // set listener to current stage
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
    }


    @Override
    public void dispose() {
        stage.dispose();
        Gdx.app.exit();
    }
}
