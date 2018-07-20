package be.swsb.coderetreat.rover;

import be.swsb.coderetreat.positioning.Position;

import java.util.Objects;

class RoverTestBuilder {
    private Direction faceDirection;
    private Position position;

    private RoverTestBuilder() {
    }

    public static Rover defaultRover() {
        return new Rover();
    }

    public static RoverTestBuilder aRover() {
        return new RoverTestBuilder();
    }

    public RoverTestBuilder facing(Direction faceDirection) {
        this.faceDirection = faceDirection;
        return this;
    }

    public RoverTestBuilder at(int x, int y) {
        this.position = Position.at(x,y);
        return this;
    }

    public Rover build() {
        Objects.requireNonNull(position, "position was not given");
        Objects.requireNonNull(faceDirection, "face direction was not given");
        return new Rover(faceDirection, position);
    }
}