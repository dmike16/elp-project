package dmike.example;

public class State {
  private String name;
  private String abbr;
   
  public State(String abbr, String name) {
    super();
    this.name = name;
    this.abbr = abbr;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getAbbr() {
    return abbr;
  }
  public void setAbbr(String abbr) {
    this.abbr = abbr;
  }
  
  
}
