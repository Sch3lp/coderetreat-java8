package be.swsb.coderetreat.positioning;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void positionIsImmutable() {
        final Position position1 = new Position(100, 300);
        final Position position2 = new Position(100, 300);

        assertThat(position1).isEqualTo(position2);
    }

    @Test
    void toString_ReturnsXandYCoordinates() {
        assertThat(new Position(-4, 12).toString()).isEqualTo("(-4,12)");
    }
}