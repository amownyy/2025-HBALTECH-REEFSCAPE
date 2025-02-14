package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;

@SuppressWarnings("FieldCanBeLocal")
public class DriveSubsystem implements Subsystem {

    private final SparkMax leftLeader = new SparkMax(Constants.DriveConstants.LEFT_MOTOR_ONE_ID, SparkLowLevel.MotorType.kBrushed);
    private final SparkMax leftFollower= new SparkMax(Constants.DriveConstants.LEFT_MOTOR_TWO_ID, SparkLowLevel.MotorType.kBrushed);
    private final SparkMax rightLeader = new SparkMax(Constants.DriveConstants.RIGHT_MOTOR_ONE_ID, SparkLowLevel.MotorType.kBrushed);
    private final SparkMax rightFollower = new SparkMax(Constants.DriveConstants.RIGHT_MOTOR_TWO_ID, SparkLowLevel.MotorType.kBrushed);

    private final SparkMaxConfig leftLeaderConfig = new SparkMaxConfig();
    private final SparkMaxConfig rightLeaderConfig = new SparkMaxConfig();
    private final SparkMaxConfig leftFollowerConfig = new SparkMaxConfig();
    private final SparkMaxConfig rightFollowerConfig = new SparkMaxConfig();

    private final Joystick driverController;
    private final DifferentialDrive robotDrive;

    private DifferentialDrivetrainSim drivetrainSim = DifferentialDrivetrainSim.createKitbotSim(
            DifferentialDrivetrainSim.KitbotMotor.kDualCIMPerSide,
            DifferentialDrivetrainSim.KitbotGearing.k10p71,
            DifferentialDrivetrainSim.KitbotWheelSize.kSixInch,
            null
    );

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

        robotDrive = new DifferentialDrive(leftLeader::set, rightLeader::set);
    }

    @Override
    public void periodic() {
        // Display the applied output of the left and right side onto the dashboard
    }

    public void arcadeDrive() {

        double forward = (driverController.getRawAxis(3)-driverController.getRawAxis(2)) * Constants.DriveConstants.ARCADE_DRIVE_Y_SPEED;
        double rotate = driverController.getX() * Constants.DriveConstants.ARCADE_DRIVE_X_SPEED;

        SmartDashboard.putNumber("Forward", forward);
        SmartDashboard.putNumber("Rotate", rotate);
        robotDrive.arcadeDrive(forward, rotate);
    }

}

