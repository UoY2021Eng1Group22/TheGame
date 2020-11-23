package uoy.thegame.entitymodel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * DynamicObstacle are obstacles that spawns randomly in the final stage.
 */

//this class is not yet implemented.
public class DynamicObstacle extends Obstacle {
    private final int lifespan;
    private final float frequency;
    private final int[] targetPos;

    public DynamicObstacle(int levelNum, int life, float freq) {

        super(
                0,
                new Texture("obstacles/obsDyn1.png")
        );

        this.lifespan = life;
        this.frequency = freq;
        this.targetPos = new int[2];
        //where the dynamic obstacle will appear at first
        targetPos[0] = (int) (Math.random() * Gdx.graphics.getWidth());
        targetPos[1] = (int) (Math.random() * Gdx.graphics.getHeight());
    }
}
