package be.swsb.coderetreat.positioning;

import org.junit.jupiter.api.Test;

import static be.swsb.coderetreat.positioning.Position.at;
import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void positionIsImmutable() {
        final Position position1 = at(100, 300);
        final Position position2 = at(100, 300);

        assertThat(position1).isEqualTo(position2);
    }

    @Test
    void toString_ReturnsXandYCoordinates() {
        assertThat(at(-4, 12).toString()).isEqualTo("(-4,12)");
    }
}