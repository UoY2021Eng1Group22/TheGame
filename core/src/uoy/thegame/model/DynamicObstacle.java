package uoy.thegame.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class DynamicObstacle extends Obstacle {
    private final int lifespan;
    private final float frequency;
    private final int[] targetPos;
    private final Texture obsImg;

    public DynamicObstacle(int levelNum, int life, float freq) {
        super(levelNum);
        lifespan = life;
        frequency = freq;
        targetPos = new int[2];
        targetPos[0] = (int) (Math.random() * Gdx.graphics.getWidth());
        targetPos[1] = (int) (Math.random() * Gdx.graphics.getHeight());

        obsImg = new Texture("obstacles/obsDyn1.png");
    }
}
