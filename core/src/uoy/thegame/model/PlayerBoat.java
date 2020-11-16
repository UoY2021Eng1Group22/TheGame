package uoy.thegame.model;

import com.badlogic.gdx.graphics.Texture;

public class PlayerBoat extends Boat {
    public PlayerBoat(float x, float y, BoatType type, Texture texture) {
        super(x, y, type, texture);
    }

    // TODO: refactor to InputListener (obviously)

    public void move() {
//        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
//            this.translate(Direction.Right);
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
//            this.translate(Direction.Left);
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
//            this.translate(Direction.Down);
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
//            this.translate(Direction.Up);
//        }
    }
}
