package be.swsb.coderetreat.planet;

import be.swsb.coderetreat.positioning.Position;
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

    @Test
    void wrap_WhenGivenPositionIsOverRightEdge_ReturnLeftEdge() {
        final Position overRightEdge = at(8, 4);
        final Position leftEdge = at(-7, 4);

        final Position actual = Planet.mars().wrap(overRightEdge);

        assertThat(actual).isEqualTo(leftEdge);
    }

    @Test
    void wrap_WhenGivenPositionIsOverLeftEdge_ReturnRightEdge() {
        final Position overLeftEdge = at(-8, 4);
        final Position rightEdge = at(7, 4);

        final Position actual = Planet.mars().wrap(overLeftEdge);

        assertThat(actual).isEqualTo(rightEdge);
    }

    @Test
    void wrap_WhenGivenPositionIsOverTopEdge_ReturnBottomEdge() {
        final Position overTopEdge = at(4, 8);
        final Position bottomEdge = at(4, -7);

        final Position actual = Planet.mars().wrap(overTopEdge);

        assertThat(actual).isEqualTo(bottomEdge);
    }

    @Test
    void wrap_WhenGivenPositionIsOverBottomEdge_ReturnTopEdge() {
        final Position overBottomEdge = at(4, -8);
        final Position topEdge = at(4, 7);

        final Position actual = Planet.mars().wrap(overBottomEdge);

        assertThat(actual).isEqualTo(topEdge);
    }
    
    @Test
    void wrap_WhenGivenPositionIsOnEdge_ReturnPosition() {
        final Position onRightEdge = at(7, 4);
        final Position onLeftEdge = at(-7, 4);
        final Position onTopEdge = at(4, 7);
        final Position onBottomEdge = at(4, -7);

        assertThat(Planet.mars().wrap(onRightEdge)).isEqualTo(onRightEdge);
        assertThat(Planet.mars().wrap(onLeftEdge)).isEqualTo(onLeftEdge);
        assertThat(Planet.mars().wrap(onTopEdge)).isEqualTo(onTopEdge);
        assertThat(Planet.mars().wrap(onBottomEdge)).isEqualTo(onBottomEdge);
    }

    @Test
    void wrap_WhenGivenPositionIsNotOnEdge_ReturnPosition() {
        final Position noEdge = at(1, 4);

        final Position actual = Planet.mars().wrap(noEdge);

        assertThat(actual).isEqualTo(noEdge);
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