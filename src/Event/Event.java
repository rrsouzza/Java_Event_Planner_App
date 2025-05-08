package Event;
import java.util.ArrayList;

import Artist.Artist;

public class Event {
  private String title;
  private String location;
  private int year;
  private ArrayList<Artist> attendingArtists;

  // Builder Method 1
  public Event(String title, String location, int year) {
    this.title = title;
    this.location = location;
    this.year = year;
    this.attendingArtists = new ArrayList<Artist>();
  }

  // Builder Method 2
  public Event(String title, String location, int year, ArrayList<Artist> attendingArtists) {
    this.title = title;
    this.location = location;
    this.year = year;
    this.attendingArtists = attendingArtists;
  }

  public String getTitle() {
    return this.title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  public String getLocation() {
    return this.location;
  }
  public void setLocation(String location) {
    this.location = location;
  }

  public int getYear() {
    return this.year;
  }
  public void setYear(int year) {
    this.year = year;
  }

  public ArrayList<Artist> getAttendingArtists() {
    return this.attendingArtists;
  }
  public void setAttendingArtists(ArrayList<Artist> attendingArtists) {
    this.attendingArtists = attendingArtists;
  }

  public boolean addAttendingArtist(Artist newArtist) {
    return this.attendingArtists.add(newArtist);
  }
  public boolean removeAttendingArtist(Artist artist) {
    return this.attendingArtists.remove(artist);
  }
}
