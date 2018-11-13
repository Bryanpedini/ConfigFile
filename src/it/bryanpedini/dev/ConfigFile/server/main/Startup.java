package it.bryanpedini.dev.ConfigFile.server.main;

import it.bryanpedini.dev.ConfigFile.server.config.Global_Configs;
import it.bryanpedini.dev.ConfigFile.server.exceptions.UninitializedObjectException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Bryan Pedini
 * @version A_1.1
 */
public class Startup {
    /**
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        if(Arrays.asList(args).contains("--config-file") && Arrays.asList(args).get(Arrays.asList(args).indexOf("--config-file")+1) != null) {
            Global_Configs.config_path = Arrays.asList(args).get(Arrays.asList(args).indexOf("--config-file")+1);
        }
        Global_Configs configs = new Global_Configs();
        try {
            System.out.println(configs.read("myText"));
        }
        catch (UninitializedObjectException ex) {
            Logger.getLogger(Startup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
