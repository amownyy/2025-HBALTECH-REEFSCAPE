package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;


public class DriveCommand extends Command {
    private final DriveSubsystem driveSubsystem;
    private final double forward;
    private final double rotation;

    public DriveCommand(DriveSubsystem driveSubsystem, double forward, double rotation) {
        this.driveSubsystem = driveSubsystem;
        this.forward = forward;
        this.rotation = rotation;
        addRequirements(this.driveSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        driveSubsystem.arcadeDrive(forward, rotation);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
