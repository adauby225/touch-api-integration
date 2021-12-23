package touch.api.integration.tools;

import java.util.HashMap;
import java.util.Map;

public class DefaultHeaderBuilder {
	private static Map<String, String>defautHeaders = new HashMap<String, String>();
	static {
		defautHeaders.put("Content-Type", "application/json; charset=UTF-8");
		defautHeaders.put("Accept","\"application/json; charset=UTF-8\"");
	}
	public static Map<String, String> getDefaultHeaders() {
		
		return defautHeaders;
	}

}
