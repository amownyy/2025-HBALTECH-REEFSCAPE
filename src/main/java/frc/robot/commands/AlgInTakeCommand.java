package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.AlgInTakeSubsystem;


public class AlgInTakeCommand extends Command {
    private final AlgInTakeSubsystem algInTakeSubsystem;

    public AlgInTakeCommand(AlgInTakeSubsystem algInTakeSubsystem) {
        this.algInTakeSubsystem = algInTakeSubsystem;
        addRequirements(this.algInTakeSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        algInTakeSubsystem.inTake();
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        algInTakeSubsystem.stop();
    }
}
