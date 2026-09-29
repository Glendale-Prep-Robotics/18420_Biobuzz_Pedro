package org.firstinspires.ftc.teamcode.Mechanisms;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

public class Intake implements Mechanism {


    NextMotor intakeMotor1 = new NextMotor(RobotController.controlHub(), 3);
    NextMotor intakeMotor2 = new NextMotor(RobotController.controlHub(), 4);

    public static double intakeThrottle = 1;

    public enum IntakeMode{
        ON, OFF
    }

    public static IntakeMode mode = IntakeMode.OFF;

    @Override
    public void periodic(){

        intakeMotor2.follow(intakeMotor1, NextMotor.Direction.REVERSE);
        switch (mode){
            case OFF:
                intakeMotor1.setThrottle(0);
                break;

            case ON:
                intakeMotor1.setThrottle(intakeThrottle);
                break;
        }







    }

}
