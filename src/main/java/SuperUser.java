import java.util.ArrayList;
import java.util.List;

public class SuperUser extends User {

    private List<User> children = new ArrayList<User>();

    SuperUser(String name){
        super(name);
    }

    public void addChild(User user){
        this.children.add(user);
    }
}
