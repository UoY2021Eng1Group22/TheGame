package uoy.thegame.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class Obstacle extends Actor {
    private final Sprite obsImg;
    int capableDamage;
    String[][] possibleSprites = {{"skin/obs1.png", "skin/obs2.png"}, {"skin/obs1.png", "skin/obs2.png"}, {"skin/obs3.png", "skin/obs4.png"}, {"skin/obs5.png"}};


    public Obstacle(int levelNum) {

        var ranSprite = (int) (Math.random() * (possibleSprites[levelNum - 1].length));
        obsImg = new Sprite( new Texture(possibleSprites[levelNum - 1][ranSprite]));       // chooses a sprite from the appropriate set

        this.setPosition(
                (int) (Math.random() * Gdx.graphics.getWidth()), // Generates random x and y coordinates
                (int) (Math.random() * (Gdx.graphics.getHeight() - 120) + 120)
        );

        setBounds(obsImg.getX(),obsImg.getY(),obsImg.getWidth(), obsImg.getHeight());
    }

    public Sprite getObsImg() {
        return obsImg;
    }

    public int[] getPosition() {
        int[] pos = {(int)obsImg.getX(),(int)obsImg.getY()};
        return pos;
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



