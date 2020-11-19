package uoy.thegame.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

enum Direction {
    Up,
    Down,
    Left,
    Right
}

abstract class Entity extends Actor {

    private final Texture texture;
    private float xPos;
    private float yPos;

    // Note: extract Texture out as a class method (for assigning class variable)
    // throw error if texture is NullPointer

    // method: setPosition (setX, setY), translate (x, y)

    public Entity(float x, float y, Texture texture) {
        this.texture = texture;

        this.setBounds(xPos, yPos, this.texture.getWidth(), this.texture.getHeight());

        this.xPos = x;
        this.yPos = y;
    }

    public int[] getTextureDim() {
        return new int[]{this.texture.getWidth(), this.texture.getHeight()};
    }

    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(texture, xPos, yPos);
    }

    public float getxPos() {
        return xPos;
    }

    public float getyPos() {
        return yPos;
    }

    public void setxPos(float xPos) {
        this.xPos = xPos;
    }

    public void setyPos(float yPos) {
        this.yPos = yPos;
    }

    public void setPosition(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    public void translate(float x, float y) {
        this.xPos += x;
        this.yPos += y;
    }

    //    public void translate(Direction d) {
//
//        switch (d) {
//            case Up:
//                this.yPos += speed;
//            case Down:
//                this.yPos -= speed;
//            case Left:
//                this.xPos -= speed;
//            case Right:
//                this.xPos += speed;
//        }
//
//    }

}
