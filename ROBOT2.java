package MerAntonJoshua;
import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * ROBOT1 - a robot by (your name here)
 */
public class ROBOT2 extends TeamRobot
{
	/**
	 * run: ROBOT1's default behavior
	 */
	boolean peek;
	double moveAmount;
	public void run() {
		// Initialization of the robot should be put here
		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:
		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar
		// Robot main loop
		setBodyColor(Color.blue);
        setGunColor(Color.yellow);
        setRadarColor(Color.white);
        setBulletColor(Color.cyan);
        setScanColor(Color.cyan);
		moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
        peek = false;
        turnLeft(getHeading() % 90);
        ahead(moveAmount);
		peek = true;
        turnGunRight(90);
        turnRight(90);
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			peek = true;
			ahead(moveAmount);
			peek = false;
			turnRight(90);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		if (e.getName()=="ROBOT1"){
			return;
		}
		else{
			fire(6);
			//if (peek){
				//scan();
			//}
		}
		scan();
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		if (e.getBearing() > -90 && e.getBearing() < 90) {
            back(100);
        } // else he's in back of us, so set ahead a bit.
        else {
            ahead(100);
        }
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	//public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
	//	back(20);
	//}	
}
