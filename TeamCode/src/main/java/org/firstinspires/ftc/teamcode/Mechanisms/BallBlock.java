package org.firstinspires.ftc.teamcode.Mechanisms;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextServo;
import dev.nextftc.robot.Mechanism;

public class BallBlock implements Mechanism {
    NextServo ballStop = new NextServo(RobotController.controlHub(),0);

    public enum BlockState {
        BALL_NO,
        BALL_GO
    }

    public static BlockState mode = BlockState.BALL_NO;

    public static double OPEN_POSITION = 0.5;

    public static double CLOSE_POSITION = 0;

    @Override
    public void periodic(){
        switch (mode) {
            case BALL_NO:
                ballStop.setPosition(CLOSE_POSITION);
                break;

            case BALL_GO:
                ballStop.setPosition(OPEN_POSITION);
                break;
        }

    }


}
