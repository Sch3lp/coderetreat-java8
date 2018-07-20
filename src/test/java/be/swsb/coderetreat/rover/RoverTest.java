package be.swsb.coderetreat.rover;

import org.junit.jupiter.api.Test;

import static be.swsb.coderetreat.positioning.Position.at;
import static be.swsb.coderetreat.rover.Direction.NORTH;
import static be.swsb.coderetreat.rover.Direction.WEST;
import static org.assertj.core.api.Assertions.assertThat;

class RoverTest {

    @Test
    void constructor_ShouldCreateARoverFacingNorth() {
        final Rover rover = new Rover();
        assertThat(rover.faceDirection()).isEqualTo(NORTH);
    }

    @Test
    void constructor_ShouldCreateARoverAtPosition00() {
        final Rover rover = new Rover();
        assertThat(rover.currentPosition()).isEqualTo(at(0,0));
    }

    @Test
    void applyCommand_GivenFacingNorth_WithInputLeft_ShouldFaceWest() {
        final Rover rover = new Rover();

        rover.applyCommand(Command.LEFT);

        assertThat(rover.faceDirection()).isEqualTo(WEST);
    }
}

