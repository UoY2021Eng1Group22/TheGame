package uoy.thegame.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;


public class Obstacle {
    private final int[] position;
    private final Texture obsImg;
    int capableDamage;
    String[][] possibleSprites = {{"skin/obs1.png", "skin/obs2.png"}, {"skin/obs1.png", "skin/obs2.png"}, {"skin/obs3.png", "skin/obs4.png"}, {"skin/obs5.png"}};

//    public Obstacle() {
//
//    }

    public Obstacle(int levelNum) {
        position = new int[2];

        this.setPosition(
                (int) (Math.random() * Gdx.graphics.getWidth()), // Generates random x and y coordinates
                (int) (Math.random() * (Gdx.graphics.getHeight() - 120) + 120)
        );

        var ranSprite = (int) (Math.random() * (possibleSprites[levelNum - 1].length));
        obsImg = new Texture(possibleSprites[levelNum - 1][ranSprite]);       // chooses a sprite from the appropriate set
    }

    public Texture getObsImg() {
        return obsImg;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        this.position[0] = x;
        this.position[1] = y;
    }
}



