package uk.ac.york.cs.thegame;

import com.badlogic.gdx.graphics.Texture;

enum Direction {
    Up,
    Down,
    Left,
    Right
}

public class Entity {
    float xPos;
    float yPos;
    float width;
    float height;
    Texture sprite;
    float speed;



    public void remove(){
    }

    public void translate(Direction d){

        switch(d){
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
