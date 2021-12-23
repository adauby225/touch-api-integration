package touch.api.integration;

public interface Wallet {

	void doCachout(String data);

	void doCashin(String data);

	void doPayment(String data);

}
