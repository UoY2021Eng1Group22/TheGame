package uk.ac.york.cs.thegame;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class GameLevel {

    private int currentStage;
    Texture bgImg;
    private int stationaryObstacles;
    private int movingObstacles;
    private int dynamicObstacles;
    private ArrayList<Obstacle> currentStageObstacles;
    private int amountOfOpponents;
    private int currentTotalObstacles;

    public GameLevel(int stageNo) {

        switch(stageNo) {
            case 1 :
                currentStage = 1;
                stationaryObstacles = 3;
                movingObstacles = 1;
                dynamicObstacles = 0;
                amountOfOpponents = 0;
                bgImg = new Texture("stage1.png");
                break;
            case 2 :
                currentStage = 2;
                stationaryObstacles = 5;
                movingObstacles = 3;
                dynamicObstacles = 0;
                amountOfOpponents = 7;
                bgImg = new Texture("stage2.png");
                break;
            case 3 :
                currentStage = 3;
                stationaryObstacles = 9;
                movingObstacles = 5;
                dynamicObstacles = 0;
                amountOfOpponents = 7;
                bgImg = new Texture("stage3.png");
                break;
            case 4:
                currentStage = 4;
                stationaryObstacles = 15;
                movingObstacles = 8;
                dynamicObstacles = 2;
                amountOfOpponents = 3;
                bgImg = new Texture("stage4.png");
                break;
            }
        }

    }
