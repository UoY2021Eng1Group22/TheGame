package uk.ac.york.cs.thegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;



class Obstacle {
    int capableDamage;
    int [] position;
    String[][] possibleSprites = {{"skin/obs1.png", "skin/obs2.png"}, {"skin/obs1.png", "skin/obs2.png"}, {"skin/obs3.png", "skin/obs4.png"}, {"skin/obs5.png"}};
    Texture obsImg;

    public Obstacle() {

    }

    public Obstacle(int levelNum) {
        position = new int[2];
        position[0] = (int) (Math.random() * Gdx.graphics.getWidth());
        position[1] = (int) (Math.random() * (Gdx.graphics.getHeight() - 120) +120);  // Generates random x and y coordinates

        int ranSprite = (int) (Math.random() * (possibleSprites[levelNum-1].length));
        obsImg = new Texture(possibleSprites[levelNum-1][ranSprite]);       // chooses a sprite from the appropriate set
    }
}

class MovingObstacle extends Obstacle {
    int speed;
    String[] possibleSprites = {"skin/obsMov1.gif", "skin/obsMov2.gif", "skin/obsMov3.gif"};
    Texture obsImg;

    public MovingObstacle(int levelNum) {
        position = new int[2];
        position[0] = (int) (Math.random() * Gdx.graphics.getWidth());
        position[1] = (int) (Math.random() * (Gdx.graphics.getHeight() - 120) +120);
        obsImg = new Texture(possibleSprites[levelNum]);
    }

    void detectObstacle() {

    }
}

class DynamicObstacle extends Obstacle {
    int lifespan;
    float frequency;
    int[] targetPos;
    Texture obsImg;

    public DynamicObstacle(int levelNum, int life, float freq) {
        lifespan = life;
        frequency = freq;
        targetPos = new int[2];
        targetPos[0] = (int) (Math.random() * Gdx.graphics.getWidth());
        targetPos[1] = (int) (Math.random() * Gdx.graphics.getHeight());

        obsImg = new Texture("skin/obsDyn1.png");
    }
}



