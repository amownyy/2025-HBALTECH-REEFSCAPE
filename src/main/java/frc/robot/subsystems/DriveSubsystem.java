package frc.robot.subsystems;


import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;

@SuppressWarnings("FieldCanBeLocal")
public class DriveSubsystem implements Subsystem {

    private final SparkMax leftLeader = new SparkMax(Constants.DriveConstants.LEFT_MOTOR_ONE, SparkLowLevel.MotorType.kBrushless);
    private final SparkMax leftFollower= new SparkMax(Constants.DriveConstants.LEFT_MOTOR_TWO, SparkLowLevel.MotorType.kBrushless);
    private final SparkMax rightLeader = new SparkMax(Constants.DriveConstants.RIGHT_MOTOR_ONE, SparkLowLevel.MotorType.kBrushless);
    private final SparkMax rightFollower = new SparkMax(Constants.DriveConstants.RIGHT_MOTOR_TWO, SparkLowLevel.MotorType.kBrushless);

    private final DifferentialDrive robotDrive = new DifferentialDrive(leftLeader::set, rightLeader::set);

    private final SparkMaxConfig leftLeaderConfig = new SparkMaxConfig();
    private final SparkMaxConfig rightLeaderConfig = new SparkMaxConfig();
    private final SparkMaxConfig leftFollowerConfig = new SparkMaxConfig();
    private final SparkMaxConfig rightFollowerConfig = new SparkMaxConfig();

    private final Joystick driverController;

    public DriveSubsystem(Joystick driverController) {
        this.driverController = driverController;

        leftLeaderConfig
                .smartCurrentLimit(50)
                .idleMode(SparkBaseConfig.IdleMode.kBrake);
        rightLeaderConfig
                .apply(leftLeaderConfig)
                .inverted(true);
        leftFollowerConfig
                .apply(leftLeaderConfig)
                .follow(leftLeader);
        rightFollowerConfig
                .apply(leftLeaderConfig)
                .follow(rightLeader);

        leftLeader.configure(leftLeaderConfig, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
        leftFollower.configure(leftFollowerConfig, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
        rightLeader.configure(rightLeaderConfig, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
        rightFollower.configure(rightFollowerConfig, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
    }

    @Override
    public void periodic() {
        // Display the applied output of the left and right side onto the dashboard
        SmartDashboard.putNumber("Left Out", leftLeader.getAppliedOutput());
        SmartDashboard.putNumber("Right Out", rightLeader.getAppliedOutput());
    }

    public void arcadeDrive(double forward, double rotation) {
        robotDrive.arcadeDrive(forward, rotation);
    }

}

