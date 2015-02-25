import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import static org.hamcrest.CoreMatchers.*;

public class TestCustomSerializer {
    @Test
    public void testCustomerSerializerForDate(){
        Assert.assertThat(convertToJsonFromSampleObject(), is("{\"timeStamp\":\"2015-02-26 00:00:00\",\"name\":\"Jack\"}"));
    }

    private String convertToJsonFromSampleObject(){
        Gson gson = buildGsonWithCustomSerializer();
        return gson.toJson(new UserRecord("Jack", getSampleDate()));
    }

    private Gson buildGsonWithCustomSerializer() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new ShortDateFormatAdapter());
        return builder.create();
    }

    private Date getSampleDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, 1, 26, 0, 0, 0);
        return calendar.getTime();
    }

}
