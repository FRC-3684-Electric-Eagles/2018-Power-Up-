package org.usfirst.frc.team3684.robot.commands;

import org.usfirst.frc.team3684.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClawStop extends Command {
	public Timer timer;
    public ClawStop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.clawRollers);
    	this.timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.clawRollers.setMotors(0, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.timer.get() >= .25;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.clawRollers.setMotors(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
