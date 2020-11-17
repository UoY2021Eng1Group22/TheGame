package uoy.thegame.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;


public abstract class Obstacle extends Entity {
    private static final String[][] possibleSprites = {
            {"obstacles/obs1.png", "obstacles/obs2.png"},
            {"obstacles/obs1.png", "obstacles/obs2.png"},
            {"obstacles/obs3.png", "obstacles/obs4.png"},
            {"obstacles/obs5.png", "obstacles/obs5.png"}
    };

    private int capableDamage;

    public Obstacle(int levelNum, Texture texture) {

        // textures are passed in from concretes

        super(
                (int) (Math.random() * (Gdx.graphics.getWidth() - 120) + 60),
                (int) (Math.random() * (Gdx.graphics.getHeight() - 75 - 101) + 75),
                texture
        );
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



