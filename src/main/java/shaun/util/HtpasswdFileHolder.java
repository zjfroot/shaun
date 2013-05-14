package shaun.util;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: jifzh
 * Date: 5/14/13
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class HtpasswdFileHolder {

    public static File htpasswdFile;
    private static String path;

    public static void setFile(String filePath){
        path = filePath;
        htpasswdFile = new File(filePath);
    }

    public static File getFile(){
        return htpasswdFile;
    }

    public static String getPath(){
        return path;
    }

    public static File reload(){
        htpasswdFile = new File(path);
        return htpasswdFile;
    }
}
