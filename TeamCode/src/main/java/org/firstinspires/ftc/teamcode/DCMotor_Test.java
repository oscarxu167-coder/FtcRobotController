package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.Motor;
@TeleOp
public class DCMotor_Test extends OpMode {
    Motor motors = new Motor();
    @Override
    public void init() {
       motors.init(hardwareMap);

    }

    @Override
    public void loop() {
        motors.setMotorspeed(0.5);
        telemetry.addData("Motor Revs", motors.getMotorRevs());
        telemetry.addData("motor type", motors.getmotortype());
    }
}
