package uoy.thegame.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class MovingObstacle extends Obstacle {

    // TODO: adapt entity class to accept animations.

    private static final String[] possibleSprites = {
            "goose/1.png",
            "obstacles/obsMov2.gif", // placeholder
            "obstacles/obsMov3.gif"
    };

    public MovingObstacle(int levelNum, int i) {

        super(
                levelNum,
                i,
                new Texture(possibleSprites[getRandomSprite(possibleSprites)])
        );

        super.setPosition(
                (int) (Math.random() * Gdx.graphics.getWidth()), i*60);

//        super.setPosition(
//                (int) (Math.random() * Gdx.graphics.getWidth()),
//                (int) (Math.random() * Gdx.graphics.getHeight())
//        );
//
//        obsImg = new Sprite(new Texture(possibleSprites[levelNum - 1]));
//
//        obsImg.setScale(0.1f);
    }

    void detectObstacle() {

    }
}
