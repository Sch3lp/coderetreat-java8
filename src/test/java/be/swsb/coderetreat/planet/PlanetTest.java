package be.swsb.coderetreat.planet;

import org.junit.jupiter.api.Test;

import static be.swsb.coderetreat.positioning.Position.at;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlanetTest {

    @Test
    void planetIsImmutable() {
        final Moon moon = moon(1, 1, -1, -1, "Earth's Moon");
        final Moon otherMoon = moon(1, 1, -1, -1, "Earth's Moon");

        assertThat(moon).isEqualTo(otherMoon);
    }

    @Test
    void toString_ReturnsNameAndEdgeCorners() {
        final Moon moon = moon(1, 1, -1, -1, "moon");
        assertThat(moon.toString()).isEqualTo(String.format("Planet moon from (1,1) to (-1,-1)"));
    }

    @Test
    void cannotConstructWithPositiveLowerEdges() {
        assertThatThrownBy(() -> moon(4, 4, 1, -4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Lower edges must be negative");

        assertThatThrownBy(() -> moon(4, 4, -4, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Lower edges must be negative");
    }

    @Test
    void cannotConstructWithNegativeUpperEdges() {
        assertThatThrownBy(() -> moon(-4, 4, -1, -4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Upper edges must be positive");

        assertThatThrownBy(() -> moon(4, -4, -4, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Upper edges must be positive");
    }

    @Test
    void cannotConstructWith0Values() {
        assertThatThrownBy(() -> moon(0, 4, -1, -4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("edges cannot be 0");
        assertThatThrownBy(() -> moon(4, 0, -1, -4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("edges cannot be 0");
        assertThatThrownBy(() -> moon(4, 4, 0, -4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("edges cannot be 0");
        assertThatThrownBy(() -> moon(4, 4, -1, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("edges cannot be 0");


    }

    @Test
    void isEdge_APositionIsOnAnEdgeWhenTheXOrYCoordinatesMatchWithAnEdge() {
        final Moon moon = moon(4,4,-4,-4);

        assertThat(moon.isEdge(at(4, 0))).isTrue();
        assertThat(moon.isEdge(at(-4, 0))).isTrue();
        assertThat(moon.isEdge(at(0, 4))).isTrue();
        assertThat(moon.isEdge(at(0, -4))).isTrue();

        assertThat(moon.isEdge(at(0, 0))).isFalse();
    }

    @Test
    void mars_HasEdgesAt7() {
        final Planet.Mars mars = Planet.mars();

        assertThat(mars.isEdge(at(7, 4))).isTrue();
        assertThat(mars.isEdge(at(4, 7))).isTrue();
        assertThat(mars.isEdge(at(-7, 1))).isTrue();
        assertThat(mars.isEdge(at(6, -7))).isTrue();
    }

    private static class Moon extends Planet {
        Moon(final int upperXEdge, final int upperYEdge, final int lowerXEdge, final int lowerYEdge, String name)  {
            super(upperXEdge, upperYEdge, lowerXEdge, lowerYEdge, name);
        }
    }

    private Moon moon(final int upperXEdge, final int upperYEdge, final int lowerXEdge, final int lowerYEdge, final String name) {
        return new Moon(upperXEdge, upperYEdge, lowerXEdge, lowerYEdge, name);
    }

    private Moon moon(final int upperXEdge, final int upperYEdge, final int lowerXEdge, final int lowerYEdge) {
        return new Moon(upperXEdge, upperYEdge, lowerXEdge, lowerYEdge, "moon");
    }
}