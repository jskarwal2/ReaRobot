package com.rearobot.position;

import com.rearobot.direction.Direction;

/**
 *
 * @author Jagdeep Singh
 */
public class Position {
    
    private byte x;
    private byte y;
    private Direction direction;

    public Position(byte x, byte y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public byte getX() {
        return x;
    }

    public void setX(byte x) {
        this.x = x;
    }

    public byte getY() {
        return y;
    }

    public void setY(byte y) {
        this.y = y;
    }
    
    public void incrementX() {
        x++;
    }
    
    public void decrementX(){
        x--;
    }
    public void incrementY() {
        y++;
    }
    
    public void decrementY(){
        y--;
    }
    
    public String toString() {
    	return "Position [" + x + "," + y + "," + direction.name() + "]";
    }
    
    public boolean equals(Object otherPosition) {
    	Position other = (Position) otherPosition;
    	if(x == other.x && y == other.y) {
    		if(direction != null && other.getDirection() != null && direction == other.getDirection()) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public int hashCode() {
    	String s = x + "" + y;
    	if(direction != null) {
    		s = s + direction.ordinal();
    	}
    	return Integer.parseInt(s);
    }
}
