package frc.robot.subsystems;


import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;

public class CoralShootSubsystem implements Subsystem {

    private final SparkMax shooterMotor = new SparkMax(Constants.CoralConstants.CORAL_MOTOR_ID, SparkLowLevel.MotorType.kBrushed);
    private final SparkMaxConfig shooterConfig = new SparkMaxConfig();

    private final Joystick shooterController;

    public CoralShootSubsystem(Joystick shooterController) {
        this.shooterController = shooterController;

        shooterConfig
                .smartCurrentLimit(50)
                .idleMode(SparkBaseConfig.IdleMode.kBrake);

        shooterMotor.configure(shooterConfig, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
    }

    public void shoot() {
        shooterMotor.set(Constants.CoralConstants.CORAL_MOTOR_SPEED);
    }

    public void stop() {
        shooterMotor.set(0);
    }
}

