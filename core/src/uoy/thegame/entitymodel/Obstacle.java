package uoy.thegame.entitymodel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public abstract class Obstacle extends Entity {

    private int capableDamage;

    public Obstacle(int i, Texture texture) {

        // textures are passed in from concretes

        // initialise superclass

        // x = a random position on the x axis, multiplied by the width of the screen (-120, as a way to stop it spawning
        // off the screen's right hand side, then added by 60 so it doesn't spawn right in front of the boats.

        //y = a random position on the x axis, bounded by the top and bottom lanes
        super(
                (int) (Math.random() * (Gdx.graphics.getWidth() - 120) + 60),
                (int) (Math.random() * (Gdx.graphics.getHeight() - 75 - 101) + 75),
                texture
        );


        // logic: adjusts the y coordinate of the obstacle
        // if y gets too big then we make it smaller
        // we have found that using 50 as a multiplier spaces the obstacles out well
        // this helps space out the obstacles so they dont end up inbetween lanes (see the stage 2 texture for why this is an issue)

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

    // Note: not overloading the inherited Entity/Actor methods here because obstacle is still abstract, therefore we dont need to

}



