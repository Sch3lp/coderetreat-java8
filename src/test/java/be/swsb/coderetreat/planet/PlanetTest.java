package be.swsb.coderetreat.planet;

import org.junit.jupiter.api.Test;

import static be.swsb.coderetreat.positioning.Position.at;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlanetTest {

    @Test
    void cannotConstructWithPositiveLowerEdges() {
        assertThatThrownBy(() -> new Moon(4, 4, 1, -4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Lower edges must be negative");

        assertThatThrownBy(() -> new Moon(4, 4, -4, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Lower edges must be negative");
    }

    @Test
    void cannotConstructWithNegativeUpperEdges() {
        assertThatThrownBy(() -> new Moon(-4, 4, -1, -4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Upper edges must be positive");

        assertThatThrownBy(() -> new Moon(4, -4, -4, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Upper edges must be positive");
    }

    @Test
    void cannotConstructWith0Values() {
        assertThatThrownBy(() -> new Moon(0, 4, -1, -4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("edges cannot be 0");
        assertThatThrownBy(() -> new Moon(4, 0, -1, -4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("edges cannot be 0");
        assertThatThrownBy(() -> new Moon(4, 4, 0, -4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("edges cannot be 0");
        assertThatThrownBy(() -> new Moon(4, 4, -1, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("edges cannot be 0");


    }

    @Test
    void isEdge_APositionIsOnAnEdgeWhenTheXOrYCoordinatesMatchWithAnEdge() {
        final Moon moon = new Moon(4,4,-4,-4);

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

        Moon(final int upperXEdge, final int upperYEdge, final int lowerXEdge, final int lowerYEdge)  {
            super(upperXEdge, upperYEdge, lowerXEdge, lowerYEdge);
        }
    }
}