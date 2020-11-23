package uoy.thegame.logic;

import com.badlogic.gdx.graphics.Texture;
import uoy.thegame.entitymodel.*;

import java.util.ArrayList;

// a class for generating the ai boats and obstacles, as well as storing information about the current stage
// e.g. the texture of the stage, number of opponents etc
public class GameLevel {

    //some of these may be obsolete?
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

        //assigns the level's information using a switch case
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

        currentStageEnemies = new ArrayList<>();

        var obstacleGenerator = new ObstacleGenerator(currentStage);
        this.currentStageObstacles = obstacleGenerator.generateObstacles(
                stationaryObstacles,
                movingObstacles,
                dynamicObstacles
        );

        // subroutine: generateOpponents

        for (int k = 0; k < amountOfOpponents; k++) {
            currentStageEnemies.add(new EnemyBoat(0, 0, Boat.BoatType.Small, new Texture("Boats/1.png")));
        }

    }

    public Texture getBgImg() {
        return this.bgImg;
    }

    public ArrayList<Obstacle> getCurrentStageObstacles() {
        return currentStageObstacles;
    }

    public ArrayList<Boat> getCurrentStageEnemies() {
        return currentStageEnemies;
    }

    public int getCurrentStage() {
        return currentStage;
    }

    public int getAmountOfOpponents() {
        return amountOfOpponents;
    }

    public int getStationaryObstacles() {
        return stationaryObstacles;
    }

    public int getMovingObstacles() {
        return movingObstacles;
    }

    public int getDynamicObstacles() {
        return dynamicObstacles;
    }

}

// a class for generating the obstacles
class ObstacleGenerator {

    private final int levelNum;

    ObstacleGenerator(int levelNum) {
        this.levelNum = levelNum;
    }

    ArrayList<Obstacle> generateObstacles(int stationary, int moving, int dynamic) {

        // "generic obstacles"
        // can contain any obstacles and its subclass

        // list of obstacles
        var obstacles = new ArrayList<Obstacle>();

        // adds stationary obstacles
        for (int i = 0; i < stationary; i++) {
            obstacles.add(new StationaryObstacle(levelNum, i));
        }

        //moving
        for (int i = 0; i < moving; i++) {
            obstacles.add(new MovingObstacle(levelNum, 1));
        }

        //dynamic
        for (int i = 0; i < dynamic; i++) {
            obstacles.add(new DynamicObstacle(levelNum, 10, 10));
        }

        return obstacles;

    }
}

