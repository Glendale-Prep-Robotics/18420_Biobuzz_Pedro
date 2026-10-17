package org.firstinspires.ftc.teamcode.Mechanisms;


import static org.firstinspires.ftc.teamcode.Mechanisms.Constants.DOWN_POSITION;

import com.acmerobotics.dashboard.config.Config;
import com.bylazar.configurables.annotations.Configurable;

import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.hardware.actuators.NextServo;
import dev.nextftc.robot.Mechanism;

@Configurable
public class Arm implements Mechanism {

    NextServo flowerArm = new NextServo("pa");

    //public static double DOWN_POSITION = 0.25;

    public enum FlowerPiviotState{
        DOWN,UP,INIT
    }

    public static double val;

    public static FlowerPiviotState mode = FlowerPiviotState.INIT;

    public static double testVariable = 0.25;
    @Override
    public void periodic(){


        switch (mode){
            case INIT:
                break;

            case DOWN:
                val = DOWN_POSITION;
                break;

            case UP:
                val = 0;
                break;
        }

        flowerArm.setDirection(NextMotor.Direction.REVERSE);
        flowerArm.setPosition(val);

    }
}
