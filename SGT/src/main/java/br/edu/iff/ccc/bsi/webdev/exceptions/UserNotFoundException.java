package br.edu.iff.ccc.bsi.webdev.exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {

	public final String url;
	public final String ex;
	
	public UserNotFoundException(String url, Exception ex) {
		this.url = url;
		this.ex = ex.getLocalizedMessage();
	}
	
}
