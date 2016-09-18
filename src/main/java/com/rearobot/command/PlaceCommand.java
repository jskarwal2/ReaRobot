package com.rearobot.command;

import com.rearobot.position.Position;

/**
 *
 * @author Jagdeep Singh
 */
public class PlaceCommand extends Command {
    
    private Position position;
    
    public PlaceCommand(Position position) {
        this.position = position;
        this.setCommandCode(CommandCode.PLACE);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    
    
}
