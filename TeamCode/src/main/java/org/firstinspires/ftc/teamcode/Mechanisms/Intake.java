package org.firstinspires.ftc.teamcode.Mechanisms;

import java.security.PublicKey;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

public class Intake implements Mechanism {


    NextMotor intakeMotor1 = new NextMotor("im1");

    public static double intakeThrottle = 1;

    public static double val;

    public static double val2;

    public enum IntakeMode{
        ON, OFF, INIT
    }

    public enum Intake2Mode{
        ON,OFF,INIT
    }

    public static IntakeMode mode = IntakeMode.INIT;

    public static Intake2Mode mode2 = Intake2Mode.INIT;

    @Override
    public void periodic(){
        switch (mode) {
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
