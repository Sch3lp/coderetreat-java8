package be.swsb.coderetreat.rover;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoverTest {

    @Test
    void constructor_ShouldCreateARoverFacingNorth() {
        final Rover rover = new Rover();
        assertThat(rover.faceDirection()).isEqualTo(Direction.NORTH);
    }
}

