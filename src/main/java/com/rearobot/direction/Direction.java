package com.rearobot.direction;

/**
 *
 * @author Jagdeep Singh
 */
public enum Direction {
    
    EAST,
    WEST,
    NORTH,
    SOUTH;
    
    public static Direction getByName(String commandDirection) {
        for(Direction d : Direction.values()) {
            if(d.name().equals(commandDirection.trim().toUpperCase())) {
                return d;
            }
        }
        return null;
    }
    
    public Direction getLeftDirection() {
        switch(this) {
            case EAST:
                return NORTH;
            case WEST:
                return SOUTH;
            case NORTH:
                return WEST;
            default:  
            //case SOUTH:
                return EAST;    
        }
    }
    
    public Direction getRightDirection() {
        switch(this) {
            case EAST:
                return SOUTH;
            case WEST:
                return NORTH;
            case NORTH:
                return EAST;
            default:  
            //case SOUTH:
                return WEST;    
        }
    }
}
