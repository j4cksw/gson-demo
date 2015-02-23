import com.google.gson.Gson;
import com.nitorcreations.Matchers;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class TestDeserialization {
    @Test
    public void TestDeserializeToOject(){
        Gson gson = new Gson();

        Assert.assertThat(gson.fromJson("{\"name\":\"Jack\"}", User.class), Matchers.reflectEquals(new User("Jack")));
    }
}
