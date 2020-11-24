package uoy.thegame.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import uoy.thegame.entitymodel.Boat;
import uoy.thegame.entitymodel.Entity;
import uoy.thegame.entitymodel.PlayerBoat;
import uoy.thegame.model.GameLevel;

// the main gameplay screen
public class PlayScreen extends DummyScreen {

    private final Stage stage;
    private final Game game; // placeholder for going to the next screen
    private final int levelNum;
    private final GameLevel level;
    private PlayerBoat playerBoat;

    public PlayScreen(Game gameInstance, int levelNum) {

        game = gameInstance;
        stage = new Stage(new ScreenViewport());
        this.levelNum = levelNum;

        //check the GameLevel class for usage
        this.level = new GameLevel(levelNum);
        var bgTexture = level.getBgImg();

        // setup of background texture/actor

        // split texture into texture regions to reduce load
        var textureRegion = new TextureRegion(bgTexture);
        textureRegion.setRegion(0, 0, bgTexture.getWidth(), bgTexture.getWidth());

        // actor-ify texture region
        var bgImage = new Image(textureRegion);

        bgImage.setPosition(0, Gdx.graphics.getHeight() - bgImage.getHeight());
        stage.addActor(bgImage);

        // receives the list of stage obstacles from the levelInfo
        // adds the obstacles to the stage
        // mostly copied from above setup, non functional
        this.level.getCurrentStageObstacles().forEach(stage::addActor);

        // receives the list of ai boats from the levelInfo
        // adds the ai boats to the stage
        this.level.getCurrentStageEnemies().forEach(stage::addActor);
    }
    @Override
    public void pause() {
        // should be called when Esc pressed
    }

    @Override
    public void show() {

        // placeholder player boat, to test the user controls
        playerBoat = new PlayerBoat(16, 16,
                Boat.BoatType.Medium,
                new Texture("Boats/1.png")
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

//        if (Gdx.input.isKeyPressed(Input.Keys.P)) {
//            stage.getActors().forEach((actor -> {
//
////                actor.
//
//                Gdx.app.log("Actor", String.format(
//                        "name: %s, bounds: ()",
//                        actor,
//                        actor
//                ));
//            }));
//        }

        // +
        if (Gdx.input.isKeyJustPressed(Input.Keys.EQUALS)) {
            Gdx.app.log("DEBUG", String.format("level increment; old: %d, new: %d", this.levelNum, this.levelNum + 1));
            game.setScreen(new PlayScreen(game, this.levelNum + 1));
            this.dispose();
        }

//            Gdx.app.log("DEBUG", String.format("entity bound:"));
        if (Gdx.input.isKeyJustPressed(Input.Keys.MINUS)) {

            for (var actor : stage.getActors()) {
                if (actor instanceof Entity) { // make sure actor is custom entity class
                    var entity = (Entity) actor;

                    Gdx.app.log("DEBUG",
                            String.format("%s(%s) pos: %s, %s",
                                    entity.getClass().getName(),
                                    entity.hashCode(),
                                    entity.getX(),
                                    entity.getY()));
                    Gdx.app.log("DEBUG",
                            String.format("%s(%s) bound: %s, %s",
                                    entity.getClass().getName(),
                                    entity.hashCode(),
                                    entity.getRect().getX(),
                                    entity.getRect().getY()));
                }
            }

        }

        // inefficient, consider quad tree
        // https://gamedevelopment.tutsplus.com/tutorials/quick-tip-use-quadtrees-to-detect-likely-collisions-in-2d-space--gamedev-374

//        for (var enemy : this.level.getCurrentStageEnemies()) {
//            for (var obstacle : this.level.getCurrentStageObstacles()) {
//                if (enemy.getRect().overlaps(obstacle.getRect())) {
//                    Gdx.app.log("BOUNDS", String.format("e: %s, o: %s",
//                            enemy.getRect(),
//                            obstacle.getRect()
//                            )
//                    );
//                }
//
//                if (playerBoat.getRect().overlaps(obstacle.getRect())) {
//                    Gdx.app.log("BOUNDS", String.format("e: %s, o: %s",
//                            enemy.getRect(),
//                            obstacle.getRect()
//                            )
//                    );
//                }
//            }
//        }

        for (var obstacle : this.level.getCurrentStageObstacles()) {
            if (playerBoat.getRect().overlaps(obstacle.getRect())) {
                Gdx.app.log("BOUNDS", String.format("p: %s, o: %s",
                        playerBoat.getRect(),
                        obstacle.getRect()
                        )
                );
            }
        }

        // handle collision here in main loop

        stage.act();
        stage.draw();
    }


    @Override
    public void dispose() {
        stage.dispose();
    }

}
