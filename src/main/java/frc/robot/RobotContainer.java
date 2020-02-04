/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commandGroups.TeleGroup;
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

//IMPLEMENT COMMAND GROUPS

  public CommandBase m_autoCommand;
  public DriveCommand m_driveCommand;
  
  CommandGroup TeleGroup = null;
  DriveAuto driveAuto = null;
  public SendableChooser<String> initPos = new SendableChooser<String>();
  private Drivetrain drive;

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer(boolean kitbot) {
    if(kitbot)
      drive = new DrivetrainKB(); 
    else
      drive = new Drivetrain();
    
    m_driveCommand = new CommandGroup();
    m_autoCommand = new DriveCommand();

    TeleGroup = new CommandGroup();
    driveAuto = new DriveAuto(Robot.drive);
    // Configure the button bindings
    configureButtonBindings();
    Robot.drive.setDefaultCommand(m_driveCommand);
    //Robot.wof.setDefaultCommand(m_autoCommand);

    initPos.addOption("Left", "L");
    initPos.addOption("Middle", "M");
    initPos.addOption("Preferred", "P");
    initPos.addOption("Right", "R");

    SmartDashboard.putData(initPos);
  }

  public Drivetrain getDT(){
    return drive;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

   Robot.m_oi.hopButt.toggleWhenPressed(m_driveCommand);

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public CommandBase getAutonomousCommand() {

    m_autoCommand = driveAuto;
    return m_autoCommand;
  }

  public CommandBase getTeleopCommand(){

    m_driveCommand = TeleGroup;

    return m_driveCommand;
  }

  public RobotMap.StartingPosition getStartingPosition(){
    RobotMap.StartingPosition startPos = RobotMap.StartingPosition.Preffered;
    switch (initPos.getSelected()) {
      case "R":
        return RobotMap.StartingPosition.Right;
      case "M":
        return RobotMap.StartingPosition.Middle;
      case "L":
        return RobotMap.StartingPosition.Left;
      case "P":
        return RobotMap.StartingPosition.Preffered;
    }
    return startPos;
  }
  
}
















































































































































































































































































































//haha butt