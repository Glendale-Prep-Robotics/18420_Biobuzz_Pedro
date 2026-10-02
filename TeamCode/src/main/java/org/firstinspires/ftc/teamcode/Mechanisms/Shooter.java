package org.firstinspires.ftc.teamcode.Mechanisms;

import static dev.nextftc.units.Units.DegreesPerSecond;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

public class Shooter implements Mechanism {
    public double motorVelo = 30;
    public double KP = 0;
    public double KI = 0;
    public double KD = 0;
    //F then P then D.


    NextMotor shooterMotor2 = new NextMotor("sm2");
    NextMotor shooterMotor1 = new NextMotor("sm1");
    /// fix port and Positions

    public enum ShooterMode{
        ON, OFF
    }

    public static ShooterMode mode =ShooterMode.OFF;

    @Override
    public void periodic(){

        shooterMotor2.follow(shooterMotor1);
        shooterMotor2.setZeroPowerBehavior(NextMotor.ZeroPowerBehavior.FLOAT);
        shooterMotor1.setZeroPowerBehavior(NextMotor.ZeroPowerBehavior.FLOAT);

        switch (mode){
            case OFF:
                shooterMotor1.setVelocitySetpoint(DegreesPerSecond.of(0));
                break;

            case ON:
                shooterMotor1.getVelocityConstants()
                        .withP(KP)
                        .withI(KI)
                        .withD(KD);
                shooterMotor1.setVelocitySetpoint(DegreesPerSecond.of(motorVelo));
                break;
        }

    }


}
