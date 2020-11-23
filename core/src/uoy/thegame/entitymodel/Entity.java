package uoy.thegame.entitymodel;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

// an enum class called Direction that will be passed into the Boat class' translate function
enum Direction {
    Up,
    Down,
    Left,
    Right
}

// collision ref: https://gamedev.stackexchange.com/questions/87889/libgdx-how-to-check-collision-of-randomly-generated-actors

/**
 * Entity contains custom logics / shortcuts for other parts of the code to
 * interact with the libgdx api,
 * including setting coordinates, and textures.
 * such as for obstacles and boats
 */
public abstract class Entity extends Actor {

    /*
    Design decisions:
    - Made abstract as this class must not be instantiated directly.
      - There are more concrete subtypes to use. (Obstacles, Boats)
    - Sprites are not used.
     */

    // TODO: Texture scaling
    // TODO: Texture Region

    private final Texture texture;
    private final Rectangle bounds;
    private float xPos;
    private float yPos;

    // private boolean isAnimated;

    // Note: extract Texture out as a class method (for assigning class variable)
    // throw error if texture is NullPointer

    // method: setPosition (setX, setY), translate (x, y)

    public Entity(float x, float y, Texture texture) {
        this.texture = texture;


        //used to set the texture boundaries
        this.setBounds(xPos, yPos, this.texture.getWidth(), this.texture.getHeight());

        this.bounds = new Rectangle((int) xPos, (int) yPos, this.getWidth(), this.getHeight());

        //as we are using Textures instead of Sprites for the texture, we must store the entity's position
        this.xPos = x;
        this.yPos = y;

    }

    public int[] getTextureDim() {
        return new int[]{this.texture.getWidth(), this.texture.getHeight()};
    }

    // used by the main game code to draw the Entity Actor to the screen
    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(texture, xPos, yPos);
    }

    public float getxPos() {
        return xPos;
    }

    public void setxPos(float xPos) {
        this.xPos = xPos;
    }

    public float getyPos() {
        return yPos;
    }

    public void setyPos(float yPos) {
        this.yPos = yPos;
    }

    public void setPosition(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    public String getPosStr() {
        return String.format("(%f,%f)", this.getxPos(), this.getyPos());
    }

    public void translate(float x, float y) {
        this.xPos += x;
        this.yPos += y;
    }

    // old code for movement and translation, now moved to the boat class
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

    // collision detection between different actors
    public Rectangle getBounds() {
        return bounds;
    }
}
