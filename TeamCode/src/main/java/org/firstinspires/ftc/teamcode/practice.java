package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class practice extends OpMode {

    boolean initDone;
    @Override
    public void init() {
        telemetry.addData("Init",initDone);
        initDone= true;


    }
    double Squarefunc(double input){
        double output = input * input;
        if (input<0) {
            output*=-1;
        }
        return output;
    }

    @Override
    public void loop() {
        double yAxis = gamepad1.left_stick_y;
        telemetry.addData("left_y axis", yAxis);
        yAxis= Squarefunc(yAxis);



    }
}
