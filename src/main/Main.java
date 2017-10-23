package main;

import reader.FileReader;

import menus.Controler;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CARREGAR ELEMENTOS DO BANCO
		FileReader rdr = new FileReader();
		
		Controler ctr = new Controler(rdr.getUsers(), rdr.getMessages(), rdr.getClasses());
		
		if(ctr.login()) {
			ctr.start();
		}
	}

}
