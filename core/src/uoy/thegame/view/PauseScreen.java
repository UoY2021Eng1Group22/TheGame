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

/**
 * PauseScreen is a Screen that users could go to, when
 */
public class PauseScreen extends DummyScreen {

    private final Stage stage;
    private final Game game;

    public PauseScreen(Game gameInstance, Screen prevScreen) {
        // parent game instance, to control the game screen (ApplicationListener)
        game = gameInstance;

        // setup the stage
        stage = new Stage(new ScreenViewport());

        // background, wraps + repeats
        var bgTexture = new Texture("skin/dirt.png");
        bgTexture.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);

        // setup
        var textureRegion = new TextureRegion(bgTexture);
        textureRegion.setRegion(0, 0, bgTexture.getWidth(), bgTexture.getWidth());
        var bgImage = new Image(textureRegion);
        bgImage.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        bgImage.setPosition(0, Gdx.graphics.getHeight() - bgImage.getHeight());
        stage.addActor(bgImage);


        // 3 buttons: back to game, back to main screen, exit

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
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
