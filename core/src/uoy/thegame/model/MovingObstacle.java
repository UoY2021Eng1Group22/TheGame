package uoy.thegame.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

//unfinished class for obstacles that move
public class MovingObstacle extends Obstacle {

    // TODO: adapt entity class to accept animations.

    // sets the list of possible sprites/images that the obstacle can have
    private static final String[] possibleSprites = {
            "goose/1.png",
            "obstacles/obsMov2.gif", // placeholder
            "obstacles/obsMov3.gif"
    };

    public MovingObstacle(int levelNum, int i) {
        // check the Obstacle class for the constructor's usage
        super(
                i,
                new Texture(possibleSprites[getRandomSprite(possibleSprites)])
        );

        // sets the obstacles position at a random point in lane "i"
        super.setPosition((int) (Math.random() * Gdx.graphics.getWidth()), i * 60);

//        super.setPosition(
//                (int) (Math.random() * Gdx.graphics.getWidth()),
//                (int) (Math.random() * Gdx.graphics.getHeight())
//        );

    }

    void detectObstacle() {

    }
}
