package ro.ase.cts.project.testcase;

import java.util.ArrayList;

import junit.framework.TestCase;

import ro.ase.cts.project.ApaFactory;
import ro.ase.cts.project.InterfataApa;
import ro.ase.cts.project.TipApa;
import ro.ase.cts.project.model.Client;
import ro.ase.cts.project.model.Comanda;
import ro.ase.cts.project.state.Inregistrata;

public class TestComandaConstructor extends TestCase {
	Comanda comanda;

	
	public TestComandaConstructor(String  comanda) {
		super(comanda);
		
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testConstructorValoriNormale() {
		ArrayList<InterfataApa> lista=new ArrayList<>();
		ApaFactory apaFactory=new ApaFactory();
		InterfataApa apa1=apaFactory.getApa(TipApa.L11, 1);
		InterfataApa apa2=apaFactory.getApa(TipApa.L5, 2);
		lista.add(apa1);
		lista.add(apa2);
		
		float val=0;
		for(InterfataApa a:lista){
			val+=a.getPret();
		}
		Client client;
		try {
			
			client = new Client("Ionescu", "Str. Libertatii nr 3", "0738547239", 5);
			comanda = new Comanda(lista,"24/05/2016",client,new Inregistrata());
			assertEquals("Verificare constructor client"
					,client,comanda.getClient());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String data="24/05/2016";
		
		assertEquals("Verificare constructor nume"
				,lista,comanda.getListaProduse());
		assertEquals("Verificare constructor valoare"
				,val,comanda.getValoare());
		assertEquals("Verificare constructor data"
				,data,comanda.getDataLivrare());
		
	}
	public void testConstructorProduseNull() {
		ArrayList<InterfataApa> lista=null;
		float val=0;
		
		String data="24/05/2016";
		try{
		Client client=new Client("Ionescu", "Str. Libertatii nr 3", "0738547239", 5);
		comanda = new Comanda(lista,data,client,new Inregistrata());
		fail("Lipsa exceptie pe lista produse =  null si valoare 0");
		}
		catch(Exception e){
			
		}
	}
	public void testConstructorClientNull()throws Exception{
		ArrayList<InterfataApa> lista=new ArrayList<>();
		ApaFactory apaFactory=new ApaFactory();
		InterfataApa apa1=apaFactory.getApa(TipApa.L11, 1);
		InterfataApa apa2=apaFactory.getApa(TipApa.L5, 2);
		lista.add(apa1);
		lista.add(apa2);
		
		float val=0;
		for(InterfataApa a:lista){
			val+=a.getPret();
		}
		Client client=null;
		String data="24/05/2016";
		try{
		comanda = new Comanda(lista,data,client,new Inregistrata());
		fail("Lipsa exceptie pe client =  null");
		}
		catch(Exception e){
			
		}
	}
	
	public void testModalitatePlata(){
		try{
			Comanda comanda=new Comanda();
			comanda.setModPlata(null);
			fail("Lipsa modalitate de plata!");
		}catch(Exception ex){
			
		}
	}
}
