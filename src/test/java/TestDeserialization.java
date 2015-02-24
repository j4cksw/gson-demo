import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nitorcreations.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;

public class TestDeserialization {

    private Gson gson;

    @Before
    public void setup(){
        gson = new Gson();
    }

    @Test
    public void TestDeserializeToObject(){
        ReflectionAssert.assertReflectionEquals(gson.fromJson("{\"name\":\"Jack\"}", User.class), new User("Jack"));
    }

    @Test
    public void TestDeserializeToList(){
        Type type = new TypeToken<ArrayList<User>>(){}.getType();

        ArrayList<User> expected = new ArrayList<User>();
        expected.add(new User("Jack"));
        expected.add(new User("Bill"));

        ArrayList<User> actual = gson.fromJson("[{\"name\":\"Jack\"}, {\"name\":\"Bill\"}]", type);

        ReflectionAssert.assertReflectionEquals(actual, expected);
    }

    @Test
    public void TestDeserializeToMap(){
        Type type = new TypeToken<HashMap<String, String>>(){}.getType();
        HashMap<String, String> expected = new HashMap<String, String>();
        expected.put("name", "Jack");

        ReflectionAssert.assertReflectionEquals(gson.fromJson("{\"name\":\"Jack\"}", type), expected);
    }

    @Test
    public void TestDeserializeToObjectWithList(){
        SuperUser superUser = new SuperUser("Jack");
        superUser.addChild(new User("Bill"));

        ReflectionAssert.assertReflectionEquals(gson.fromJson("{\"name\":\"Jack\", \"children\": [{\"name\":\"Bill\"}]}", SuperUser.class), superUser);
    }

}
