package uk.ac.york.cs.thegame;

public class Boat extends Entity {

    enum Type{
        VerySmall,
        Small,
        Medium,
        Large,
        VeryLarge
    }
    float health;
    float acceleration;
    float agility;
    int exhaustion;
    int position;

    public Boat(Type t){
        switch(t){
            case VerySmall:
                this.health = 1;
                this.acceleration = 5;
                this.speed = 1;
                this.agility = 5;
                break;
            case Small:
                this.health = 2;
                this.acceleration = 4;
                this.speed = 2;
                this.agility = 4;
                break;
            case Medium:
                this.health = 3;
                this.acceleration = 3;
                this.speed = 3;
                this.agility = 3;
                break;
            case Large:
                this.health = 4;
                this.acceleration = 2;
                this.speed = 4;
                this.agility = 2;
                break;
            case VeryLarge:
                this.health = 5;
                this.acceleration = 1;
                this.speed = 5;
                this.agility = 1;
                break;


        

        }


    }

}