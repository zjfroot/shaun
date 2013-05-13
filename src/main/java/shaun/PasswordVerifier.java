package shaun;

import arlut.csd.crypto.MD5Crypt;

/**
 * Created with IntelliJ IDEA.
 * User: jifeng
 * Date: 5/13/13
 * Time: 10:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class PasswordVerifier {

    public static boolean verify(String hash, String inputPassword){
        return hash.equals(MD5Crypt.apacheCrypt(inputPassword, hash));
    }



    public static void main(String[] args) {
        boolean passwordOK = PasswordVerifier.verify("$apr1$RO......$WdRRJyNKCHsYa4rpv4DQL1","qetadgZCB01");
        System.out.println(passwordOK);
    }
}
