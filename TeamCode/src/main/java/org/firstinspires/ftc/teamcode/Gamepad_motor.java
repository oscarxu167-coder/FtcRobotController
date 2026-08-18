package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Gamepad Drive", group = "TeleOp")
public class Gamepad_motor extends OpMode {

    // Declare the 4 motors
    private DcMotor frontLeft = null;
    private DcMotor backLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backRight = null;


    @Override
    public void init() {

        // Connect variables to the motors in the Driver Hub configuration
        frontLeft  = hardwareMap.get(DcMotor.class, "front_left");
        backLeft   = hardwareMap.get(DcMotor.class, "back_left");
        frontRight = hardwareMap.get(DcMotor.class, "front_right");
        backRight  = hardwareMap.get(DcMotor.class, "back_right");


        // Same motor directions as your working autonomous
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.FORWARD);


        // Brake when joystick returns to zero
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        telemetry.addData("Status", "Ready");
    }


    @Override
    public void loop() {

        // Left joystick controls forward/backward movement
        double drive = -gamepad1.left_stick_y;

        // Right joystick controls turning
        double turn = gamepad1.right_stick_x;


        // Calculate power for each side
        double leftPower = drive + turn;
        double rightPower = drive - turn;


        // Keep motor powers between -1.0 and +1.0
        double max = Math.max(
                1.0,
                Math.max(Math.abs(leftPower), Math.abs(rightPower))
        );

        leftPower /= max;
        rightPower /= max;


        // Send power to all four motors
        frontLeft.setPower(leftPower);
        backLeft.setPower(leftPower);

        frontRight.setPower(rightPower);
        backRight.setPower(rightPower);


        // Display useful information on Driver Station
        telemetry.addData("Drive", drive);
        telemetry.addData("Turn", turn);
        telemetry.addData("Left Power", leftPower);
        telemetry.addData("Right Power", rightPower);
    }
}