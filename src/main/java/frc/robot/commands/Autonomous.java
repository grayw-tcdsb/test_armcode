// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class Autonomous extends CommandBase {
  /*Creates a new Autonomous. 
   *Create timer */
    public final Timer clock = new Timer();

  public Autonomous() {
    // Use addRequirements() here to declare subsystem dependencies.

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    clock.reset();
    Robot.m_robotContainer.driveSubsystem.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (clock.get() < 5) {
      drive_Forward();
      System.out.println(clock.get());
    } else if (clock.get() < 7) {
      turn_right();
    } else {
      Robot.m_robotContainer.driveSubsystem.stop();
    }

  }

  public void drive_Forward() {
    Robot.m_robotContainer.driveSubsystem.drive(Constants.fastRobotSpeed, 0);
  }

  public void turn_right() {
    Robot.m_robotContainer.driveSubsystem.drive(Constants.slowRobotSpeed,90);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_robotContainer.driveSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
