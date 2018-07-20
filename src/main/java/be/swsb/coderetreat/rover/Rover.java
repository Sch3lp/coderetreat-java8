package be.swsb.coderetreat.rover;

import be.swsb.coderetreat.positioning.Position;

import static be.swsb.coderetreat.positioning.Position.at;

class Rover {

    private Direction faceDirection = Direction.NORTH;
    private Position currentPosition = at(0,0);

    Direction faceDirection() {
        return this.faceDirection;
    }

    Position currentPosition() {
        return this.currentPosition;
    }
}
