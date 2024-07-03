package org.firstinspires.ftc.teamcode.opmodes.drivercontrolled;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.utility.RookieTeam1CodeHardware;

@TeleOp(name = "RookieTeam1Code" , group = "Opmode")
public class RookieTeam1Code extends OpMode {

       RookieTeam1CodeHardware robot = new RookieTeam1CodeHardware();

    @Override
    public void init() {
      robot.init(hardwareMap);
      telemetry.addData("STATUS","Initialized");
    }

    @Override
    public void loop() {
       double G1rightStickY = gamepad1.right_stick_y;
       double G1leftStickY = gamepad1.left_stick_y;
       boolean G1rightBumper = gamepad1.right_bumper;
       boolean G1leftBumper = gamepad1.left_bumper;



       if (G1rightBumper) {
           robot.back_left.setPower(-1);
           robot.back_right.setPower(1);
           robot.front_left.setPower(1);
           robot.front_right.setPower(-1);
       }
       else if (G1leftBumper) {
           robot.back_left.setPower(1);
           robot.back_right.setPower(-1);
           robot.front_left.setPower(-1);
           robot.front_right.setPower(1);
       }
       else {
           robot.back_left.setPower(-G1leftStickY);
           robot.back_right.setPower(-G1rightStickY);
           robot.front_left.setPower(G1leftStickY);
           robot.front_right.setPower(G1rightStickY);
       }


    }
}


