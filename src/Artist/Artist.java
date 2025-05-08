package Artist;
import java.util.ArrayList;

import Event.Event;

public class Artist {
  private String name;
  private int age;
  private ArrayList<Event> associatedEvents;

  // Builder Method 1
  public Artist(String name, int age) {
    this.name = name;
    this.age = age;
    this.associatedEvents = new ArrayList<Event>();
  }

  // Builder Method 2
  public Artist(String name, int age, ArrayList<Event> associatedEvents) {
    this.name = name;
    this.age = age;
    this.associatedEvents = associatedEvents;
  }

  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return this.age;
  }
  public void setAge(int age) {
    this.age = age;
  }

  public ArrayList<Event> getAssociatedEvents() {
    return this.associatedEvents;
  }
  public void setAssociatedEvents(ArrayList<Event> associatedEvents) {
    this.associatedEvents = associatedEvents;
  }

  public boolean addAssociatedEvent(Event newEvent) {
    return this.associatedEvents.add(newEvent);
  }
  public boolean removeAssociatedEvent(Event event) {
    return this.associatedEvents.remove(event);
  }
}