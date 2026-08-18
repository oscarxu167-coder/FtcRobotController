package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class GamepadPractice_Test extends OpMode {

    RobotLocationPractice robotlocation = new RobotLocationPractice(0);

    @Override
    public void init() {
        robotlocation.setAngle(0);
    }

    @Override
    public void loop() {
        if(gamepad1.a){
            robotlocation.turnRobot(0.1);
        }
        else if(gamepad1.b){
            robotlocation.turnRobot(-0.1);
        }

        telemetry.addData("Heading", robotlocation.getHeading());
    }
}


