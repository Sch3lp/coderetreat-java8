package be.swsb.coderetreat.rover;

import java.util.Arrays;

enum Direction {
    NORTH(1),
    EAST(2),
    SOUTH(3),
    WEST(4);

    private final int internalNumber;

    Direction(final int internalNumber) {
        this.internalNumber = internalNumber;
    }

    public Direction nextClockwise() {
        final int next = this.internalNumber + 1;
        final int nextNumber = (next <= 4) ? next : next % 4;
        return from(nextNumber);
    }

    public Direction nextCounterClockwise() {
        final int previous = this.internalNumber - 1;
        final int previousNumber = (previous > 0) ? previous : 4;
        return from(previousNumber);
    }

    private Direction from(final int internalNumber) {
        return Arrays.stream(Direction.values())
                .filter(d -> d.internalNumber == internalNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("internal number can only be [1-4], but was %s", internalNumber)));
    }
}
