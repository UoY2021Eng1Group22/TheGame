package uoy.thegame;

import com.badlogic.gdx.graphics.Texture;
import uoy.thegame.model.*;

import java.util.ArrayList;

public class GameLevel {

    private final ArrayList<Obstacle> currentStageObstacles;
    private final ArrayList<Boat> currentStageEnemies;
    private final int currentStage;
    private final Texture bgImg;
    private final int stationaryObstacles;
    private final int movingObstacles;
    private final int dynamicObstacles;
    private final int amountOfOpponents;

    // will give the information associated with a certain level number, as well as generate the starting obstacles
    public GameLevel(int stageNo) {

        // TODO: move custom assets out of `assets/skin`

        currentStage = stageNo;

        switch (currentStage) {
            case 1:                // level one info
                stationaryObstacles = 3;
                movingObstacles = 1;
                dynamicObstacles = 0;
                amountOfOpponents = 0;
                bgImg = new Texture("stages/stage1.png");
                break;
            case 2:            // level two info
                stationaryObstacles = 5;
                movingObstacles = 3;
                dynamicObstacles = 0;
                amountOfOpponents = 6;
                bgImg = new Texture("stages/stage1.png");
                break;
            case 3:            // level three info
                stationaryObstacles = 9;
                movingObstacles = 5;
                dynamicObstacles = 0;
                amountOfOpponents = 6;
                bgImg = new Texture("stages/stage2.PNG");
                break;
            case 4:             // level four info
                stationaryObstacles = 15;
                movingObstacles = 8;
                dynamicObstacles = 2;
                amountOfOpponents = 3;
                bgImg = new Texture("stages/stage3.PNG");
                break;
            default:
                throw new UnsupportedOperationException("Stage not implemented");
        }


        // moved
//        currentStageObstacles = new ArrayList<>();
//        for (int i = 0; i < stationaryObstacles; i++) {     // Creates amount of stationary obstacles for how many should be on this stage
//            currentStageObstacles.add(new Obstacle(currentStage));
//            currentTotalObstacles++;
//        }
//
//        for (int i = 0; i < movingObstacles; i++) {
//            var startMovObst = new MovingObstacle(currentStage);
//            // currentStageObstacles.add(startMovObst);                 // not yet functional
//        }

        currentStageEnemies = new ArrayList<>();

        var obstacleGenerator = new ObstacleGenerator(currentStage);
        this.currentStageObstacles = obstacleGenerator.generateObstacles(
                stationaryObstacles,
                movingObstacles,
                dynamicObstacles
        );

        // subroutine: generateOpponents

/*        for (int k = 0; k < amountOfOpponents; k++) {
            currentStageEnemies.add(new Boat());
        }
*/

    }

    public Texture getTexture() {
        return this.bgImg;
    }

    public ArrayList<Obstacle> getCurrentStageObstacles() {
        return currentStageObstacles;
    }

    public ArrayList<Boat> getCurrentStageEnemies() {
        return currentStageEnemies;
    }
}

class ObstacleGenerator {

    private final int levelNum;

    ObstacleGenerator(int levelNum) {
        this.levelNum = levelNum;
    }

    ArrayList<Obstacle> generateObstacles(int stationary, int moving, int dynamic) {

        // "generic obstacles"
        // can contain any obstacles and its subclass

        var obstacles = new ArrayList<Obstacle>();

        for (int i = 0; i < stationary; i++) {
            obstacles.add(new StationaryObstacle(levelNum, i));
        }

        for (int i = 0; i < moving; i++) {
            obstacles.add(new MovingObstacle(levelNum, 1));
        }

        for (int i = 0; i < dynamic; i++) {
            obstacles.add(new DynamicObstacle(levelNum, 10, 10));
        }

        return obstacles;

    }
}

