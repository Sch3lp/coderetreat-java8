package be.swsb.coderetreat.rover;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static be.swsb.coderetreat.positioning.Position.at;
import static be.swsb.coderetreat.rover.Command.*;
import static be.swsb.coderetreat.rover.Direction.*;
import static be.swsb.coderetreat.rover.RoverTestBuilder.aRover;
import static be.swsb.coderetreat.rover.RoverTestBuilder.defaultRover;
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
    void handle_GivenFacingNorth_WithInputLeft_ShouldFaceWest() {
        final Rover defaultRover = new Rover();

        defaultRover.handle(LEFT);

        assertThat(defaultRover.faceDirection()).isEqualTo(WEST);
    }

    @Test
    void handle_GivenFacingWest_WithInputLeft_ShouldFaceSouth() {
        final Rover rover = aRover().facing(WEST).at(0,0).build();

        rover.handle(LEFT);

        assertThat(rover.faceDirection()).isEqualTo(SOUTH);
    }

    @Test
    void handle_GivenFacingSouth_WithInputLeft_ShouldFaceEast() {
        final Rover rover = aRover().facing(SOUTH).at(0,0).build();

        rover.handle(LEFT);

        assertThat(rover.faceDirection()).isEqualTo(EAST);
    }

    @Test
    void handle_GivenFacingEast_WithInputLeft_ShouldFaceNorth() {
        final Rover rover = aRover().facing(EAST).at(0,0).build();

        rover.handle(LEFT);

        assertThat(rover.faceDirection()).isEqualTo(NORTH);
    }

    @Test
    void handle_GivenFacingNorth_WithInputRight_ShouldFaceEast() {
        final Rover defaultRover = new Rover();

        defaultRover.handle(RIGHT);

        assertThat(defaultRover.faceDirection()).isEqualTo(EAST);
    }

    @Test
    void handle_GivenFacingWest_WithInputRight_ShouldFaceNorth() {
        final Rover rover = aRover().facing(WEST).at(0,0).build();

        rover.handle(RIGHT);

        assertThat(rover.faceDirection()).isEqualTo(NORTH);
    }

    @Test
    void handle_GivenFacingSouth_WithInputRight_ShouldFaceWest() {
        final Rover rover = aRover().facing(SOUTH).at(0,0).build();

        rover.handle(RIGHT);

        assertThat(rover.faceDirection()).isEqualTo(WEST);
    }

    @Test
    void handle_GivenFacingEast_WithInputRight_ShouldFaceSouth() {
        final Rover rover = aRover().facing(EAST).at(0,0).build();

        rover.handle(RIGHT);

        assertThat(rover.faceDirection()).isEqualTo(SOUTH);
    }

    @Test
    void handle_GivenFacingNorth_WithInputForward_ShouldMoveUpTheYAxis() {
        final Rover rover = defaultRover();

        rover.handle(FORWARD);

        assertThat(rover.currentPosition()).isEqualTo(at(0, 1));
    }

    @Test
    void handle_GivenFacingSouth_WithInputForward_ShouldMoveDownTheYAxis() {
        final Rover rover = aRover().facing(SOUTH).at(0,0).build();

        rover.handle(FORWARD);

        assertThat(rover.currentPosition()).isEqualTo(at(0, -1));
    }

    @Test
    void handle_GivenFacingEast_WithInputForward_ShouldMoveUpTheXAxis() {
        final Rover rover = aRover().facing(EAST).at(0,0).build();

        rover.handle(FORWARD);

        assertThat(rover.currentPosition()).isEqualTo(at(1, 0));
    }

    @Test
    void handle_GivenFacingWest_WithInputForward_ShouldMoveDownTheXAxis() {
        final Rover rover = aRover().facing(WEST).at(0,0).build();

        rover.handle(FORWARD);

        assertThat(rover.currentPosition()).isEqualTo(at(-1, 0));
    }

    @Test
    void handle_GivenFacingNorth_WithInputBackward_ShouldMoveDownTheYAxis() {
        final Rover rover = defaultRover();

        rover.handle(BACKWARD);

        assertThat(rover.currentPosition()).isEqualTo(at(0, -1));
    }

    @Test
    void handle_GivenFacingSouth_WithInputBackward_ShouldMoveUpTheYAxis() {
        final Rover rover = aRover().facing(SOUTH).at(0,0).build();

        rover.handle(BACKWARD);

        assertThat(rover.currentPosition()).isEqualTo(at(0, 1));
    }

    @Test
    void handle_GivenFacingEast_WithInputBackward_ShouldMoveDownTheXAxis() {
        final Rover rover = aRover().facing(EAST).at(0,0).build();

        rover.handle(BACKWARD);

        assertThat(rover.currentPosition()).isEqualTo(at(-1, 0));
    }

    @Test
    void handle_GivenFacingWest_WithInputBackward_ShouldMoveUpTheXAxis() {
        final Rover rover = aRover().facing(WEST).at(0,0).build();

        rover.handle(BACKWARD);

        assertThat(rover.currentPosition()).isEqualTo(at(1, 0));
    }

    @Test
    void handleCommands_CanHandleASeriesOfCommands() {
        Rover rover = defaultRover();

        rover.handleCommands(Arrays.asList(FORWARD,RIGHT,FORWARD,FORWARD,RIGHT,BACKWARD));

        assertThat(rover.currentPosition()).isEqualTo(at(2, 2));
        assertThat(rover.faceDirection()).isEqualTo(SOUTH);
    }
}

