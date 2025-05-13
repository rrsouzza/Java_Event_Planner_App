package Tree;

import Artist.ItemArtist;

/*
 * The KnotArtist class represents a knot in the Artist Tree.
*/

public class KnotArtist {
  private ItemArtist artistInfo;
  private KnotArtist leftKnot, rightKnot;

  // Builder Method
  public KnotArtist(ItemArtist artistInfo) {
    this.artistInfo = artistInfo;
    this.leftKnot = null;
    this.rightKnot = null;
  }

  public KnotArtist getLeftKnot() {
    return this.leftKnot;
  }
  public void setLeftKnot(KnotArtist knot) {
    this.leftKnot = knot;
  }

  public KnotArtist getRightKnot() {
    return this.rightKnot;
  }
  public void setRightKnot(KnotArtist knot) {
    this.rightKnot = knot;
  }

  public ItemArtist getArtistInfo() {
    return this.artistInfo;
  }
  public void setArtistInfo(ItemArtist artistInfo) {
    this.artistInfo = artistInfo;
  }
}
