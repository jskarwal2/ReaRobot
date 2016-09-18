package com.rearobot.command;

import com.rearobot.exception.UnparseableCommandException;

/**
 *
 * @author Jagdeep Singh
 */
public interface CommandParser {
 
    public Command readNextCommand() throws UnparseableCommandException;
    
    public void closeResources(); 
}
