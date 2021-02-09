package flow;

public interface IEvent<T> {
  T trigger() throws EventException, ActionException;
}
