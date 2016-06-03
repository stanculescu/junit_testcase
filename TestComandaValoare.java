package ro.ase.cts.project.testcase;

import java.util.ArrayList;

import junit.framework.TestCase;
import ro.ase.cts.project.ApaFactory;
import ro.ase.cts.project.InterfataApa;
import ro.ase.cts.project.TipApa;
import ro.ase.cts.project.model.Client;
import ro.ase.cts.project.model.Comanda;
import ro.ase.cts.project.state.Inregistrata;

public class TestComandaValoare extends TestCase {
	Comanda comanda;

	public TestComandaValoare(String name) {
		super(name);
		
		
	}

	protected void setUp() throws Exception {
		super.setUp();
		
		System.out.println("Pregatire test");
		ApaFactory apaFactory=new ApaFactory();
		InterfataApa apa1=apaFactory.getApa(TipApa.L11, 1);
		InterfataApa apa2=apaFactory.getApa(TipApa.L5, 2);
		
		
		ArrayList<InterfataApa> listaProduse=new ArrayList<>();
		listaProduse.add(apa1);
		listaProduse.add(apa2);
		Client client=new Client("Ionescu", "Str. Libertatii nr 3", "0738547239", 5);
		comanda=new Comanda(listaProduse,"25/05/2016",client,new Inregistrata());
		
		//ArrayList<InterfataApa> lista=new ArrayList<>();
//		ApaFactory apaFactory=new ApaFactory();
//		InterfataApa apa1=apaFactory.getApa(TipApa.L11, 1);
//		InterfataApa apa2=apaFactory.getApa(TipApa.L5, 2);
//		lista.add(apa1);
//		lista.add(apa2);
//		
//		Client client=new Client("Ionescu", "Str. Libertatii nr 3", "0738547239", 5);
//		String data="24/05/2016";
//		comanda=new Comanda(lista,data,client, new Inregistrata());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		System.out.println("Test terminat");
		comanda = null;
	}

	public void testValoareAcceptata() {
		float valoare = 50;
		comanda.setValoare(valoare);
		assertEquals("Verificare setValoare cu valori normale",
				valoare, comanda.getValoare());
	}
	public void testValoareAcceptataMinima() {
		float valoare = 30;
		comanda.setValoare(valoare);
		assertEquals("Verificare setValoare cu valori minime",
				valoare, comanda.getValoare());
	}
	public void testValoareNeacceptata(){
		float valoare = 15;
		try{
			comanda.setValoare(valoare);
			fail("Accepta valoare < 30");
			}
			catch(Exception e){
				
			}
	}
}
