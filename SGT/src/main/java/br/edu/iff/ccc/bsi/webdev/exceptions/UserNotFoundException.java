package br.edu.iff.ccc.bsi.webdev.exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {

    private final String url;
    private final String ex;

    public UserNotFoundException(String url, Exception ex) {
        super(ex);  
        this.url = url;
        this.ex = ex.getLocalizedMessage();
    }

    public UserNotFoundException(String url, String message) {
        super(message); 
        this.url = url;
        this.ex = message;
    }

    public String getUrl() {
        return url;
    }

    public String getExceptionMessage() {
        return ex;
    }
}
