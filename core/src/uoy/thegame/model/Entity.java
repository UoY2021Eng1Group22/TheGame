package uoy.thegame.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;

enum Direction {
    Up,
    Down,
    Left,
    Right
}

public class Entity extends Actor {
    float xPos;
    float yPos;
    float width;
    float height;
    Texture sprite;
    float speed;


    public void translate(Direction d) {

        switch (d) {
            case Up:
                this.yPos = this.yPos + speed;
            case Down:
                this.yPos = this.yPos - speed;
            case Left:
                this.xPos = this.xPos - speed;
            case Right:
                this.xPos = this.xPos + speed;
        }

    }

}
