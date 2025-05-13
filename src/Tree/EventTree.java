package Tree;

import Event.Event;
import Event.ItemEvent;

public class EventTree {
  private KnotEvent root;
  private int totalNumKnots;

  public EventTree() {
    this.totalNumKnots = 0;
    this.root = null;
  }

  public KnotEvent getRoot() {
    return this.root;
  }
  public void setRoot(KnotEvent knot) {
    this.root = knot;
    this.totalNumKnots++;
  }

  public boolean isEmpty() {
    return (this.root == null);
  }

  public int getTotalNumKnots() {
    return this.totalNumKnots;
  }

  public boolean insertEvent(ItemEvent event) {
    if (searchEvent(event.getKey())) {
      // If the event is already in the tree
      return false;
    }

    this.root = insertEvent(event, this.root);
    this.totalNumKnots++;
    return true;
  }

  public KnotEvent insertEvent(ItemEvent newEvent, KnotEvent knot) {
    if (knot == null) {
      KnotEvent newKnot = new KnotEvent(newEvent);
      return newKnot;
    }

    int newEventYear = newEvent.getKey().getYear();
    int knotYear = knot.getEventInfo().getKey().getYear();

    if (newEventYear < knotYear) {
      // If the year of the event being created is LESSER than the current knot's event's year
      knot.setLeftKnot(insertEvent(newEvent, knot.getLeftKnot()));
      return knot;
    } else {
      // If the year of the event being created is GREATER THAN OR EQUAL to the current knot's event's year
      knot.setRightKnot(insertEvent(newEvent, knot.getRightKnot()));
      return knot;
    }
  }

  public boolean searchEvent(Event key) {
    if (searchEvent(key, this.root) != null) {
      // If the key searched for is already in the tree
      return true;
    }

    return false;
  }

  public KnotEvent searchEvent(Event key, KnotEvent knot) {
    if (knot != null) {
      int keyYear = key.getYear();
      int knotYear = knot.getEventInfo().getKey().getYear();

      if (keyYear < knotYear) {
        // If the year of the event being searched for is LESSER than the current knot's event's year
        knot = searchEvent(key, knot.getLeftKnot());
      } else {
        // If the year of the event being searched for is GREATER THAN OR EQUAL to the current knot's event's year
        knot = searchEvent(key, knot.getRightKnot());
      }
    }

    return knot;
  }

  public boolean removeEvent(Event key) {
    if (searchEvent(key, this.root) != null) {
      this.root = removeEvent(key, this.root);
      this.totalNumKnots--;
      return true;
    }

    return false;
  }

  public KnotEvent removeEvent(Event key, KnotEvent knot) {
    int keyYear = key.getYear();
    int knotYear = knot.getEventInfo().getKey().getYear();

    if (keyYear < knotYear) {
      // If the year of the event being removed is LESSER than the current knot's event's year
      knot.setLeftKnot(removeEvent(key, knot.getLeftKnot()));
    } else {
      // If the year of the event being removed is GREATER THAN OR EQUAL to the current knot's event's year
      if (keyYear >= knotYear) {
        knot.setRightKnot(removeEvent(key, knot.getRightKnot()));
      } else {
        // In case the knot is null, it falls inside this condition
        if (knot.getRightKnot() == null) {
          return knot.getLeftKnot();
        } else if (knot.getLeftKnot() == null) {
          return knot.getRightKnot();
        } else {
          knot.setLeftKnot(Arrange(knot, knot.getLeftKnot()));
        }
      }
    }

    return knot;
  }

  private KnotEvent Arrange(KnotEvent knot, KnotEvent greaterKnot) {
    if (greaterKnot.getRightKnot() != null) {
      greaterKnot.setRightKnot(Arrange(knot, greaterKnot.getRightKnot()));
    } else {
      knot.setEventInfo(greaterKnot.getEventInfo());
      greaterKnot = greaterKnot.getLeftKnot();
    }

    return greaterKnot;
  }

  // Preorder Traversal of a Binary Tree
  public ItemEvent[] PreorderTraversal() {
    int[] n = new int[1];
    n[0] = 0;
    ItemEvent[] vector = new ItemEvent[this.totalNumKnots];
    return PerformPreorderTraversal(this.root, vector, n);
  }

  private ItemEvent[] PerformPreorderTraversal(KnotEvent knot, ItemEvent[] vector, int[] n) {
    if (knot != null) {
      vector[n[0]] = knot.getEventInfo();
      n[0]++;
      vector = PerformPreorderTraversal(knot.getLeftKnot(), vector, n);
      vector = PerformPreorderTraversal(knot.getRightKnot(), vector, n);
    }

    return vector;
  }
}
