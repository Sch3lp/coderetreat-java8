package be.swsb.coderetreat.rover;

import be.swsb.coderetreat.planet.Planet;
import be.swsb.coderetreat.positioning.Position;

class RoverTestBuilder {
    private Direction faceDirection;
    private Position position;
    private Planet planet;

    private RoverTestBuilder() {
    }

    public static Rover defaultRover() {
        return new Rover();
    }

    public static RoverTestBuilder aMarsRover() {
        return new RoverTestBuilder().on(Planet.mars());
    }

    public RoverTestBuilder facing(Direction faceDirection) {
        this.faceDirection = faceDirection;
        return this;
    }

    public RoverTestBuilder at(int x, int y) {
        this.position = Position.at(x,y);
        return this;
    }

    public RoverTestBuilder on(final Planet planet) {
        this.planet = planet;
        return this;
    }

    public Rover build() {
        return new Rover(faceDirection, position, planet);
    }
}