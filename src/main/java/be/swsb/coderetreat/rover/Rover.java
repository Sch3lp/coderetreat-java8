package be.swsb.coderetreat.rover;

import be.swsb.coderetreat.positioning.Position;

class Rover {

    private Direction faceDirection = Direction.NORTH;
    private Position currentPosition = new Position(0,0);

    Direction faceDirection() {
        return this.faceDirection;
    }

    Position currentPosition() {
        return this.currentPosition;
    }
}
