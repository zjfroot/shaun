package shaun;

/**
 * Created with IntelliJ IDEA.
 * User: jifeng
 * Date: 5/13/13
 * Time: 9:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String username;

    private String hash;

    public User(String username, String hash) {
        this.username = username;
        this.hash = hash;
    }

    public String getUsername() {
        return username;
    }

    public String getHash() {
        return hash;
    }
}
