package uoy.thegame.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;


public class Obstacle extends Entity {
    private static final String[][] possibleSprites = {{"obstacles/obs1.png", "obstacles/obs2.png"}, {"obstacles/obs1.png", "obstacles/obs2.png"}, {"obstacles/obs3.png", "obstacles/obs4.png"}, {"obstacles/obs5.png"}};
    //    private final Sprite obsImg;
    private int capableDamage;


    public Obstacle(int levelNum) {

        super(
                (int) (Math.random() * Gdx.graphics.getWidth()),
                (int) (Math.random() * (Gdx.graphics.getHeight() - 120) + 120),
                new Texture(possibleSprites[levelNum - 1][getRandomSprite(levelNum)])
        );


//        obsImg = new Sprite( new Texture(possibleSprites[levelNum - 1][randomSprite]));       // chooses a sprite from the appropriate set

//        this.setPosition(
//                (int) (Math.random() * Gdx.graphics.getWidth()), // Generates random x and y coordinates
//                (int) (Math.random() * (Gdx.graphics.getHeight() - 120) + 120)
//        );


//        setBounds(obsImg.getX(),obsImg.getY(),obsImg.getWidth(), obsImg.getHeight());
    }

    private static int getRandomSprite(int levelNum) {
        return (int) (Math.random() * (possibleSprites[levelNum - 1].length));
    }

//    public Sprite getObsImg() {
//        return obsImg;
//    }

//    public int[] getPosition() {
//        int[] pos = {(int)obsImg.getX(),(int)obsImg.getY()};
//        return pos;
//    }

    public int getCapableDamage() {
        return capableDamage;
    }

    public void setCapableDamage(int capableDamage) {
        this.capableDamage = capableDamage;
    }

//    public void setPosition(int x, int y) {
//        obsImg.setPosition(x,y);
//    }

//    @Override
//    public void draw(Batch batch, float parentAlpha){
//        obsImg.draw(batch);
//    }
//
//    @Override
//    public void act(float delta){
//        super.act(delta);
//    }

}


