/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.DriveAuto;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.DrivetrainKB;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
 

  //public final DrivetrainKB drivetrainKB = new DrivetrainKB();

  public final CommandBase m_autoCommand;
  public final DriveCommand m_driveCommand;
  //public Drivetrain 

  DriveCommand c_drive;



  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer(boolean kitbot) {
    if(kitbot)
      Robot.drive = new DrivetrainKB(); 
    else
      Robot.drive = new Drivetrain();
    
    m_driveCommand = new DriveCommand();
    m_autoCommand = new DriveCommand();
    // Configure the button bindings
    configureButtonBindings();
    Robot.drive.setDefaultCommand(m_driveCommand);
    Robot.wof.setDefaultCommand(m_autoCommand);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

   // Robot.m_oi.butt1.toggleWhenPressed(m_driveCommand);

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public CommandBase getAutonomousCommand() {
   // m_autoCommand = ;
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

  public CommandBase getTeleopCommand(){

    // m_driveCommand = c_drive;

    return m_driveCommand;
  }
}

































































































































































































































































































































































//haha butt