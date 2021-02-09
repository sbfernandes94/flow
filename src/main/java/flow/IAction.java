package flow;

public interface IAction<T> {
  T execute() throws ActionException;

  String getType();
}
