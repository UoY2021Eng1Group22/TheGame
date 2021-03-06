package uoy.thegame.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

// TODO: boiler

// the screen for selecting the player's boat
public class CharSelScreen implements Screen {

    private final Stage stage;
    private final Game game;

    Texture bgTexture;

    public CharSelScreen(Game gameInstance) {
        // parent game instance, to control the game screen (ApplicationListener)
        game = gameInstance;

        // setup the stage
        stage = new Stage(new ScreenViewport());

        // background, wraps + repeats
        bgTexture = new Texture("skin/dirt.png");
        bgTexture.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);

        // setup of texture regions and the background actor
        var textureRegion = new TextureRegion(bgTexture);
        textureRegion.setRegion(0, 0, bgTexture.getWidth(), bgTexture.getWidth());
        var bgImage = new Image(textureRegion);
        bgImage.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        bgImage.setPosition(0, Gdx.graphics.getHeight() - bgImage.getHeight());
        stage.addActor(bgImage);


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
    }


    @Override
    public void dispose() {
        stage.dispose();
    }

}
