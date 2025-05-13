package Tree;

import Artist.Artist;
import Artist.ItemArtist;

public class ArtistTree {
  private KnotArtist root;
  private int totalNumKnots;

  public ArtistTree() {
    this.root = null;
    this.totalNumKnots = 0;
  }

  public KnotArtist getRoot() {
    return this.root;
  }
  public void setRoot(KnotArtist knot) {
    this.root = knot;
    this.totalNumKnots++;
  }

  public boolean isEmpty() {
    return (this.root == null);
  }

  public int getTotalNumKnots() {
    return this.totalNumKnots;
  }

  public boolean insertArtist(ItemArtist artist) {
    if (searchArtist(artist.getKey())) {
      // If the artist is already in the tree
      return false;
    }

    this.root = insertArtist(artist, this.root);
    this.totalNumKnots++;
    return true;
  }

  public KnotArtist insertArtist(ItemArtist newArtist, KnotArtist knot) {
    if (knot == null) {
      KnotArtist newKnot = new KnotArtist(newArtist);
      return newKnot;
    }

    int newArtistAge = newArtist.getKey().getAge();
    int knotAge = knot.getArtistInfo().getKey().getAge();

    if (newArtistAge < knotAge) {
      // If the age of the new artist is LESSER than the current knot's artist's age
      knot.setLeftKnot(insertArtist(newArtist, knot.getLeftKnot()));
      return knot;
    } else {
      // If the age of the new artist is GREATER THAN OR EQUAL to the current knot's artist's age
      knot.setRightKnot(insertArtist(newArtist, knot.getRightKnot()));
      return knot;
    }
  }

  public KnotArtist searchKnot(Artist key) {
    KnotArtist resultKnot = searchArtist(key, this.root);
    if (resultKnot != null) {
      // If the knot searched for was found
      return resultKnot;
    }

    return null;
  }

  public boolean searchArtist(Artist key) {
    if (searchArtist(key, this.root) != null) {
      // If the key searched for is already in the tree
      return true;
    }

    return false;
  }

  private KnotArtist searchArtist(Artist key, KnotArtist knot) {
    if (knot != null) {
      int keyAge = key.getAge();
      int knotAge = knot.getArtistInfo().getKey().getAge();

      if (keyAge < knotAge) {
        // If the age of the artist being searched for is LESSER than the current knot's artist's age
        knot = searchArtist(key, knot.getLeftKnot());
      } else {
        // If the age of the artist being searched for is GREATER THAN OR EQUAL to the current knot's artist's age
        knot = searchArtist(key, knot.getRightKnot());
      }
    }

    return knot;
  }

  public boolean removeArtist(Artist key) {
    if (searchArtist(key, this.root) != null) {
      this.root = removeArtist(key, this.root);
      this.totalNumKnots--;
      return true;
    }

    return false;
  }

  public KnotArtist removeArtist(Artist key, KnotArtist knot) {
    int keyAge = key.getAge();
    int knotAge = knot.getArtistInfo().getKey().getAge();

    if (keyAge < knotAge) {
      // If the age of the artist being removed is LESSER than the current knot's artist's age
      knot.setLeftKnot(removeArtist(key, knot.getLeftKnot()));
    } else {
      // If the age of the artist being removed is GREATER THAN OR EQUAL to the current knot's artist's age
      if (keyAge >= knotAge) {
        knot.setRightKnot(removeArtist(key, knot.getRightKnot()));
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

  private KnotArtist Arrange(KnotArtist knot, KnotArtist greaterKnot) {
    if (greaterKnot.getRightKnot() != null) {
      greaterKnot.setRightKnot(Arrange(knot, greaterKnot.getRightKnot()));
    } else {
      knot.setArtistInfo(greaterKnot.getArtistInfo());
      greaterKnot = greaterKnot.getLeftKnot();
    }

    return greaterKnot;
  }

  // Preorder Traversal of a Binary Tree
  public ItemArtist[] PreorderTraversal() {
    int[] n = new int[1];
    n[0] = 0;
    ItemArtist[] vector = new ItemArtist[this.totalNumKnots];
    return PerformPreorderTraversal(this.root, vector, n);
  }

  private ItemArtist[] PerformPreorderTraversal(KnotArtist knot, ItemArtist[] vector, int[] n) {
    if (knot != null) {
      vector[n[0]] = knot.getArtistInfo();
      n[0]++;
      vector = PerformPreorderTraversal(knot.getLeftKnot(), vector, n);
      vector = PerformPreorderTraversal(knot.getRightKnot(), vector, n);
    }

    return vector;
  }
}
