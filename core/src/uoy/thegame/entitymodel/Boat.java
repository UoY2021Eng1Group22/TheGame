package uoy.thegame.entitymodel;

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
    private boolean hasStarted;
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
        this.exhaustion = 1;
        this.hasStarted = false;

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


    public void translateBoat(Direction d) {

        switch (d) {
            case Up:
                this.translate(0, this.agility / 5);
                break;
            case Down:
                this.translate(0, -(this.agility / 5));
                break;
            case Left:
                this.speed = this.decelerate(this.speed);


                break;
            case Right:
                //upon moving forward the has started bool is set to true which starts the exhaustion
                //value being decreased
                //the speed only increases if it isn't already at the max speed
                hasStarted = true;
                if (speed <= maxSpeed/5){
                    this.speed = this.accelerate(this.speed);

                }

                break;

        }

    }

    // override translate
    // boats use their agility stat for movements in the y axis
    // dividing factor on agility is key so jumps are not too big
    // left movement is slowdown not moving left,
    // boat still moves right but at a slower speed, until the speed reaches 0

    private float accelerate(float speed) {

        //if speed is 0, multiplying it by the acceleration wouldn't work
        if (speed == 0){
            // We divide acceleration by 10 as an easy way to balance how fast the boat goes
            speed += this.acceleration / 10;
            return speed;
        }

        speed += speed * (this.acceleration / 10);
        return speed;
    }

    private float decelerate(float speed) {

        //same as the acceleration function except if speed is already 0, or speed will become lower than 0 then just set speed to 0
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

    //the act function runs constantly once the game has started
    //this is used to keep the boat moving constantly at its current speed
    //exhaustion is decreased here, however this only starts once the
    //boat has started moving
    @Override
    public void act(float delta) {

        this.translate(speed*exhaustion, 0);
        if (hasStarted){
            // 0.5, or 50% exhaustion is the limit we have set on how exhausted the rowers can become
            if(this.exhaustion > 0.5){
                // 0.0005 is the amount we are decreasing exhaustion by each time the boat "acts"
                this.exhaustion -= 0.0005;
            }
        }

        //these values are  just outputted as a test
        //not to be included in final version
//        System.out.println(speed*exhaustion);
//        System.out.println(exhaustion);

    }

    //non implemented functions for finding the boats hp and decreasing the hp
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