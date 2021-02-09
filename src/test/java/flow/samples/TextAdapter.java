package flow.samples;

import flow.*;

public class TextAdapter implements IAdapter<IAction> {
  public IEvent adapt(IAction action) throws ActionException {
    String value = (String) action.execute();
    return new TextEvent(value);
  }
}
