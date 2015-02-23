import java.util.ArrayList;
import java.util.List;

/**
 * Created by JackSW on 2/23/15 AD.
 */
public class SuperUser extends User {

    private List<User> children = new ArrayList<User>();

    SuperUser(String name){
        super(name);
    }

    public void addChild(User user){
        this.children.add(user);
    }
}
