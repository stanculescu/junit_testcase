package ro.ase.cts.project.testcase;

import junit.framework.TestCase;

import ro.ase.cts.project.model.Client;

public class TestClient extends TestCase {
	public TestClient(){
		System.out.println(
				"Initializare TestCase");
	}

	Client client;
	protected void setUp() {
		System.out.println("Pregatire test");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testareNumeNull(){
		
		System.out.println("Inceput test nume");
		String nume = null;
		try {
			Client c = 
					new Client(nume,null, null, 0);
			fail("Constructor implementat gresit pentru null");
		} catch (Exception e) {
			//e.printStackTrace();
		}		
	}
	
	public void testareNumar(){
		System.out.println("Inceput test numar telefon");
		String nr="o756546hu8";
		try{
			Client client=new Client();
			client.setTelefon(nr);
			fail("Numarul de telefon nu poate contine litere");
		}catch(Exception ex){
			
		}
	}
	
	public void testareNumeCifre(){
		System.out.println("Inceput test nume");
		String nume="Ion3e3";
		try{
			Client client=new Client();
			client.setNume(nume);
			fail("Numele nu poate contine cifre");
		}catch(Exception ex){
			
		}
	}
}
