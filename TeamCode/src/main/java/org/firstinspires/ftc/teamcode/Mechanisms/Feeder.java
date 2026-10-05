package org.firstinspires.ftc.teamcode.Mechanisms;

import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

public class Feeder implements Mechanism {

    NextMotor FeederMotor = new NextMotor("fm");

    public enum FeederMode{
        ON,OFF,INIT

    }

    public static FeederMode mode = FeederMode.INIT;

    public static double val2;

    @Override
    public void periodic(){
        switch (mode){
            case INIT:
                break;

            case ON:
                val2 = 1;
                break;

            case OFF:
                val2 = 0;
                break;
        }


        FeederMotor.setDirection(NextMotor.Direction.FORWARD);
        FeederMotor.setThrottle(val2);
    }
}
