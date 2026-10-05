package org.firstinspires.ftc.teamcode.Teleop;


import com.pedropathing.math.Pose;

import org.firstinspires.ftc.teamcode.Mechanisms.Feeder;
import org.firstinspires.ftc.teamcode.Mechanisms.Intake;

import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;

@NextTeleop(name = "DriverControl")
public class DriverControl extends NextOpMode {
    public DriverControl(NextRobot robot) {
        super(robot);
    }

    CommandGamepad gp1 = new CommandGamepad(gamepad1);
    CommandGamepad gp2 = new CommandGamepad(gamepad2);

    public boolean intakeOn = false;

    public boolean FeederOn = false;

    Pose startPose = new Pose(0,0,0);
//    private Follower follower;


    @Override
    public void disabledPeriodic() {
    }

    @Override
    public void start(){
//        follower = Constants.create(hardwareMap);


    }
    @Override
    public void periodic() {
//        follower.update();
//        follower.manual(
//                      -gamepad1.left_stick_y ,
//                      -gamepad1.left_stick_x,
//                      -gamepad1.right_stick_x
//          );//maybe this works?
        if(gamepad1.leftBumperWasPressed()){
            intakeOn = !intakeOn;
        }

        if(gamepad1.rightBumperWasPressed()){
            FeederOn = !FeederOn;
        }

        if(intakeOn){
            Intake.mode = Intake.IntakeMode.ON;
        }
        else {
            Intake.mode = Intake.IntakeMode.OFF;
        }

        if(FeederOn){
            Feeder.mode = Feeder.FeederMode.ON;
        }
        else {
            Feeder.mode = Feeder.FeederMode.OFF;
        }


    }

    @Override
    public void end(){

    }
}
