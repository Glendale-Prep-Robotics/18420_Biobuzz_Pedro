package org.firstinspires.ftc.teamcode.Mechanisms;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

public class Intake implements Mechanism {


    NextMotor intakeMotor1 = new NextMotor("im1");
    NextMotor intakeMotor2 = new NextMotor("im2");

    public static double intakeThrottle = 1;

    public static double val;

    public enum IntakeMode{
        ON, OFF, INIT
    }

    public static IntakeMode mode = IntakeMode.INIT;

    @Override
    public void periodic(){

        intakeMotor2.follow(intakeMotor1, NextMotor.Direction.REVERSE);
        switch (mode){
            case OFF:
                val = 0;
                break;

            case ON:
                val = intakeThrottle;
                break;

            case INIT:
                break;
        }

        intakeMotor1.setThrottle(val);







    }

}
