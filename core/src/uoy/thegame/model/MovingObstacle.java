package uoy.thegame.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class MovingObstacle extends Obstacle {
    int speed;
    String[] possibleSprites;

    public MovingObstacle(int levelNum) {

        super(levelNum);
        possibleSprites = new String[]{"goose/1.png", "obstacles/obsMov2.gif", "obstacles/obsMov3.gif"};

        super.setPosition(
                (int) (Math.random() * Gdx.graphics.getWidth()),
                (int) (Math.random() * Gdx.graphics.getHeight())
        );

        obsImg = new Sprite(new Texture(possibleSprites[levelNum - 1]));

        obsImg.setScale(0.1f);
    }

    void detectObstacle() {

    }
}
