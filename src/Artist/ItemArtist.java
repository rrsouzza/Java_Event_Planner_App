package Artist;

/*
 * The ItemArtist class represents the item stored in an Artist tree's knot.
 * Each item has an unique key, which in this case is an Artist object.
*/

public class ItemArtist {
  private Artist key;

  // Builder Method
  public ItemArtist(Artist key) {
    this.key = key;
  }

  public Artist getKey() {
    return this.key;
  }
  public void setKey(Artist newKey) {
    this.key = newKey;
  }
}
