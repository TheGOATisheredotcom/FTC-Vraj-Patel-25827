package org.firstinspires.ftc.teamcode.utility;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;



public class RookieTeam1CodeHardware  {

    /*
     * The mecanum drivetrain involves four separate motors that spin in
     * different directions and different speeds to produce the desired
     * movement at the desired speed.
     */

    // declare and initialize four DcMotors.
    public DcMotor front_left  = null;
    public DcMotor front_right = null;
    public DcMotor back_left   = null;
    public DcMotor back_right  = null;


    HardwareMap hardwareMap;

    public void init(HardwareMap hardwareMap) {

        // Name strings must match up with the config on the Robot Controller
        // app.
        front_left   = hardwareMap.get(DcMotor.class, "front_left");
        front_right  = hardwareMap.get(DcMotor.class, "front_right");
        back_left    = hardwareMap.get(DcMotor.class, "back_left");
        back_right   = hardwareMap.get(DcMotor.class, "back_right");
    }


    public void loop() {

           front_left.setPower(0);
           front_right.setPower(0);
           back_left.setPower(0);
           back_right.setPower(0);

           front_left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
           front_right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
           back_left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
           back_right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

           front_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
           front_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
           back_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
           back_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);




    }
}







