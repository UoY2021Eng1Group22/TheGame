package uoy.thegame.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class MovingObstacle extends Obstacle {
    int speed;
    String[] possibleSprites = {"obstacles/obsMov1.gif", "obstacles/obsMov2.gif", "obstacles/obsMov3.gif"};
    Texture obsImg;

    public MovingObstacle(int levelNum) {

        super(levelNum);

        super.setPosition(
                (int) (Math.random() * Gdx.graphics.getWidth()),
                (int) (Math.random() * (Gdx.graphics.getHeight() - 120) + 120)
        );

        obsImg = new Texture(possibleSprites[levelNum]);
    }

    void detectObstacle() {

    }
}
