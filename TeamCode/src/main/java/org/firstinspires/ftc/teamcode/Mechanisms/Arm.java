package org.firstinspires.ftc.teamcode.Mechanisms;

import static org.firstinspires.ftc.teamcode.Mechanisms.Constants.DOWN_POSITION;

import com.acmerobotics.dashboard.config.Config;

import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.hardware.actuators.NextServo;
import dev.nextftc.robot.Mechanism;

@Config
public class Arm implements Mechanism {

    NextServo flowerArm = new NextServo("pa");

    public enum FlowerPiviotState{
        DOWN,UP,INIT
    }

    double val;
    //public static double DOWN_POSITION = 1;

    public static FlowerPiviotState mode = FlowerPiviotState.INIT;
    @Override
    public void periodic(){


        switch (mode){
            case INIT:
                break;

            case DOWN:
                val = DOWN_POSITION;
                break;

            case UP:
                val = .8;
                break;
        }

        flowerArm.setDirection(NextMotor.Direction.REVERSE);
        flowerArm.setPosition(val);
    }
}
