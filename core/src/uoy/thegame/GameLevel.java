package uoy.thegame;

import com.badlogic.gdx.graphics.Texture;
import uoy.thegame.model.MovingObstacle;
import uoy.thegame.model.Obstacle;

import java.util.ArrayList;

public class GameLevel {

    private final ArrayList<Obstacle> currentStageObstacles;
    private final int currentStage;
    private final Texture bgImg;
    private final int stationaryObstacles;
    private final int movingObstacles;
    private final int dynamicObstacles;
    private final int amountOfOpponents;
    private int currentTotalObstacles;

    // will give the information associated with a certain level number, as well as generate the starting obstacles
    public GameLevel(int stageNo) {

        currentTotalObstacles = 0;

        // TODO: move custom assets out of `assets/skin`

        currentStage = stageNo;

        switch (currentStage) {
            case 1:                // level one info
                stationaryObstacles = 3;
                movingObstacles = 1;
                dynamicObstacles = 0;
                amountOfOpponents = 0;
                bgImg = new Texture("skin/stage1.png");
                break;
            case 2:            // level two info
                stationaryObstacles = 5;
                movingObstacles = 3;
                dynamicObstacles = 0;
                amountOfOpponents = 7;
                bgImg = new Texture("skin/stage1.png");
                break;
            case 3:            // level three info
                stationaryObstacles = 9;
                movingObstacles = 5;
                dynamicObstacles = 0;
                amountOfOpponents = 7;
                bgImg = new Texture("skin/stage2.png");
                break;
            case 4:             // level four info
                stationaryObstacles = 15;
                movingObstacles = 8;
                dynamicObstacles = 2;
                amountOfOpponents = 3;
                bgImg = new Texture("skin/stage3.png");
                break;
            default:
                throw new UnsupportedOperationException("Stage not implemented");
        }

        currentStageObstacles = new ArrayList<>();
        for (int i = 0; i < stationaryObstacles; i++) {     // Creates amount of stationary obstacles for how many should be on this stage
            currentStageObstacles.add(new Obstacle(currentStage));
            currentTotalObstacles++;
        }

        for (int i = 0; i < movingObstacles; i++) {
            Obstacle startMovObst = new MovingObstacle(currentStage);
            // currentStageObstacles.add(startMovObst);                 // not yet functional
        }


    }

    public Texture getTexture() {
        return this.bgImg;
    }

    public ArrayList<Obstacle> getCurrentStageObstacles() {
        return currentStageObstacles;
    }
}

