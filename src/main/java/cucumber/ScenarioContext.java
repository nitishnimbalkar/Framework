package cucumber;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
	private Map<String, String> scenarioContext;

	public ScenarioContext() {
		scenarioContext = new HashMap<String, String>();
	}

	public String getContext(String key) {
		return scenarioContext.get(key);
	}

	public void setContext(String key, String value) {
		scenarioContext.put(key, value);
	}

	public boolean contains(String key) {
		return scenarioContext.containsKey(key);
	}
}
