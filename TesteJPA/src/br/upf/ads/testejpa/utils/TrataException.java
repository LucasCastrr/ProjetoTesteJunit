package br.upf.ads.testejpa.utils;

public class TrataException {

	public static String getMessage(Exception e) {
		// TODO Auto-generated method stub
		return e.getCause().getCause().getCause().getMessage();
	}

}
