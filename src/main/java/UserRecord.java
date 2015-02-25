
import java.util.Date;

public class UserRecord extends User {

    private Date timeStamp;

    public UserRecord(String name, Date timeStamp) {
        super(name);
        this.timeStamp = timeStamp;
    }

}
