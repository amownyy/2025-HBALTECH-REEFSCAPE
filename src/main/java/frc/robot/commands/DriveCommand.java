package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;


public class DriveCommand extends Command {
    private final DriveSubsystem driveSubsystem;

    public DriveCommand(DriveSubsystem driveSubsystem) {
        this.driveSubsystem = driveSubsystem;
        addRequirements(this.driveSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        driveSubsystem.arcadeDrive();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
