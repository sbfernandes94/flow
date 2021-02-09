package flow.samples;

import flow.ActionException;
import flow.EventException;
import flow.IApp;
import flow.IEvent;

import java.util.LinkedList;

public class TextApp implements IApp<String> {
	private LinkedList<String> responses;

	public TextApp() {
		responses = new LinkedList<String>();
	}

	public String in(IEvent event) throws EventException, ActionException {
		String request = (String) event.trigger();
		String response = makeResponse(request);
		responses.add(response);
		return response;
	}

	private String makeResponse(String request) {
		String value = request.replace("Request:", "");
		return "ACK:" + value;
	}

	public String popResponse() {
		return responses.remove();
	}

	public boolean contains(String value) {
		return responses.contains(value);
	}

}
