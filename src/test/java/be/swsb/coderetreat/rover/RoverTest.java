package be.swsb.coderetreat.rover;

import org.junit.jupiter.api.Test;

import static be.swsb.coderetreat.positioning.Position.at;
import static be.swsb.coderetreat.rover.Direction.NORTH;
import static be.swsb.coderetreat.rover.Direction.SOUTH;
import static be.swsb.coderetreat.rover.Direction.WEST;
import static be.swsb.coderetreat.rover.RoverTestBuilder.aRover;
import static org.assertj.core.api.Assertions.assertThat;

class RoverTest {

    @Test
    void constructor_ShouldCreateARoverFacingNorth() {
        final Rover defaultRover = new Rover();
        assertThat(defaultRover.faceDirection()).isEqualTo(NORTH);
    }

    @Test
    void constructor_ShouldCreateARoverAtPosition00() {
        final Rover defaultRover = new Rover();
        assertThat(defaultRover.currentPosition()).isEqualTo(at(0,0));
    }

    @Test
    void applyCommand_GivenFacingNorth_WithInputLeft_ShouldFaceWest() {
        final Rover defaultRover = new Rover();

        defaultRover.applyCommand(Command.LEFT);

        assertThat(defaultRover.faceDirection()).isEqualTo(WEST);
    }

    @Test
    void applyCommand_GivenFacingWest_WithInputLeft_ShouldFaceSouth() {
        final Rover rover = aRover().facing(WEST).at(0,0).build();

        rover.applyCommand(Command.LEFT);

        assertThat(rover.faceDirection()).isEqualTo(SOUTH);
    }
}

