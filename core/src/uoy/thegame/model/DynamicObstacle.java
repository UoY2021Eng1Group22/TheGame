package uoy.thegame.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class DynamicObstacle extends Obstacle {
    int lifespan;
    float frequency;
    int[] targetPos;
    Texture obsImg;

    public DynamicObstacle(int levelNum, int life, float freq) {
        super(levelNum, 0);
        lifespan = life;
        frequency = freq;
        targetPos = new int[2];
        targetPos[0] = (int) (Math.random() * Gdx.graphics.getWidth());
        targetPos[1] = (int) (Math.random() * Gdx.graphics.getHeight());

        obsImg = new Texture("obstacles/obsDyn1.png");
    }
}
