package frc.robot.subsystems;


import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;

public class AlgInTakeSubsystem implements Subsystem {
    //private final SparkMax inTakeMotor = new SparkMax(Constants.AlgConstants.ALG_MOTOR_ID, SparkLowLevel.MotorType.kBrushed);
    private final SparkMaxConfig inTakeConfig = new SparkMaxConfig();

    private final Joystick shooterController;

    public AlgInTakeSubsystem(Joystick shooterController) {
        this.shooterController = shooterController;

        inTakeConfig
                .idleMode(SparkBaseConfig.IdleMode.kBrake);
    }

    public void inTake() {
        //inTakeMotor.set(Constants.AlgConstants.ALG_INTAKE_SPEED);
    }

    public void stop() {
        //inTakeMotor.set(0);
    }
}

