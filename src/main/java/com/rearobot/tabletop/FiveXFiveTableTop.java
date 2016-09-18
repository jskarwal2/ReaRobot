package com.rearobot.tabletop;

import com.rearobot.direction.Direction;
import com.rearobot.position.Position;

/**
 *
 * @author Jagdeep Singh
 */
public class FiveXFiveTableTop implements TableTop {

    private static final byte ROWS = 5;
    private static final byte COLUMNS = 5;
    byte maxColumns;
    
    @Override
    public boolean isTerminalMove(Position currentPosition) {
        if(currentPosition.getDirection() == Direction.SOUTH && currentPosition.getY() == 0) {
            return true;
        }
        
        if(currentPosition.getDirection() == Direction.NORTH && currentPosition.getY() == (ROWS-1)) {
            return true;
        }
        
        if(currentPosition.getDirection() ==  Direction.EAST && currentPosition.getX() == (COLUMNS-1)) {
            return true;
        }
        
        if(currentPosition.getDirection() == Direction.WEST && currentPosition.getX() == 0) {
            return true;
        }
        return false;
    }
    
    @Override
	public boolean isValidPosition(Position position) {
		return position.getX() < ROWS && position.getY() < COLUMNS;
	}
    
}
