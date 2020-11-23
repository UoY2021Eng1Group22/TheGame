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
import uoy.thegame.GameLevel;
import uoy.thegame.model.Boat;
import uoy.thegame.model.Obstacle;
import uoy.thegame.model.PlayerBoat;

// the main gameplay screen
public class PlayScreen implements Screen {

    private final Stage stage;
    private final Game game; // placeholder for going to the next screen

    Texture bgTexture;
    GameLevel levelInfo;

    public PlayScreen(Game gameInstance, int levelNum) {

        game = gameInstance;
        stage = new Stage(new ScreenViewport());

        //check the GameLevel class for usage
        levelInfo = new GameLevel(levelNum);
        bgTexture = levelInfo.getTexture();

        // setup of background texture/actor
        var textureRegion = new TextureRegion(bgTexture);
        textureRegion.setRegion(0, 0, bgTexture.getWidth(), bgTexture.getWidth());
        var bgImage = new Image(textureRegion);
        //bgImage.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        bgImage.setPosition(0, Gdx.graphics.getHeight() - bgImage.getHeight());
        stage.addActor(bgImage);

        // receives the list of stage obstacles from the levelInfo
        var currentStageObstacles = levelInfo.getCurrentStageObstacles();

        // adds the obstacles to the stage
        for (Obstacle currentObstacle : currentStageObstacles) {
            stage.addActor(currentObstacle);
        }

        // receives the list of ai boats from the levelInfo
        var currentStageEnemies = levelInfo.getCurrentStageEnemies();

        // adds the ai boats to the stage
        for (Boat currentEnemy : currentStageEnemies) {
            stage.addActor(currentEnemy);
        }


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

        // placeholder player boat, to test the user's control
        var playerBoat = new PlayerBoat(16, 16,
                Boat.BoatType.VerySmall,
                //not the final texture
                new Texture("obstacles/obs2.png")
        );

        playerBoat.setControllable(true);

        // handing the player the control over the playerBoat actor
        stage.setKeyboardFocus(playerBoat);

        stage.addActor(playerBoat);

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
