import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Event {
    int id;
    String name;
    String shortDesc;
    String logText;
    List<Locations> locations = new ArrayList<Locations>();

    HashMap<Integer,String> responses = new HashMap<Integer,String>(); // Integer is the event ID the response maps to.
    HashMap<ResultType,String> results = new HashMap<ResultType,String>();


    public Event(){

    }

    public Event(int id, String name, String shortDesc, String logText, HashMap<Integer, String> responses, HashMap<ResultType, String> results) {
        this.id = id;
        this.name = name;
        this.shortDesc = shortDesc;
        this.logText = logText;
        this.responses = responses;
        this.results = results;
    }
}
