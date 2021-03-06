package org.usfirst.frc.team3684.robot.commands;

import org.usfirst.frc.team3684.robot.Robot;
import org.usfirst.frc.team3684.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn90Left extends Command {
	public double staticHeading;
	public double currentHeading;
	public double m_angle;
    public Turn90Left(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	m_angle = angle;
    	requires(Robot.driveTrain);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	staticHeading = Robot.gyro.getAngle();
    	currentHeading = Robot.gyro.getAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
			Drivetrain.myDrive.tankDrive(-.5, .5);
	    	currentHeading = Robot.gyro.getAngle();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return currentHeading <= staticHeading-(m_angle-5);
    }
    // Called once after isFinished returns true
    protected void end() {
    	Drivetrain.myDrive.tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
