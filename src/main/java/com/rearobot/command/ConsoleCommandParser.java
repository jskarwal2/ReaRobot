package com.rearobot.command;

import java.util.Scanner;

import com.rearobot.direction.Direction;
import com.rearobot.exception.UnparseableCommandException;
import com.rearobot.position.Position;

/**
 *
 * @author Jagdeep Singh
 */
public class ConsoleCommandParser implements CommandParser {

	
	private Scanner scanner = new Scanner(System.in);
	
	@Override
    public Command readNextCommand() throws UnparseableCommandException {
        
		
		String commandString = scanner.nextLine();
        String[] tokens = commandString.split(" ");
        if(tokens.length > 0 ) {
            CommandCode commandCode = CommandCode.getByName(tokens[0]);
            switch(commandCode) {
                case PLACE:
                    String coordinatesAndDirectionString = commandString.substring(tokens[0].length());
                    String[] coordinatesAndDirectionTokens = coordinatesAndDirectionString.split(",");
                    if(coordinatesAndDirectionTokens.length == 3) {
                         byte x = Byte.parseByte(coordinatesAndDirectionTokens[0].trim());
                         byte y = Byte.parseByte(coordinatesAndDirectionTokens[1].trim());
                         Direction direction = Direction.getByName(coordinatesAndDirectionTokens[2]);
                         if(direction != null) {
                        	 return new PlaceCommand(new Position(x, y, direction));
                         } else {
                        	 throw new UnparseableCommandException ("Unparseable direction :" + coordinatesAndDirectionTokens[2]);
                         }
                    } else {
                        throw new UnparseableCommandException ("Unparseable command :" + commandString);
                    }
                case MOVE:
                    return new MoveCommand();
                case LEFT:
                    return new LeftCommand();
                case RIGHT:
                    return new RightCommand();
                case REPORT:
                    return new ReportCommand();
                case EXIT:
                	return new ExitCommand();
                default: 
                    throw new UnparseableCommandException ("Unparseable command :" + commandString);
            }
        } else {
        	 throw new UnparseableCommandException ("Unparseable command :" + commandString);
        }
	}
	
	public void closeResources() {
			scanner.close();
	}
}
