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
    private final Rectangle rect;

    // Note: Pixmap -> Texture -> TextureRegion (?)
    // Scale at Pixmap

    // private boolean isAnimated;

    // Note: extract Texture out as a class method (for assigning class variable)
    // throw error if texture is NullPointer

    // method: setPosition (setX, setY), translate (x, y)

    public Entity(float x, float y, Texture texture) {

        this.texture = texture;

//        this.xPos = x;
//        this.yPos = y;
//        var pixmap = new Pixmap
        this.setWidth(texture.getWidth());
        this.setHeight(texture.getHeight());
        this.setPosition(x, y);

        //used to set the texture boundaries
        this.setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        this.setSize(this.getWidth(), this.getHeight());
        this.setOrigin(0, 0);

        this.rect = new Rectangle((int) x, (int) y, this.getWidth(), this.getHeight());

        //as we are using Textures instead of Sprites for the texture, we must store the entity's position

    }

    // used by the main game code to draw the Entity Actor to the screen
    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(texture, this.getX(), this.getY());
    }

    private void entityPos(float x, float y) {

//        this.setPosition(x, y);
//        this.setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());

//        var v2 = new Vector2();
//        v2.set(x, y);
//
//        this.stageToLocalCoordinates(v2);

        this.setPosition(x, y);
        this.setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        this.rect.set(this.getX(), this.getY(), this.getWidth(), this.getHeight());

//        Gdx.app.log("entity", String.format("getpos: x: %f, y: %f", this.getX(), this.getY()));
//        Gdx.app.log("entity", String.format("bounds: %s", this.rect.getBounds()));
    }

    public void translate(float x, float y) {
//        this.xPos += x;
//        this.yPos += y;

        var newX = this.getX() + x;
        var newY = this.getY() + y;

        this.entityPos(newX, newY);

    }

    public Rectangle getRect() {
        return rect;
    }

    // collision detection between different actors
//    public Rectangle getBounds() {
//        return bounds;
//    }
}
