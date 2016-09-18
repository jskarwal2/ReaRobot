package com.rearobot;

import com.rearobot.command.Command;
import com.rearobot.command.CommandCode;
import com.rearobot.command.CommandParser;
import com.rearobot.command.ConsoleCommandParser;
import com.rearobot.tabletop.FiveXFiveTableTop;
import com.rearobot.tabletop.TableTop;

import com.rearobot.command.ReportCommand;
import com.rearobot.exception.InvalidCommandException;
import com.rearobot.exception.UnparseableCommandException;
import com.rearobot.robot.Robot;

/**
 *
 * @author Jagdeep Singh
 * Main Class and starting point
 */
public class ReaRobot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TableTop tableTop = new FiveXFiveTableTop();
        Robot robot = new Robot();
        robot.setTableTop(tableTop);
        CommandParser commandParser = new ConsoleCommandParser();
        boolean exit  = false;
        while(true && !exit) {
            System.out.println("Waiting For command .... [Press enter for help]");
            
            try {
                Command command = commandParser.readNextCommand();
                if(command.getCommandCode() == CommandCode.EXIT) {
                	processExit(commandParser);
                	exit = true;
                }
                robot.processCommand(command);
                //Auto Report Feature
                if(robot.getCurrentPosition() != null && command.getCommandCode() != CommandCode.REPORT) {
                	robot.processCommand(new ReportCommand());
                }
            } catch(UnparseableCommandException e) {
                System.out.println(e.getMessage());
                printUsage();
            } catch(InvalidCommandException e) {
                System.out.println(e.getMessage());
            } 
        }
        
    }

    private static void printUsage() {
        System.out.println("Acceptable commands ..");
        System.out.println("    PLACE X,Y,F : WHERE F IS DIRECTION (EAST, WEST, NORTH, SOUTH) " +
                           "    MOVE\n" +
                           "    LEFT\n" +
                           "    RIGHT\n" +
                           "    REPORT\n" + 
                           "    EXIT");
    }
    
    private static void processExit(CommandParser commandParser){
    	System.out.println("Powering Off ...............");
    	commandParser.closeResources();
    	System.out.println("Robot Off");
    	System.exit(1);
    }
}
