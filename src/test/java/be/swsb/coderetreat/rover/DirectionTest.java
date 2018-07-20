package be.swsb.coderetreat.rover;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    void nextClockwise_ReturnsNextDirection() {
        assertThat(Direction.NORTH.clockwise()).isEqualTo(Direction.EAST);
        assertThat(Direction.EAST.clockwise()).isEqualTo(Direction.SOUTH);
        assertThat(Direction.SOUTH.clockwise()).isEqualTo(Direction.WEST);
        assertThat(Direction.WEST.clockwise()).isEqualTo(Direction.NORTH);
    }

    @Test
    void nextCounterClockwise_ReturnsPreviousDirection() {
        assertThat(Direction.NORTH.counterClockwise()).isEqualTo(Direction.WEST);
        assertThat(Direction.EAST.counterClockwise()).isEqualTo(Direction.NORTH);
        assertThat(Direction.SOUTH.counterClockwise()).isEqualTo(Direction.EAST);
        assertThat(Direction.WEST.counterClockwise()).isEqualTo(Direction.SOUTH);
    }
}