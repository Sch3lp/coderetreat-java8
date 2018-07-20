package be.swsb.coderetreat.rover;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    void nextClockwise_ReturnsNextDirection() {
        assertThat(Direction.NORTH.nextClockwise()).isEqualTo(Direction.EAST);
        assertThat(Direction.EAST.nextClockwise()).isEqualTo(Direction.SOUTH);
        assertThat(Direction.SOUTH.nextClockwise()).isEqualTo(Direction.WEST);
        assertThat(Direction.WEST.nextClockwise()).isEqualTo(Direction.NORTH);
    }

    @Test
    void nextCounterClockwise_ReturnsPreviousDirection() {
        assertThat(Direction.NORTH.nextCounterClockwise()).isEqualTo(Direction.WEST);
        assertThat(Direction.EAST.nextCounterClockwise()).isEqualTo(Direction.NORTH);
        assertThat(Direction.SOUTH.nextCounterClockwise()).isEqualTo(Direction.EAST);
        assertThat(Direction.WEST.nextCounterClockwise()).isEqualTo(Direction.SOUTH);
    }
}