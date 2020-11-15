package uoy.thegame.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class PlayerBoat extends Boat {

    public void move() {
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            this.translate(Direction.Right);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            this.translate(Direction.Left);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            this.translate(Direction.Down);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            this.translate(Direction.Up);
        }
    }
}
