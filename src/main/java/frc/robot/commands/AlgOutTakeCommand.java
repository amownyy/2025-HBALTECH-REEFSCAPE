package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.AlgOutTakeSubsystem;


public class AlgOutTakeCommand extends Command {
    private final AlgOutTakeSubsystem algOutTakeSubsystem;

    public AlgOutTakeCommand(AlgOutTakeSubsystem algOutTakeSubsystem) {
        this.algOutTakeSubsystem = algOutTakeSubsystem;
        addRequirements(this.algOutTakeSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        algOutTakeSubsystem.outTake();
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        algOutTakeSubsystem.stop();
    }
}
