package shaun.util;

import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: jifeng
 * Date: 5/13/13
 * Time: 9:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class HtpasswdParser {

    private Map<String, String> userMap;

    public Map<String, String> parse(){
        userMap = new HashMap<String, String>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(HtpasswdFileHolder.reload());
            Scanner scanner = new Scanner(fis);

            while(scanner.hasNextLine()){
                String [] pair = scanner.nextLine().split(":");
                userMap.put(pair[0],pair[1]);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return userMap;
    }
}
