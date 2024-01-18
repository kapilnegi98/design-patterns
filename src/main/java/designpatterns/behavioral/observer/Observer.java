package designpatterns.behavioral.observer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kapil Negi
 */

class EventManager{
   private Map<String, List<EventListener>> eventListenersMap;
    public EventManager(String... eventTypes){
        this.eventListenersMap = new HashMap<>();
        for(String event: eventTypes){
            eventListenersMap.put(event, new ArrayList<>());
        }
    }
    void subscribe(String eventType, EventListener eventListener){
        List<EventListener> listeners = eventListenersMap.get(eventType);
        listeners.add(eventListener);
    }
    void unSubscribe(String eventType, EventListener eventListener){
        List<EventListener> listeners = eventListenersMap.get(eventType);
        listeners.remove(eventListener);
    }

    void notify(String eventType, File file){
        List<EventListener> listeners = eventListenersMap.get(eventType);
        for(EventListener listener: listeners){
            listener.update(eventType, file);
        }
    }
}
interface EventListener{
    void update(String eventType, File file);
}

class EmailNotificationListener implements EventListener{
    private String email;
    public EmailNotificationListener(String email){
        this.email = email;
    }
    @Override
    public void update(String eventType, File file) {
        System.out.println("File has change "+ file.getName()  +"Sending email to " + email);
    }
}
class LogOpenListener implements EventListener {
    private File log;

    public LogOpenListener(String fileName) {
        this.log = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Save to log " + log + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
    }
}

public class Observer {
    public static void main(String[] args) {
        List<String> events = new ArrayList<>();

        EventManager eventManager = new EventManager("open", "save");
        eventManager.subscribe("open",  new EmailNotificationListener("kapil"));
        eventManager.notify("open", new File("xyz"));
    }

}
