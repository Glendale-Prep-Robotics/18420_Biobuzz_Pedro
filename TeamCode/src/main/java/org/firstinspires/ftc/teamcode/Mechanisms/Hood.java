package org.firstinspires.ftc.teamcode.Mechanisms;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.hardware.actuators.NextServo;
import dev.nextftc.robot.Mechanism;

public class Hood implements Mechanism {
    NextServo hoodServo1 = new NextServo(RobotController.controlHub(), 1, 0.01, NextMotor.Direction.FORWARD);
    NextServo hoodServo2 = new NextServo(RobotController.controlHub(), 3, 0.01, NextMotor.Direction.REVERSE);

    public static double openHoodPosition = 0.2;
    public static double closeHoodPosition = 0;
    public enum HoodState {
        SHOOT, CLOSE
    }
    public static HoodState mode = HoodState.CLOSE;
    @Override
    public void periodic(){
        switch (mode){
            case SHOOT:
                hoodServo1.setPosition(openHoodPosition);
                hoodServo2.setPosition(openHoodPosition);
                break;

            case CLOSE:
                hoodServo1.setPosition(closeHoodPosition);
                hoodServo1.setPosition(closeHoodPosition);
                break;
        }


    }
}
