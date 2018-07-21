package be.swsb.coderetreat.positioning;

import org.junit.jupiter.api.Test;

import static be.swsb.coderetreat.positioning.Position.at;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void up_MovesUpTheYAxisGivenAmountOfSteps() {
        final Position position = at(0, 0);

        assertThat(position.up(1)).isEqualTo(at(0, 1));
    }

    @Test
    void up_WithSteps0_DoesNotMove() {
        final Position position = at(0, 0);

        assertThat(position.up(0)).isEqualTo(at(0, 0));
    }

    @Test
    void up_CannotTakeNegativeNumbers() {
        final Position position = at(0, 0);

        assertThatThrownBy(() -> position.up(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("steps should not be negative");
    }

    @Test
    void down_MovesDownTheYAxisGivenAmountOfSteps() {
        final Position position = at(0, 0);

        assertThat(position.down(1)).isEqualTo(at(0, -1));
    }

    @Test
    void down_WithSteps0_DoesNotMove() {
        final Position position = at(0, 0);

        assertThat(position.down(0)).isEqualTo(at(0, 0));
    }

    @Test
    void down_CannotTakeNegativeNumbers() {
        final Position position = at(0, 0);

        assertThatThrownBy(() -> position.down(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("steps should not be negative");
    }
}