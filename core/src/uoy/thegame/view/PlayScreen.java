package uoy.thegame.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import uoy.thegame.GameLevel;
import uoy.thegame.model.Obstacle;

public class PlayScreen implements Screen {

    private final Stage stage;
    private final Game game;

    SpriteBatch batch;
    Texture bgTexture;
    GameLevel levelInfo;

    public PlayScreen(Game gameInstance, int levelNum) {

        game = gameInstance;
        stage = new Stage(new ScreenViewport());

        levelInfo = new GameLevel(levelNum);
        bgTexture = levelInfo.getTexture();

        // setup
        var textureRegion = new TextureRegion(bgTexture);
        textureRegion.setRegion(0, 0, bgTexture.getWidth(), bgTexture.getWidth());
        var bgImage = new Image(textureRegion);
        //bgImage.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        bgImage.setPosition(0, Gdx.graphics.getHeight() - bgImage.getHeight());
        stage.addActor(bgImage);

        var currentStageObstacles = levelInfo.getCurrentStageObstacles();

        for (Obstacle currentObstacle : currentStageObstacles) {              // mostly copied from above setup, non functional

            var obsPos = currentObstacle.getPosition();
            var obsImg = currentObstacle.getObsImg();

            var obstRegion = new TextureRegion(obsImg);
            obstRegion.setRegion(obsPos[0], obsPos[1], obsImg.getWidth(), obsImg.getHeight());

            var obsImage = new Image(obstRegion);
            obsImage.setPosition(obsPos[0], obsPos[1]);

            stage.addActor(obsImage);
        }


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
    }

}
