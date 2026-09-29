package org.firstinspires.ftc.teamcode.Teleop;

import org.firstinspires.ftc.teamcode.Subsytems.BallBlock;
import org.firstinspires.ftc.teamcode.Subsytems.Hood;
import org.firstinspires.ftc.teamcode.Subsytems.Intake;
import org.firstinspires.ftc.teamcode.Subsytems.Shooter;
import org.firstinspires.ftc.teamcode.Subsytems.Turret;

import java.util.Set;

import dev.nextftc.robot.Mechanism;

public class NextRobot implements dev.nextftc.robot.NextRobot {
    Shooter shooter = new Shooter();
    Turret turret = new Turret();

    Intake intake = new Intake();

    Hood hood = new Hood();

    BallBlock ballBlock = new BallBlock();

    @Override
    public Set<Mechanism> getMechanisms() {
        return Set.of(shooter, turret, intake, hood, ballBlock);
    }
}
