package uoy.thegame.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public abstract class Obstacle extends Entity {

    private int capableDamage;

    public Obstacle(int i, Texture texture) {

        // textures are passed in from concretes

        // initialise superclass

        super(
                (int) (Math.random() * (Gdx.graphics.getWidth() - 120) + 60),
                (int) (Math.random() * (Gdx.graphics.getHeight() - 75 - 101) + 75),
                texture
        );


        // logic: set proper calculated y position
        // using 50 as a multiplier spaces the obstacles out well
        // if y gets too big then we make it smaller

        int yp = i * 50;
        if (yp > 404) {
            yp -= 101;
        }

        this.setyPos(yp);
    }

    /**
     * Helper function to pick a random sprite from a list.
     *
     * @param possibleSprites array of paths to possible sprites
     * @return a random index relative to possibleSprites
     */
    static int getRandomSprite(String[] possibleSprites) {
        return (int) (Math.random() * (possibleSprites.length));
    }

    public int getCapableDamage() {
        return capableDamage;
    }

    public void setCapableDamage(int capableDamage) {
        this.capableDamage = capableDamage;
    }

    // Note: not overloading Entity/Actor methods here ('cause we don't need to)

}



