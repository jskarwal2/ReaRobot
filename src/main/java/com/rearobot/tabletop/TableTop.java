package com.rearobot.tabletop;

import com.rearobot.position.Position;

/**
 *
 * @author Jagdeep Singh
 */
public interface TableTop {
    
    public boolean isValidPosition(Position position);
    
    public boolean isTerminalMove(Position currentPosition);
}
