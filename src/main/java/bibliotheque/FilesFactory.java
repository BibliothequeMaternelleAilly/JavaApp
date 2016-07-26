
package bibliotheque;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shiro
 */
public class FilesFactory {

    public static File getResFile(String path) {
        return new File(FilesFactory.class.getClassLoader().getResource(path).getFile());
    }
    
    public static InputStream getResStream(String path) {
        return FilesFactory.class.getClassLoader().getResourceAsStream(path);
    }
    
    public static List<String> getContentOfRes(String path) {
        List list = new ArrayList();
        InputStream in = FilesFactory.class.getClassLoader().getResourceAsStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        
        String line;
        try {
            while((line = reader.readLine()) != null)
                list.add(line);
        } catch (IOException ex) {
            Logger.getLogger(FilesFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public static boolean fileExists(String path) {
        return Files.exists(Paths.get(path), LinkOption.values());
    }
    
    public static String getLine(int nbr, String path) {
        try {
            return Files.readAllLines(Paths.get(path)).get(nbr);
        } catch (IOException ex) {
            Logger.getLogger(FilesFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static List<String> getAllLines(String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException ex) {
            Logger.getLogger(FilesFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void createFile(String path, String content) {
        try {
            Files.deleteIfExists(Paths.get(path));
            Files.createFile(Paths.get(path));
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(FilesFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
