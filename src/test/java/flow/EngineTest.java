package flow;

import flow.samples.TextAdapter;
import flow.samples.TextAgent;
import flow.samples.TextApp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

@RunWith(JUnit4.class)
public class EngineTest {
	private Engine engine;

	@Test(expected = EmptyFlowException.class)
	public void testRun_FlowIsEmpty_ThrowEmptyFlowException() throws Exception {
		engine = new Engine(mock(IAgent.class), mock(Map.class), mock(IApp.class));
		engine.run();
	}

	@Test(expected = AdapterNotFoundException.class)
	public void testRun_AdapterDoesNotExist_ThrowAdapterNotFoundException() throws Exception {
		engine = new Engine(new TextAgent("msg"), mock(Map.class), mock(IApp.class));
		engine.run();
	}

	@Test
	public void testRun_FlowHasThreeActions_ReturnAcknowledgedResponses() throws Exception {
		Map<String, IAdapter> adapters = new HashMap();
		adapters.put("TEXT", new TextAdapter());
		engine = new Engine(new TextAgent("msg1", "msg2", "msg3"), adapters, new TextApp());
		engine.run();
		TextApp textApp = (TextApp) engine.getApp();
		Assert.assertEquals("ACK:msg1", textApp.popResponse());
		Assert.assertEquals("ACK:msg2", textApp.popResponse());
		Assert.assertEquals("ACK:msg3", textApp.popResponse());
	}

	
	@Test
	public void codeChallenge() throws Exception {
		String value = "hello";
		Map<String, IAdapter> adapters = new HashMap();
		adapters.put("TEXT", new TextAdapter());
		engine = new Engine(new TextAgent(value), adapters, new TextApp());
		engine.run();
		TextApp textApp = (TextApp) engine.getApp();
		assertTrue(textApp.contains("ACK:"+ value));
	}

}