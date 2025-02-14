package frc.robot.subsystems;


import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;

public class AlgOutTakeSubsystem implements Subsystem {
    //private final SparkMax outTakeMotor = new SparkMax(Constants.AlgConstants.ALG_MOTOR_ID, SparkLowLevel.MotorType.kBrushed);
    private final SparkMaxConfig outTakeConfig = new SparkMaxConfig();

    private final Joystick shooterController;

    public AlgOutTakeSubsystem(Joystick shooterController) {
        this.shooterController = shooterController;

        outTakeConfig
                .idleMode(SparkBaseConfig.IdleMode.kBrake);
    }

    public void outTake() {
        //outTakeMotor.set(Constants.AlgConstants.ALG_OUTTAKE_SPEED);
    }

    public void stop() {
        //outTakeMotor.set(0);
    }
}

