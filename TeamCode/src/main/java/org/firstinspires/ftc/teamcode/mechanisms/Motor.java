package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;
public class Motor {
    private DcMotor motor;

    private double ticksperRev; //Revolution

     public void init(HardwareMap hwMap){

         motor = hwMap.get(DcMotor.class, "front_left");
         motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
         ticksperRev= motor.getMotorType().getTicksPerRev();
     }

     public void setMotorspeed (double speed){
         motor.setPower(speed);
     }

     public double getMotorRevs(){
         return motor.getCurrentPosition()/ticksperRev; // normalizing ticks to revolutions
     }

    public MotorConfigurationType getmotortype() {
        return motor.getMotorType();
    }
}

