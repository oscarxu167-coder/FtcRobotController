package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.mechanisms.Sensors;

public class Sensor_Test extends OpMode{

// touchsensor test
    Sensors bench = new Sensors();

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("Touch Sensor state", bench.isTouchSensorPressed());
    }
}

