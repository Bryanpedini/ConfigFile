package it.bryanpedini.dev.ConfigFile.server.config;

import it.bryanpedini.dev.ConfigFile.server.exceptions.UninitializedObjectException;
import it.bryanpedini.dev.ConfigFile.server.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Bryan Pedini
 * @version A_1.0
 */
public class Global_Configs {
    private final ArrayList<String> KEYS = new ArrayList();
    private final ArrayList<String> VALUES = new ArrayList();
    private final String CONFIG_PATH = "server.properties";
    
    public Global_Configs() {
        try {
            ArrayList<String> tmp = new File(this.CONFIG_PATH).read();
            for (String str : tmp) {
                this.KEYS.add(str.substring(0, str.indexOf("=")));
                this.VALUES.add(str.substring(str.indexOf("=")+1));
            }
        }
        catch (UninitializedObjectException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Get config value.
     * @param key Config key.
     * @return Config value.
     * @throws it.bryanpedini.dev.ConfigFile.server.exceptions.UninitializedObjectException
     */
    public String read(String key) throws UninitializedObjectException {
        //if(this.CONFIG_PATH == null || this.KEYS.isEmpty() || this.VALUES.isEmpty()) throw new UninitializedObjectException();
        return this.VALUES.get(this.KEYS.indexOf(key));
    }
}
