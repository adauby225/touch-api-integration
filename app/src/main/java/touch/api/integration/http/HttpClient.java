package touch.api.integration.http;

import java.util.Map;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import touch.api.integration.contants.Messages;

public class HttpClient {
	public HttpResponse<String> doPost(String url,String body, Map<String, String>headers) 
			throws invalidHeaderException, invalidUrlException {
		HttpResponse<String> response = null;
		try {
			checkUrl(url);
			checkHeaders(headers);
			response =  Unirest.post(url)
					.headers(headers)
					.basicAuth("MTN", "passer")
					.body(body)
					.asString();
		}catch(UnirestException e) {
			
		}
		return response;
	}
	
	public  HttpResponse<String> doGet(String url,Map<String, String>headers) 
			throws invalidHeaderException, invalidUrlException {
		HttpResponse<String> response = null;
		try {
			checkUrl(url);
			checkHeaders(headers);
			response =  Unirest.get(url)
					.headers(headers)
					.asString();
		}catch(UnirestException e) {
			
		}
		return response;
	}
	
	public HttpResponse<String> doPut(String url,Map<String, String>headers, String body) 
			throws invalidHeaderException, invalidUrlException {
		HttpResponse<String> response = null;
		try {
			checkUrl(url);
			checkHeaders(headers);
			response =  Unirest.put(url)
					.headers(headers)
					.body(body)
					.asString();
		}catch(UnirestException e) {
			
		}
		return response;
	} 
	
	public void checkHeaders(Map<String, String>headers) throws invalidHeaderException {
		if(headers == null)
			throw new invalidHeaderException(Messages.NULL_HTTP_HEADERS);
		for(Map.Entry<String, String>entry : headers.entrySet())
			if(entry.getValue() == null) {
				String msg = Messages.NULL_VALUE_FOR_KEY.replace("{KEY}", entry.getKey()); 
				throw new invalidHeaderException(msg);
			}
		
			
	}
	
	public void checkUrl(String url) throws invalidUrlException{
		if(url==null)
			throw new invalidUrlException(Messages.NULL_URL_VALUE);
		if(!url.startsWith("http://" ) && !url.startsWith("https://"))
			throw new invalidUrlException(Messages.INVALID_URL);
		
	}

}
