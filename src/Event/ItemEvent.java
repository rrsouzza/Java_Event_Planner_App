package Event;

/*
 * The ItemEvent class represents the item stored in an Event tree's knot.
 * Each item has an unique key, which in this case is an Event object.
*/

public class ItemEvent {
  private Event key;

  //Builder Method
  public ItemEvent(Event key) {
    this.key = key;
  }

  public Event getKey() {
    return this.key;
  }
  public void setKey(Event newKey) {
    this.key = newKey;
  }
}
