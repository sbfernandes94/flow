package flow;

public interface IApp<T> {
  T in(IEvent event) throws AppException, EventException, ProtocolException, ActionException;
}
