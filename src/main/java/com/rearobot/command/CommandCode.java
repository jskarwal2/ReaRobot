package com.rearobot.command;
/**
 *
 * @author Jagdeep Singh
 */
public enum CommandCode {
    PLACE,
    MOVE,
    LEFT,
    RIGHT,
    REPORT,
    EXIT,
    IGNORE;
    
	
    /**
     * @param command
     * @return
     */
    public static CommandCode getByName(String command) {
        for(CommandCode cc : CommandCode.values()) {
            if(cc.name().equals(command.trim().toUpperCase())) {
                return cc;
            }
        }
        return IGNORE;
    }
}
