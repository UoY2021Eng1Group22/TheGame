package uk.ac.york.cs.thegame;

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
        bgTexture = levelInfo.bgImg;

        // setup
        var textureRegion = new TextureRegion(bgTexture);
        textureRegion.setRegion(0, 0, bgTexture.getWidth(), bgTexture.getWidth());
        var bgImage = new Image(textureRegion);
        bgImage.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        bgImage.setPosition(0, Gdx.graphics.getHeight() - bgImage.getHeight());
        stage.addActor(bgImage);

        for (int i = 0; i < levelInfo.currentStageObstacles.size(); i++) {              // mostly copied from above setup, non functional
            Obstacle currentObstacle = levelInfo.currentStageObstacles.get(i);
            var obstRegion = new TextureRegion(currentObstacle.obsImg);
            obstRegion.setRegion(currentObstacle.position[0], currentObstacle.position[1], currentObstacle.obsImg.getWidth(), currentObstacle.obsImg.getHeight());
            var obsImage = new Image(obstRegion);
            obsImage.setPosition(currentObstacle.position[0], currentObstacle.position[1]);
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

        // create actor object
        var someSquare = new Square(100, 100);

        // handing control over to actor
        stage.setKeyboardFocus(someSquare);

        Gdx.input.setInputProcessor(stage);

        // add actor to stage
        stage.addActor(someSquare);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
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
