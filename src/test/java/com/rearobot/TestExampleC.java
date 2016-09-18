package com.rearobot;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.rearobot.command.LeftCommand;
import com.rearobot.command.MoveCommand;
import com.rearobot.command.PlaceCommand;
import com.rearobot.command.ReportCommand;
import com.rearobot.direction.Direction;
import com.rearobot.exception.InvalidCommandException;
import com.rearobot.position.Position;
import com.rearobot.robot.Robot;
import com.rearobot.tabletop.FiveXFiveTableTop;
import com.rearobot.tabletop.TableTop;

public class TestExampleC {

	@Test
	public void test() {
		//	    PLACE 1,2,EAST
		//	    MOVE
		//	    MOVE
		//	    LEFT
		//	    MOVE
		//	    REPORT
		//		
		//		Expected output
		//
		//	    3,3,NORTH
		
		Robot robot = new Robot();
		TableTop tableTop = new FiveXFiveTableTop();
		robot.setTableTop(tableTop);
		Position position = new Position((byte)1, (byte)2, Direction.EAST);
		try {
			robot.processCommand(new PlaceCommand(position));
			robot.processCommand(new MoveCommand());
			robot.processCommand(new MoveCommand());
			robot.processCommand(new LeftCommand());
			robot.processCommand(new MoveCommand());
			robot.processCommand(new ReportCommand());
		} catch (InvalidCommandException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(new Position((byte)3, (byte)3, Direction.NORTH), robot.getCurrentPosition());
	}

}
