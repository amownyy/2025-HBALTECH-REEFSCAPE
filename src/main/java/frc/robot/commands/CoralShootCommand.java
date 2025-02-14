package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CoralShootSubsystem;


public class CoralShootCommand extends Command {
    private final CoralShootSubsystem coralShootSubsystem;

    public CoralShootCommand(CoralShootSubsystem coralShootSubsystem) {
        this.coralShootSubsystem = coralShootSubsystem;
        addRequirements(this.coralShootSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        SmartDashboard.putBoolean("Coral Shooting", true);
        coralShootSubsystem.shoot();
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        coralShootSubsystem.stop();
        SmartDashboard.putBoolean("Coral Shooting", false);
    }
}
