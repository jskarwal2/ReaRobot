package com.rearobot;

import org.junit.Assert;
import org.junit.Test;

import com.rearobot.command.LeftCommand;
import com.rearobot.command.PlaceCommand;
import com.rearobot.command.ReportCommand;
import com.rearobot.direction.Direction;
import com.rearobot.exception.InvalidCommandException;
import com.rearobot.position.Position;
import com.rearobot.robot.Robot;
import com.rearobot.tabletop.FiveXFiveTableTop;
import com.rearobot.tabletop.TableTop;

public class TestExampleB {

	@Test
	public void test() {
		//		### Example b
		//
		//	    PLACE 0,0,NORTH
		//	    LEFT
		//	    REPORT
		//
		//	Expected output:
		//
		//	    0,0,WEST
	    
		Robot robot = new Robot();
		TableTop tableTop = new FiveXFiveTableTop();
		robot.setTableTop(tableTop);
		Position position = new Position((byte)0, (byte)0, Direction.NORTH);
		try {
			
			robot.processCommand(new PlaceCommand(position));
			robot.processCommand(new LeftCommand());
			robot.processCommand(new ReportCommand());
		} catch (InvalidCommandException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(new Position((byte)0, (byte)0, Direction.WEST), robot.getCurrentPosition());
	}

}
