package uoy.thegame.model;

import com.badlogic.gdx.graphics.Texture;

/**
 * Boat is an abstract object
 */
public abstract class Boat extends Entity {

    private float speed;
    private float health;
    private float acceleration;
    private float agility;
    private float maxSpeed;
    private float exhaustion;
    private int racePosition;

    // max speed indicates the speed stat
    // speed is used for current speed so it starts at 0
    // all boats start at x=0. the starting y pos is different for each boat

//    public Boat() {
//        super();
//        this.health = 3;
//        this.acceleration = 3;
//        this.maxSpeed = 3;
//        this.agility = 3;
//        xPos = 0;
//        yPos = 0;
//    }

//    public Boat() {
//        // default!
//        this(0, 0, BoatType.Medium);
//    }

    // TODO: getter/setter for all the properties
    // Note: make java beans? -> implements serializable

    public Boat(float x, float y, BoatType type, Texture texture) {
        super(x, y, texture);

        this.speed = 0;
        this.exhaustion = 0;

        switch (type) {
            case VerySmall:
                this.health = 1;
                this.acceleration = 5;
                this.maxSpeed = 1;
                this.agility = 5;
                //sprite = verySmall
                break;
            case Small:
                this.health = 2;
                this.acceleration = 4;
                this.maxSpeed = 2;
                this.agility = 4;
                //sprite = small
                break;
            case Medium:
                this.health = 3;
                this.acceleration = 3;
                this.maxSpeed = 3;
                this.agility = 3;
                //sprite = medium
                break;
            case Large:
                this.health = 4;
                this.acceleration = 2;
                this.maxSpeed = 4;
                this.agility = 2;
                //sprite = large
                break;
            case VeryLarge:
                this.health = 5;
                this.acceleration = 1;
                this.maxSpeed = 5;
                this.agility = 1;
                //sprite = veryLarge
                break;
        }
    }

    //    @Override
    public void translate(Direction d) {

//        switch (d) {
//            case Up:
//                this.yPos = this.yPos + this.agility / 10;
//            case Down:
//                this.yPos = this.yPos - this.agility / 10;
//            case Left: //slowing down
//                speed = decelerate(speed);
//                speed -= exhaustion;
//                this.xPos = this.xPos + speed;
//            case Right:
//                speed = accelerate(speed);
//                speed -= exhaustion;
//                this.xPos = this.xPos + speed;
//        }

        switch (d) {
            case Up:
                this.translate(0, this.getyPos() + this.agility / 10);
                break;
            case Down:
                this.translate(0, this.getyPos() - this.agility / 10);
                break;
            case Left:
                this.speed = this.decelerate(this.speed);
                this.speed -= this.exhaustion;
                this.translate(this.getxPos() + speed, 0);
                break;
            case Right:
                this.speed = this.accelerate(this.speed);
                this.speed -= this.exhaustion;
                this.translate(this.getxPos() + speed, 0);
                break;
        }

        this.exhaustion += 0.01;
    }

    // override translate
    // boats use their agility stat for movements in the y axis
    // dividing factor on agility is key so jumps are not too big
    // left movement is slowdown not moving left,
    // boat still moves right but at a slower speed, until the speed reaches 0

    private float accelerate(float speed) {
        if (speed == maxSpeed) {
            return speed;
        }
        speed += speed * (this.acceleration / 10);
        return speed;
    }

    private float decelerate(float speed) {
        if (speed <= 0) {
            speed = 0;
            return speed;
        }
        speed -= speed * (this.acceleration / 10);
        if (speed < 0) {
            speed = 0;
        }
        return speed;
    }

    public float getHealth() {
        return this.health;
    }

    public void decreaseHealth() {
        this.health -= 1;
    }

    public enum BoatType {
        VerySmall,
        Small,
        Medium,
        Large,
        VeryLarge
    }

}