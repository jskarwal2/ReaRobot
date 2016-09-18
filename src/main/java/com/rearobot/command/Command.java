package com.rearobot.command;

/**
 *
 * @author Jagdeep Singh
 */
public abstract class Command {
    
    private CommandCode commandCode;
    
    /**
     * @return CommandCode
     */
    public CommandCode getCommandCode() {
        return commandCode;
    }

    /**
     * @param commandCode
     */
    public void setCommandCode(CommandCode commandCode) {
        this.commandCode = commandCode;
    }
}
