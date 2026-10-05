package org.firstinspires.ftc.teamcode.Mechanisms;

import static org.firstinspires.ftc.teamcode.Mechanisms.GoalPose.blueAudienceGoal;
import static org.firstinspires.ftc.teamcode.Mechanisms.GoalPose.blueRefereeGoal;
import static org.firstinspires.ftc.teamcode.Mechanisms.GoalPose.redAudienceGoal;
import static org.firstinspires.ftc.teamcode.Mechanisms.GoalPose.redRefereeGoal;
import static dev.nextftc.units.Units.DegreesPerSecond;

import com.pedropathing.math.Pose;

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

    public static double val;

    @Override
    public void periodic(){

        shooterMotor2.follow(shooterMotor1);
        shooterMotor2.setZeroPowerBehavior(NextMotor.ZeroPowerBehavior.FLOAT);
        shooterMotor1.setZeroPowerBehavior(NextMotor.ZeroPowerBehavior.FLOAT);

        switch (mode){
            case OFF:
                val = 0;
                break;

            case ON:
                val = motorVelo;
                break;
        }

        shooterMotor1.getVelocityConstants()
                .withP(KP)
                .withI(KI)
                .withD(KD);
        shooterMotor1.setVelocitySetpoint(DegreesPerSecond.of(motorVelo));

    }

    public void refreshShooterVelo(Pose robotPose, boolean redAllience){
        double robotX = robotPose.x();
        double robotY = robotPose.y();
        double robotHeading = robotPose.heading();
        Pose goalPose;
        if(redAllience){
            if(robotY > 70){
                goalPose = redRefereeGoal;
            }
            else{
                goalPose = redAudienceGoal;
            }
        }
        else{
            if(robotY > 70){
                goalPose = blueRefereeGoal;
            }
            else{
                goalPose = blueAudienceGoal;
            }
        }
        double goalX = goalPose.x();
        double goalY = goalPose.y();

        double xVal = goalX - robotX;
        double yVal = goalY - robotY;

        double distance = Math.sqrt((xVal*xVal)+(yVal*yVal));

        double velo = distance;//write function here

        motorVelo = velo;
    }


}
