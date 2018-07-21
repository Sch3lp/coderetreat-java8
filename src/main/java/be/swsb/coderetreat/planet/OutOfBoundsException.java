package be.swsb.coderetreat.planet;

import be.swsb.coderetreat.positioning.Position;

public class OutOfBoundsException extends RuntimeException {

    public OutOfBoundsException(Position position) {
        super(String.format("Position %s is out of bounds",position.toString()));
    }
}
