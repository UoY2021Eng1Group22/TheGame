package uoy.thegame.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class Obstacle extends Actor {
    Sprite obsImg;
    int capableDamage;
    String[][] possibleSprites;


    public Obstacle(int levelNum, int i ) {

        possibleSprites = new String[][]{{"obstacles/obs1.png", "obstacles/obs2.png"}, {"obstacles/obs1.png", "obstacles/obs2.png"}, {"obstacles/obs3.png", "obstacles/obs4.png"}, {"obstacles/obs5.png"}};
        var ranSprite = (int) (Math.random() * (possibleSprites[levelNum - 1].length));
        obsImg = new Sprite( new Texture(possibleSprites[levelNum - 1][ranSprite]));       // chooses a sprite from the appropriate set

        int xp = (int) (Math.random() * (Gdx.graphics.getWidth() - 120) + 60); // obstacles will spawn 60 pixels from each side
       // int yp = (int) (Math.random() * (Gdx.graphics.getHeight()-75-101) + 75);
       //using 50 as a multiplyer spaces the obstacles out well
        //if y gets too big then we make it smaller
        int yp = i*50;
        if(yp > 404){
            yp -= 101;
        }

        this.setPosition(
                xp, // Generates random x and y coordinates
                yp
        );

        setBounds(obsImg.getX(),obsImg.getY(),obsImg.getWidth(), obsImg.getHeight());
    }

    public Sprite getObsImg() {
        return obsImg;
    }

    public int[] getPosition() {
        return new int[]{(int)obsImg.getX(),(int)obsImg.getY()};
    }

    public void setPosition(int x, int y) {
        obsImg.setPosition(x,y);
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        obsImg.draw(batch);
    }

    @Override
    public void act(float delta){
        super.act(delta);
    }


}



