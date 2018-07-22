package be.swsb.coderetreat.planet;

import be.swsb.coderetreat.positioning.Position;

import java.util.Objects;
import java.util.stream.Stream;

public abstract class Planet {

    private final int upperXEdge;
    private final int lowerXEdge;
    private final int upperYEdge;
    private final int lowerYEdge;
    private final String name;

    Planet(final int upperXEdge, final int upperYEdge, final int lowerXEdge, final int lowerYEdge, final String name) {
        validateEdges(upperXEdge, upperYEdge, lowerXEdge, lowerYEdge);
        this.upperXEdge = upperXEdge;
        this.upperYEdge = upperYEdge;
        this.lowerXEdge = lowerXEdge;
        this.lowerYEdge = lowerYEdge;
        this.name = name;
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

    public Position wrap(final Position position) {
        if (position.xLargerThan(upperXEdge)) {
            return position.withX(lowerXEdge);
        }
        if (position.xSmallerThan(lowerXEdge)) {
            return position.withX(upperXEdge);
        }
        if (position.yLargerThan(upperYEdge)) {
            return position.withY(lowerYEdge);
        }
        if (position.ySmallerThan(lowerYEdge)) {
            return position.withY(upperYEdge);
        }
        return position;
    }

    public static class Mars extends Planet {
        private Mars() {
            super(7, 7, -7, -7, "Mars");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Planet planet = (Planet) o;
        return upperXEdge == planet.upperXEdge &&
                lowerXEdge == planet.lowerXEdge &&
                upperYEdge == planet.upperYEdge &&
                lowerYEdge == planet.lowerYEdge &&
                Objects.equals(name, planet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(upperXEdge, lowerXEdge, upperYEdge, lowerYEdge, name);
    }

    @Override
    public String toString() {
        return String.format("Planet %s from (%s,%s) to (%s,%s)", name, upperXEdge, upperYEdge, lowerXEdge, lowerYEdge);
    }
}
