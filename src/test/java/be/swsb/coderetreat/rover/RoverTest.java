package be.swsb.coderetreat.rover;

import org.junit.jupiter.api.Test;

import static be.swsb.coderetreat.positioning.Position.at;
import static org.assertj.core.api.Assertions.assertThat;

class RoverTest {

    @Test
    void constructor_ShouldCreateARoverFacingNorth() {
        final Rover rover = new Rover();
        assertThat(rover.faceDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    void constructor_ShouldCreateARoverAtPosition00() {
        final Rover rover = new Rover();
        assertThat(rover.currentPosition()).isEqualTo(at(0,0));
    }
}

