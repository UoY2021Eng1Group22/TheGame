package uoy.thegame.entitymodel;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

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
    private float xPos;
    private float yPos;

    private final Rectangle bounds;

    // private boolean isAnimated;

    // Note: extract Texture out as a class method (for assigning class variable)
    // throw error if texture is NullPointer

    // method: setPosition (setX, setY), translate (x, y)

    public Entity(float x, float y, Texture texture) {
        this.texture = texture;

        this.setBounds(xPos, yPos, this.texture.getWidth(), this.texture.getHeight());

        this.bounds = new Rectangle((int) xPos, (int) yPos, this.getWidth(), this.getHeight());
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

    public String getPosStr() {
        return String.format("(%f,%f)", this.getxPos(), this.getyPos());
    }

    public void translate(float x, float y) {
        this.xPos += x;
        this.yPos += y;
    }

    // collision detection between different actors

    public Rectangle getBounds() {
        return bounds;
    }
}
