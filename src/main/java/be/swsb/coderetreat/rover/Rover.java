package be.swsb.coderetreat.rover;

import be.swsb.coderetreat.positioning.Position;

import static be.swsb.coderetreat.positioning.Position.at;
import static be.swsb.coderetreat.rover.Direction.NORTH;
import static be.swsb.coderetreat.rover.Direction.SOUTH;
import static be.swsb.coderetreat.rover.Direction.WEST;

class Rover {

    private Direction faceDirection;
    private Position currentPosition;

    public Rover() {
        this.faceDirection = NORTH;
        this.currentPosition = at(0, 0);
    }

    Rover(final Direction faceDirection, final Position currentPosition) {
        this.faceDirection = faceDirection;
        this.currentPosition = currentPosition;
    }

    Direction faceDirection() {
        return this.faceDirection;
    }

    Position currentPosition() {
        return this.currentPosition;
    }

    void applyCommand(final Command cmd) {
        if (this.faceDirection == NORTH) {
            this.faceDirection = WEST;
        } else if (this.faceDirection == WEST) {
            this.faceDirection = SOUTH;
        }
    }
}
