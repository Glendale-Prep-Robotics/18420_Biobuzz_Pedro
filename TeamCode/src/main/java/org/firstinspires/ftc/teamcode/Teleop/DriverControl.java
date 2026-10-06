package org.firstinspires.ftc.teamcode.Teleop;


import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Mechanisms.Arm;
import org.firstinspires.ftc.teamcode.Mechanisms.Feeder;
import org.firstinspires.ftc.teamcode.Mechanisms.Intake;
import org.firstinspires.ftc.teamcode.Mechanisms.Turret;
import org.firstinspires.ftc.teamcode.pedro.Constants;

import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.drive.DriveCommands;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;

@Config
@NextTeleop(name = "DriverControl")
public class DriverControl extends NextOpMode {
    private final NextRobot robot;

    public DriverControl(NextRobot robot) {
        super(robot);
        this.robot = robot;
    }

    CommandGamepad gp1 = new CommandGamepad(gamepad1);
    CommandGamepad gp2 = new CommandGamepad(gamepad2);

    public boolean armDown = false;


    @Override
    public void disabledPeriodic() {

    }

    @Override
    public void start(){
        Telemetry.addBackend(FtcDashboard.getInstance().getTelemetry());
        robot.drive.startDrive(gamepad1);
    }
    @Override
    public void periodic() {

        if(gamepad1.aWasPressed()){
            armDown =!armDown;
        }

        if(armDown){
            Arm.mode = Arm.FlowerPiviotState.DOWN;
        }
        else {
            Arm.mode = Arm.FlowerPiviotState.UP;
        }
       if(gamepad1.right_bumper){
           Intake.mode = Intake.IntakeMode.ON;
           Feeder.mode = Feeder.FeederMode.ON;
       }

       else{
           Intake.mode = Intake.IntakeMode.OFF;
           Feeder.mode = Feeder.FeederMode.OFF;
       }


       Telemetry.log("arm toggle", armDown);
       Telemetry.log("arm State", Arm.mode);
       Telemetry.update();


    }

    @Override
    public void end(){

    }
}
