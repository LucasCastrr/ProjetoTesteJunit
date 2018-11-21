package br.upf.ads.testejpa.utils;

import javax.persistence.Persistence;

public class GerarBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     Persistence.createEntityManagerFactory("TesteJPA");
	}

}
