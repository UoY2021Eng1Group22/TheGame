package uk.ac.york.cs.thegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

class Obstacle {
    int capableDamage;
    int [] position;
    String[] possibleSprites = {"obs1.png", "obs2.png"};
    Texture obsImg;

    public Obstacle() {
        position = new int[2];
        position[0] = (int) (Math.random() * Gdx.graphics.getWidth());
        position[1] = (int) (Math.random() * Gdx.graphics.getHeight());

        int ranSprite = (int) (Math.random() * (possibleSprites.length));
        obsImg = new Texture(possibleSprites[ranSprite]);
    }
}

class MovingObstacle extends Obstacle {
    int speed;
    String[] possibleSprites = {"obsMov1.png", "obsMov2.png"};
    Texture obsImg;

    public MovingObstacle() {
        int ranSprite = (int) (Math.random() * (possibleSprites.length));
        obsImg = new Texture(possibleSprites[ranSprite]);
    }

    void detectObstacle() {

    }
}

class DynamicObstacle extends Obstacle {
    int lifespan;
    float frequency;
    int[] targetPos;
    String[] possibleSprites = {"obsDyn1.png", "obsDyn2.png"};
    Texture obsImg;

    public DynamicObstacle(int life, float freq) {
        lifespan = life;
        frequency = freq;
        targetPos = new int[2];
        targetPos[0] = (int) (Math.random() * Gdx.graphics.getWidth());
        targetPos[1] = (int) (Math.random() * Gdx.graphics.getHeight());

        int ranSprite = (int) (Math.random() * (possibleSprites.length));
        obsImg = new Texture(possibleSprites[ranSprite]);
    }
}



