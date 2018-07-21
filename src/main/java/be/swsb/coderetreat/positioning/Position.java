package be.swsb.coderetreat.positioning;

import java.util.Objects;

public class Position {

    private final int x;
    private final int y;

    private Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public static Position at(final int x, final int y) {
        return new Position(x, y);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", x, y);
    }

    public Position up(final int steps) {
        if (steps < 0) {
            throw new IllegalArgumentException("steps should not be negative");
        }
        return at(x, y + steps);
    }

    public Position down(final int steps) {
        if (steps < 0) {
            throw new IllegalArgumentException("steps should not be negative");
        }
        return at(x, y - steps);
    }
}
