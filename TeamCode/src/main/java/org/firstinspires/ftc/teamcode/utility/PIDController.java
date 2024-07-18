package org.firstinspires.ftc.teamcode.utility;

import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * A PID controller class for any application
 * Needs to be manually tuned
 */
public class PIDController {
    private ElapsedTime timer;
    private boolean started;

    private double pCoeff;
    private double iCoeff;
    private double dCoeff;

    private double integral;

    private Supplier<Double> valueSupplier;
    private double lastValue;
    private double target;

    /**
     * default constructor, will set all values to 0, except the proportion coefficient, will not run until you set the valueSupplier
     */
    public PIDController() {
        this.timer = new ElapsedTime();
        this.started = false;

        this.pCoeff = 1;
        this.iCoeff = 0;
        this.dCoeff = 0;

        this.integral = 0;

        this.valueSupplier = null;
        this.lastValue = 0;
        this.target = 0;
    }

    /**
     * create a PID controller with P,I and D coefficients of 1,0,0 respectively
     * @param target The target value for the controller to approach
     * @param valueSupplier A supplier function that provides the current value for the controller
     */
    public PIDController(double target, Supplier<Double> valueSupplier) {
        this.timer = new ElapsedTime();
        this.started = false;

        this.pCoeff = 1;
        this.iCoeff = 0;
        this.dCoeff = 0;

        this.integral = 0;

        this.valueSupplier = valueSupplier;
        this.lastValue = 0;
        this.target = target;
    }

    /**
     * create a PID controller with the given parameters
     * @param target The target value for the controller to approach
     * @param valueSupplier A supplier function that provides the current value for the controller
     * @param pCoeff The coefficient for the proportion of error
     * @param iCoeff The coefficient for the integral of error
     * @param dCoeff The coefficient for the derivative of error
     */
    public PIDController(double target, Supplier<Double> valueSupplier, double pCoeff, double iCoeff, double dCoeff) {
        this.timer = new ElapsedTime();
        this.started = false;

        this.pCoeff = pCoeff;
        this.iCoeff = iCoeff;
        this.dCoeff = dCoeff;

        this.integral = 0;

        this.valueSupplier = valueSupplier;
        this.lastValue = 0;
        this.target = target;
    }

    /**
     * starts the PID controller, required for process() to function.
     * recommended to place immediately before the start of controll loop.
     * Requires valueSupplier to have been set.
     */
    public void start() {
        if (this.valueSupplier != null) {
            this.started = true;
            this.lastValue = this.valueSupplier.get();
            this.timer.reset();
        }
    }

    /**
     * Stops the controller. Will prevent the controller from outputting bad data after long periods
     * of time when PID is not used. The controller will need to be restarted to process() again.
     */
    public void stop() {
        this.started = false;
        this.timer.reset();
    }

    /**
     * stop()s the controller and resets the running integral to 0.
     */
    public void fullReset() {
        this.integral = 0;
        this.stop();
    }

    /**
     * Performs a control flow cycle of the PID controller
     * Requires start() to have been called, and neither of stop() or fullReset() to have been
     *          called after start()
     * Requires valueSupplier to have been set.
     * @return The output of the controller (whatever you intended for it to be. e.g. motorPower)
     */
    public double process() {
        if (this.started) {
            double crntVal = this.valueSupplier.get();
            double deltaTime = this.timer.milliseconds();

            double proportion = this.target - crntVal;
            double derivative = (crntVal - this.lastValue) / deltaTime;
            this.integral += (this.lastValue + (crntVal - this.lastValue) / 2) * deltaTime;

            return this.pCoeff * proportion + this.iCoeff * this.integral + this.dCoeff * derivative;
        }
        return 0;
    }


    /**
     * setters
     */

    public void setPCoeff(double value) { this.pCoeff = value; }
    public void setICoeff(double value) { this.iCoeff = value; }
    public void setDCoeff(double value) { this.dCoeff = value; }
    public void setTarget(double value) { this.target = value; }
    public void setValueSupplier(Supplier<Double> func) { this.valueSupplier = func; }

    /**
     * getters
     */

    public double getPCoeff() { return this.pCoeff; }
    public double getICoeff() { return this.iCoeff; }
    public double getDCoeff() { return this.dCoeff; }
    public double getTarget() { return this.target; }

}
