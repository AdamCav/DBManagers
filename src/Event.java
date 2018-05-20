import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Event {
    int id;
    String name;
    String shortDesc;
    String logText;
    HashMap<Integer,String> responses = new HashMap<Integer,String>(); // Integer is the event ID the response maps to.
    HashMap<ResultType,String> results = new HashMap<ResultType,String>();

    public Event(){

    }

}
