package main;

import fileManager.MonitoraFileReader;
import fileManager.MonitoraFileWriter;
import menus.Controler;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CARREGAR ELEMENTOS DO BANCO
		MonitoraFileReader rdr = new MonitoraFileReader();
		
		Controler ctr = new Controler(rdr.getUsers(), rdr.getMessages(), rdr.getClasses());
		
		if(ctr.login()) {
			ctr.start();
			MonitoraFileWriter wrt = new MonitoraFileWriter(ctr.getUsers(), ctr.getArrayMessages(), ctr.getClasses());
			wrt.terminate();
		}
	}

}
