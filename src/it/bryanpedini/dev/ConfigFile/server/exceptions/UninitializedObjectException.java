package it.bryanpedini.dev.ConfigFile.server.exceptions;

/**
 * Uninitialized Object Exception thrown in initialization checks.<br>
 * Normally not thrown unless a checked method is called without calling the constructor first.
 * @author Bran Pedini
 * @version A_1.1
 */
public class UninitializedObjectException extends Exception {
    @Override
    public String getMessage() {
        return "Unable to execute the called method: the parent object was not initialized.";
    }
}
