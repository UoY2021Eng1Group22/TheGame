package uk.ac.york.cs.thegame;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class GameLevel {

    private int currentStage;
    Texture bgImg;
    private int stationaryObstacles;
    private int movingObstacles;
    private int dynamicObstacles;
    ArrayList<Obstacle> currentStageObstacles;
    private int amountOfOpponents;
    private int currentTotalObstacles = 0;

    public GameLevel(int stageNo) {   // will give the information associated with a certain level number, as well as generate the starting obstacles

        switch(stageNo) {
            case 1 :                // level one info
                currentStage = 1;
                stationaryObstacles = 3;
                movingObstacles = 1;
                dynamicObstacles = 0;
                amountOfOpponents = 0;
                bgImg = new Texture("skin/stage1.png");
                break;
            case 2 :            // level two info
                currentStage = 2;
                stationaryObstacles = 5;
                movingObstacles = 3;
                dynamicObstacles = 0;
                amountOfOpponents = 7;
                bgImg = new Texture("skin/stage1.png");
                break;
            case 3 :            // level three info
                currentStage = 3;
                stationaryObstacles = 9;
                movingObstacles = 5;
                dynamicObstacles = 0;
                amountOfOpponents = 7;
                bgImg = new Texture("skin/stage2.png");
                break;
            case 4:             // level four info
                currentStage = 4;
                stationaryObstacles = 15;
                movingObstacles = 8;
                dynamicObstacles = 2;
                amountOfOpponents = 3;
                bgImg = new Texture("skin/stage3.png");
                break;
            }

            currentStageObstacles = new ArrayList<>();
            for (int i = 0; i < stationaryObstacles; i++) {     // Creates amount of stationary obstacles for how many should be on this stage
                Obstacle startObst = new Obstacle(currentStage);
                currentStageObstacles.add(startObst);
                currentTotalObstacles++;
            }

            for (int i = 0; i < movingObstacles; i++) {
                Obstacle startMovObst = new MovingObstacle(currentStage);
                //currentStageObstacles.add(startMovObst);                 // not yet functional
            }


        }

    }

