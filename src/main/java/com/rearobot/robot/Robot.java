package com.rearobot.robot;

import com.rearobot.command.Command;
import com.rearobot.command.CommandCode;
import com.rearobot.command.PlaceCommand;
import com.rearobot.exception.InvalidCommandException;
import com.rearobot.position.Position;
import com.rearobot.tabletop.TableTop;

/**
 *
 * @author Jagdeep Singh
 */
public class Robot {
    
    private Position currentPosition;
    private TableTop tableTop;
    
    public void processCommand(Command command) throws InvalidCommandException {
        if(currentPosition == null && command.getCommandCode() != CommandCode.PLACE) {
            throw new InvalidCommandException("First command must be PLACE");
        }
        
        System.out.println("Processing " + command.getCommandCode().name() +" command");
        switch(command.getCommandCode()) {
            case PLACE:
                PlaceCommand placeCommand = (PlaceCommand)command;
                if(tableTop.isValidPosition(placeCommand.getPosition())){
                    System.out.println("PLACE command : " + placeCommand.getPosition().toString());
                	setCurrentPosition(placeCommand.getPosition());
                } else {
                    System.out.println("Invalid co-ordinates. Command Ignored");
                }
                break;
            case LEFT:
                currentPosition.setDirection(currentPosition.getDirection().getLeftDirection());
                break;
            case RIGHT:
                currentPosition.setDirection(currentPosition.getDirection().getRightDirection());
                break;
            case MOVE:
                if(!tableTop.isTerminalMove(currentPosition)) {
                    switch(currentPosition.getDirection()) {
                        case EAST:
                            currentPosition.incrementX();
                            break;
                        case WEST:
                            currentPosition.decrementX();
                            break;
                        case NORTH:
                            currentPosition.incrementY();
                            break;
                        case SOUTH:
                            currentPosition.decrementY();
                            break;
                    }
                } else {
                	System.out.println(" Cannot move further .. I will fall to destruction.");
                }
                break;
            case REPORT:
                System.out.println(currentPosition.toString());
        }
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public TableTop getTableTop() {
        return tableTop;
    }

    public void setTableTop(TableTop tableTop) {
        this.tableTop = tableTop;
    }
    
}
