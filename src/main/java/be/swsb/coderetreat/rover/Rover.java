package be.swsb.coderetreat.rover;

import be.swsb.coderetreat.positioning.Position;

import static be.swsb.coderetreat.positioning.Position.at;
import static be.swsb.coderetreat.rover.Command.FORWARD;
import static be.swsb.coderetreat.rover.Command.LEFT;
import static be.swsb.coderetreat.rover.Command.RIGHT;
import static be.swsb.coderetreat.rover.Direction.*;

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
        if (cmd == LEFT) {
            this.faceDirection = this.faceDirection.counterClockwise();
        } else if (cmd == RIGHT) {
            this.faceDirection = this.faceDirection.clockwise();
        } else if (cmd == FORWARD) {
            this.currentPosition = this.currentPosition.up(1);
        }
    }
}
