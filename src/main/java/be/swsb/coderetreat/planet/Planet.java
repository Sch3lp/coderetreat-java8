package be.swsb.coderetreat.planet;

import be.swsb.coderetreat.positioning.Position;

import java.util.stream.Stream;

public abstract class Planet {

    private final int upperXEdge;
    private final int lowerXEdge;
    private final int upperYEdge;
    private final int lowerYEdge;

    Planet(final int upperXEdge, final int upperYEdge, final int lowerXEdge, final int lowerYEdge) {
        validateEdges(upperXEdge, upperYEdge, lowerXEdge, lowerYEdge);
        this.upperXEdge = upperXEdge;
        this.upperYEdge = upperYEdge;
        this.lowerXEdge = lowerXEdge;
        this.lowerYEdge = lowerYEdge;
    }

    private void validateEdges(final int upperXEdge, final int upperYEdge, final int lowerXEdge, final int lowerYEdge) {
        if (upperXEdge == 0 || upperYEdge == 0 || lowerXEdge == 0 || lowerYEdge == 0) {
            throw new IllegalArgumentException("edges cannot be 0");
        }
        if (upperXEdge < 0 || upperYEdge < 0) {
            throw new IllegalArgumentException("Upper edges must be positive");
        }
        if (lowerXEdge > 0 || lowerYEdge > 0) {
            throw new IllegalArgumentException("Lower edges must be negative");
        }
    }

    public boolean isEdge(final Position position) {
        return Stream.of(upperXEdge, lowerXEdge).anyMatch(position::hasForX) ||
                Stream.of(upperYEdge, lowerYEdge).anyMatch(position::hasForY);
    }

    public static Mars mars() {
        return new Mars();
    }

    public static class Mars extends Planet {
        private Mars() {
            super(7, 7, -7, -7);
        }
    }
}
