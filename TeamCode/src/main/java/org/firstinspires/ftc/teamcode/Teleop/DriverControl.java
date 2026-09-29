package org.firstinspires.ftc.teamcode.Teleop;


import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;

import org.firstinspires.ftc.teamcode.Subsytems.BallBlock;
import org.firstinspires.ftc.teamcode.pedro.Constants;

import dev.nextftc.robot.opmode.BulkReadHook;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;

@NextTeleop(name = "DriverControl")
public class DriverControl extends NextOpMode {
    public DriverControl(NextRobot robot) {
        super(robot, BulkReadHook.INSTANCE);
    }

    CommandGamepad gp1 = new CommandGamepad(gamepad1);
    CommandGamepad gp2 = new CommandGamepad(gamepad2);

    Pose startPose = new Pose(0,0,0);

    private Follower follower;

    @Override
    public void disabledPeriodic() {
    }

    @Override
    public void start(){
        follower = Constants.create(hardwareMap);
        if(follower != null){
            follower.startTeleopDrive();
        }

        BallBlock.mode = BallBlock.BlockState.BALL_NO;


    }
    @Override
    public void periodic() {
        follower.update();
        follower.setTeleOpMovementVectors(
                      -gamepad1.left_stick_y ,
                      -gamepad1.left_stick_x,
                      -gamepad1.right_stick_x
          );//maybe this works?
        if(gamepad1.a){
            BallBlock.mode = BallBlock.BlockState.BALL_GO;
        }
        else{
            BallBlock.mode = BallBlock.BlockState.BALL_NO;
        }


    }

    @Override
    public void end(){

    }
}
