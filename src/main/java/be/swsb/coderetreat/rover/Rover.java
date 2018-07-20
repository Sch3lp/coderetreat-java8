package be.swsb.coderetreat.rover;

import be.swsb.coderetreat.positioning.Position;

import static be.swsb.coderetreat.positioning.Position.at;
import static be.swsb.coderetreat.rover.Direction.NORTH;
import static be.swsb.coderetreat.rover.Direction.WEST;

class Rover {

    private Direction faceDirection = NORTH;
    private Position currentPosition = at(0,0);

    Direction faceDirection() {
        return this.faceDirection;
    }

    Position currentPosition() {
        return this.currentPosition;
    }

    void applyCommand(final Command cmd) {
        this.faceDirection = WEST;
    }
}
