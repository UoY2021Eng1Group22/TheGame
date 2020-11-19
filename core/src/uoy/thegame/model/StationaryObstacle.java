package uoy.thegame.model;

// Note: each Obstacle subclass has its own list of possibleSprites
// -> Create texture and pass it into superclass (Obstacle)

import com.badlogic.gdx.graphics.Texture;

public class StationaryObstacle extends Obstacle {

    private static final String[][] possibleSprites = {
            {"obstacles/obs1.png", "obstacles/obs2.png"},
            {"obstacles/obs1.png", "obstacles/obs2.png"},
            {"obstacles/obs3.png", "obstacles/obs4.png"},
            {"obstacles/obs5.png", "obstacles/obs5.png"}
    };

    public StationaryObstacle(int levelNum, int i) {
        super(
                levelNum,
                i,
                new Texture(possibleSprites[levelNum - 1][getRandomSprite(possibleSprites[levelNum - 1])])
        );
    }
}
