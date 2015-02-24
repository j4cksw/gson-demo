import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;

public class TestSerialization {

    private Gson gson;

    @Before
    public void setup(){
        gson = new Gson();
    }

    @Test
    public void TestSerializeObject(){
        User user = new User("Jack");

        Assert.assertThat(gson.toJson(user), is("{\"name\":\"Jack\"}"));
    }

    @Test
    public void TestSerializeList(){
        List<User> users = new ArrayList<User>();
        users.add(new User("Jack"));
        users.add(new User("Bill"));

        Assert.assertThat(gson.toJson(users), is("[{\"name\":\"Jack\"},{\"name\":\"Bill\"}]"));
    }

    @Test
    public void TestSerializeObjectWithList(){
        SuperUser superUser = new SuperUser("Jack");
        superUser.addChild(new User("Bill"));

        Assert.assertThat(gson.toJson(superUser), is("{\"children\":[{\"name\":\"Bill\"}],\"name\":\"Jack\"}"));
    }
}
