package org.firstinspires.ftc.teamcode.opmodes.drivercontrolled;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;

@TeleOp (group = "TeleOp", name = "MyFirstTeleOp")
public class MyFirstTeleOp extends OpMode {
    //define the motors, servos, sensors and so forth that you will use throughout your OpMode here
    // remember to import
    private DcMotor rightMotor;
    private DcMotor leftMotor;
    private Servo servo;
    private ColorSensor sensor;

    /**
     * this is where you should initialise all of your variables you just defined, this is what runs
     * when you press the init button
     */
    @Override
    public void init() {
        this.rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");
        this.leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        this.servo = hardwareMap.get(Servo.class, "servo");
        this.sensor = hardwareMap.get(ColorSensor.class, "sensor");
    }

    /**
     * this is the "main" function. it runs when you press the play button for this OpMode
     * it is a loop so will run continuously until you press stop
     */
    @Override
    public void loop() {

    }

    // this is where you should define helper functions for your main code
}