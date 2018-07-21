package be.swsb.coderetreat.rover;

import be.swsb.coderetreat.planet.Planet;
import be.swsb.coderetreat.positioning.Position;

import java.util.List;

import static be.swsb.coderetreat.positioning.Position.at;
import static be.swsb.coderetreat.rover.Command.FORWARD;
import static be.swsb.coderetreat.rover.Command.LEFT;
import static be.swsb.coderetreat.rover.Command.RIGHT;
import static be.swsb.coderetreat.rover.Direction.*;

class Rover {

    private Direction faceDirection;
    private Position currentPosition;
    private final Planet planet;

    public Rover() {
        this.faceDirection = NORTH;
        this.currentPosition = at(0, 0);
        this.planet = Planet.mars();
    }

    Rover(final Direction faceDirection, final Position currentPosition, final Planet planet) {
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
        switch (this.faceDirection) {
            case NORTH:
                this.currentPosition = this.currentPosition.up(1);
                break;
            case SOUTH:
                this.currentPosition = this.currentPosition.down(1);
                break;
            case EAST:
                this.currentPosition = this.currentPosition.right(1);
                break;
            case WEST:
                this.currentPosition = this.currentPosition.left(1);
                break;
        }
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
