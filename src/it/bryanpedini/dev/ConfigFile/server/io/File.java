package it.bryanpedini.dev.ConfigFile.server.io;

import it.bryanpedini.dev.ConfigFile.server.exceptions.UninitializedObjectException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Bryan Pedini
 * @version A_1.0
 */
public class File {
    private java.io.File file;
    private BufferedReader br;
    private BufferedWriter bw;
    
    public File(String path) {
        this.file = new java.io.File(path);
    }
    
    public ArrayList<String> read() throws UninitializedObjectException {
        if(this.file == null) throw new UninitializedObjectException();
        try {
            this.br = new BufferedReader(new FileReader(this.file));
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> res = new ArrayList();
        try {
            String str = this.br.readLine();
            while(str != null) {
                res.add(str);
                str = this.br.readLine();
            }
        }
        catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public void write(ArrayList<String> toFile) throws UninitializedObjectException {
        if(this.file == null) throw new UninitializedObjectException();
        try {
            this.bw = new BufferedWriter(new FileWriter(this.file));
        }
        catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            for (String str : toFile) {
                this.bw.append(str);
                this.bw.newLine();
            }
            this.bw.flush();
        }
        catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
