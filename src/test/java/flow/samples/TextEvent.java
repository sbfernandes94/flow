package flow.samples;

import flow.IEvent;

public class TextEvent implements IEvent<String> {
  private String value;

  public TextEvent(String value) {
    this.value = value;
  }

  public String trigger() {
    return "Request:" + value;
  }
}
