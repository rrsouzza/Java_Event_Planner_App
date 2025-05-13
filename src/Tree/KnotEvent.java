package Tree;

import Event.ItemEvent;

/*
 * The KnotEvent class represents a knot in the Event Tree.
*/

public class KnotEvent {
  private ItemEvent eventInfo;
  private KnotEvent leftKnot, rightKnot;

  // Builder Method
  public KnotEvent(ItemEvent eventInfo) {
    this.eventInfo = eventInfo;
    this.leftKnot = null;
    this.rightKnot = null;
  }

  public KnotEvent getLeftKnot() {
    return this.leftKnot;
  }
  public void setLeftKnot(KnotEvent knot) {
    this.leftKnot = knot;
  }

  public KnotEvent getRightKnot() {
    return this.rightKnot;
  }
  public void setRightKnot(KnotEvent knot) {
    this.rightKnot = knot;
  }

  public ItemEvent getEventInfo() {
    return this.eventInfo;
  }
  public void setEventInfo(ItemEvent eventInfo) {
    this.eventInfo = eventInfo;
  }
}
