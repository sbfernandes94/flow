package flow;

import java.util.List;

public interface IAgent {
  List<IAction> act() throws AgentException;
}