package shaun.util;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: jifzh
 * Date: 5/14/13
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class HtpasswdUpdater {

    public static void updatePassword(String username, String newPassword){
        try {
            Runtime.getRuntime().exec("htpasswd -mb "+HtpasswdFileHolder.getPath() + " " + username + " "+ newPassword);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
