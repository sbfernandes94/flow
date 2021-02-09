package flow;

public interface IAdapter<IAction> {
  IEvent adapt(IAction action) throws AdapterException, ActionException;
}
