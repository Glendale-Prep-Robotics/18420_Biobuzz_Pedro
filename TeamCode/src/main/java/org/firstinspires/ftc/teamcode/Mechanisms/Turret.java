package org.firstinspires.ftc.teamcode.Mechanisms;

import com.pedropathing.math.Pose;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.hardware.actuators.NextServo;
import dev.nextftc.robot.Mechanism;
public class Turret implements Mechanism {
    public enum TurretTracking{
        ON, OFF
    }
    public static TurretTracking mode = TurretTracking.OFF;

    public static double turretAngle;
    public static double noAngle = 0;
    public static double trackingAngle;

    public final Pose redAudienceGoal = new Pose(58,60);
    public final Pose redRefereeGoal = new Pose(58,75);
    public final Pose blueRefereeGoal = new Pose(85,75);
    public final Pose blueAudienceGoal = new Pose(85,60);

    NextServo turretServo1 = new NextServo("ts1", 0.01, NextMotor.Direction.REVERSE);
    NextServo turretServo2 = new NextServo("ts2", 0.01, NextMotor.Direction.FORWARD);

    @Override
    public void periodic(){
        switch (mode){
            case ON:
                turretAngle = trackingAngle;
                break;

            case OFF:
                turretAngle = noAngle;
                break;

        }

        turretServo1.setPosition(turretAngle);
        turretServo2.setPosition(turretAngle);
    }

    public void getTurretAngle(Pose robotPose, boolean redAllience){
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
        double angle = Math.atan2(yVal,xVal);

        double trueAngle = robotHeading + angle;



    }
}
