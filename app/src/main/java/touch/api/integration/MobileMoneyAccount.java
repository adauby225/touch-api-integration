package touch.api.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kong.unirest.HttpResponse;
import touch.api.integration.http.HttpClient;
import touch.api.integration.http.invalidHeaderException;
import touch.api.integration.http.invalidUrlException;
import touch.api.integration.tools.DefaultHeaderBuilder;

public class MobileMoneyAccount implements Wallet {

	private final Logger logger = LogManager.getLogger(MobileMoneyAccount.class);
	private final HttpClient httpClient = new HttpClient();
	private String cashinUrl = "https://dev-api.rec-gutouch.com/v1/agency_code/cashin";
	private String cashoutUrl = "https://dev-api.rec-gutouch.com/v1/agency_code/cashout_request";
	private String paymentUrl = "";
	@Override
	public void doCachout(String bodyRequest) {
		try {
			logger.info("[CASHOUT][x][REQUEST] - body request: {}", bodyRequest);
			HttpResponse<String>response  = httpClient.doPost(cashoutUrl, bodyRequest, DefaultHeaderBuilder.getDefaultHeaders());
			logger.info("[CASHOUT][x][RESPONSE] - status : {}, body response : {}", response.getStatus(), response.getBody());
		} catch (invalidHeaderException | invalidUrlException e) {
			logger.error("[CAHSOUT][x][EXCEPTION DETAILS] - Cause : {}, message : {} ", e.getCause(), e.getMessage());
		}

	}

	@Override
	public void doCashin(String bodyRequest) {
		try {
			logger.info("[CASHIN][x][REQUEST] - body request : {}", bodyRequest);
			HttpResponse<String> response = httpClient.doPost(cashinUrl, bodyRequest, DefaultHeaderBuilder.getDefaultHeaders());
			logger.info("[CASHIN][x][RESPONSE] - status : {}, body response : {}", response.getStatus(), response.getBody());
		} catch (invalidHeaderException | invalidUrlException e) {
			logger.error("[CAHSIN][x][EXCEPTION DETAILS] - Cause : {}, message : {} ", e.getCause(), e.getMessage());
		}catch(Exception e) {
			logger.error("[CAHSIN][x][EXCEPTION DETAILS] - Cause : {}, message : {} ", e.getCause(), e.getMessage());
		}

	}

	@Override
	public void doPayment(String bodyRequest) {
		try {
			logger.info("[PAYMENT][x][REQUEST] - body request : {}", bodyRequest);
			HttpResponse<String> response = httpClient.doPost(paymentUrl, bodyRequest, DefaultHeaderBuilder.getDefaultHeaders());
			logger.info("[PAYMENT][x][RESPONSE] - status : {}, body response : {}", response.getStatus(), response.getBody());
		} catch (invalidHeaderException | invalidUrlException e) {
			logger.error("[PAYMENT][x][EXCEPTION DETAILS] - Cause : {}, message : {} ", e.getCause(), e.getMessage());
		}catch(Exception e) {
			logger.error("[PAYMENT][x][EXCEPTION DETAILS] - Cause : {}, message : {} ", e.getCause(), e.getMessage());
		}

	}

}
