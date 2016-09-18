package com.rearobot;

import org.junit.Assert;
import org.junit.Test;

import com.rearobot.command.LeftCommand;
import com.rearobot.exception.InvalidCommandException;
import com.rearobot.robot.Robot;
import com.rearobot.tabletop.FiveXFiveTableTop;
import com.rearobot.tabletop.TableTop;

public class RobotTestFirstNonPlaceCommand {

	@Test
	public void test() {
		
		Robot robot = new Robot();
		TableTop tableTop = new FiveXFiveTableTop();
		robot.setTableTop(tableTop);
		try {
			robot.processCommand(new LeftCommand());
		} catch (InvalidCommandException e) {
			Assert.assertTrue(robot.getCurrentPosition() == null);
		}
	}

}
