package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Disabled
@Autonomous(name = "Hello World Autonomous", group = "Autonomous")
public class HelloWorld extends LinearOpMode {


    // Declare the 4 motors on the Expansion Hub
    private DcMotor frontLeft = null;
    private DcMotor backLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backRight = null;


    @Override
    public void runOpMode() {
        String name = "Romebots";
        telemetry.addData("Team name", name);

        // Initialize hardware mapping (must match Driver Hub config names exactly)
        frontLeft  = hardwareMap.get(DcMotor.class, "front_left");
        backLeft   = hardwareMap.get(DcMotor.class, "back_left");
        frontRight = hardwareMap.get(DcMotor.class, "front_right");
        backRight  = hardwareMap.get(DcMotor.class, "back_right");


        // Reverse left-side motors so positive power moves the robot forward
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.FORWARD);


        // Set motors to brake mode so the robot stops promptly
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        telemetry.addData("Status", "Ready for Autonomous");
        telemetry.update();


        // Wait for the driver to tap INIT and then press PLAY
        waitForStart();


        // Check if the match is still active before running actions
        if (opModeIsActive()) {


            // --- STEP 1: Drive Forward for 2 Seconds ---
            telemetry.addData("Status", "Driving Forward");
            telemetry.update();
            setDrivePower(0.5, 0.5); // 50% power to left and right
            sleep(2000);             // Wait 2000 ms (2 seconds)


            // --- STEP 2: Turn Right for 1 Second ---
            telemetry.addData("Status", "Turning Right");
            telemetry.update();
            setDrivePower(0.5, -0.5); // Spin left side forward, right side backward
            sleep(1000);              // Wait 1000 ms (1 second)


            // --- STEP 3: Stop All Motors ---
            telemetry.addData("Status", "Complete - Stopped");
            telemetry.update();
            setDrivePower(0.0, 0.0);
        }
    }


    /**
     * Helper method to assign power to all four motors simultaneously
     */
    private void setDrivePower(double leftPower, double rightPower) {
        frontLeft.setPower(leftPower);
        backLeft.setPower(leftPower);
        frontRight.setPower(rightPower);
        backRight.setPower(rightPower);
    }
}
