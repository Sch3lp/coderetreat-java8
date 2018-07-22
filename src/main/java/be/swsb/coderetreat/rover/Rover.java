package be.swsb.coderetreat.rover;

import be.swsb.coderetreat.planet.Planet;
import be.swsb.coderetreat.positioning.Position;

import java.util.List;
import java.util.Objects;

import static be.swsb.coderetreat.positioning.Position.at;
import static be.swsb.coderetreat.rover.Direction.NORTH;

class Rover {

    private Direction faceDirection;
    private Position currentPosition;
    private final Planet planet;

    public Rover() {
        this(NORTH, at(0, 0), Planet.mars());
    }

    Rover(final Direction faceDirection, final Position currentPosition, final Planet planet) {
        Objects.requireNonNull(currentPosition, "position was not given");
        Objects.requireNonNull(faceDirection, "face direction was not given");
        Objects.requireNonNull(planet, "planet was not given");
        this.faceDirection = faceDirection;
        this.currentPosition = currentPosition;
        this.planet = planet;
    }

    Direction faceDirection() {
        return this.faceDirection;
    }

    Position currentPosition() {
        return this.currentPosition;
    }

    Planet planet() {
        return this.planet;
    }

    void handleCommands(final List<Command> commands) {
        commands.forEach(this::handle);
    }

    void handle(final Command cmd) {
        switch (cmd) {
            case LEFT:
                this.faceDirection = this.faceDirection.counterClockwise();
                break;
            case RIGHT:
                this.faceDirection = this.faceDirection.clockwise();
                break;
            case FORWARD:
                moveForward();
                break;
            case BACKWARD:
                moveBackward();
                break;
        }
    }

    private void moveForward() {
        Position newPosition = this.currentPosition;
        switch (this.faceDirection) {
            case NORTH:
                newPosition = this.currentPosition.up(1);
                break;
            case SOUTH:
                newPosition = this.currentPosition.down(1);
                break;
            case EAST:
                newPosition = this.currentPosition.right(1);
                break;
            case WEST:
                newPosition = this.currentPosition.left(1);
                break;
        }

        this.currentPosition = wrapIfNecessary(newPosition);
    }

    private Position wrapIfNecessary(final Position newPosition) {
        return planet.wrap(newPosition);
    }

    private void moveBackward() {
        switch (this.faceDirection) {
            case NORTH:
                this.currentPosition = this.currentPosition.down(1);
                break;
            case SOUTH:
                this.currentPosition = this.currentPosition.up(1);
                break;
            case EAST:
                this.currentPosition = this.currentPosition.left(1);
                break;
            case WEST:
                this.currentPosition = this.currentPosition.right(1);
                break;
        }
    }
}
