package br.edu.iff.ccc.bsi.webdev.controller.view;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
//@RequestMapping(path = "teste")
public class ViewMainController {

	@GetMapping("/")
	public String getLogin() {
		return "login.html";
	}
	@GetMapping("/usuario")
	public String getUsuario() {
		return "usuario.html";
	}
	@GetMapping("/dashboard")
	public String getDashboard() {
		return "quadro-dashboard.html";
	}
	@GetMapping("/quadro")
	public String getQuadro() {
		return "quadro.html";
	}
	@GetMapping("/coluna")
	public String getColuna() {
		return "coluna.html";
	}
	@GetMapping("/anexo")
	public String getAnexo() {
		return "anexo.html";
	}
	

	//outra forma de fazer
	/*@GetMapping("/")
	public ResponseEntity<String> page2(){
		String body = " <div>\r\n"
	    		+ "    <p style={styles.title}>Choose your flavor</p>\r\n"
	    		+ "\r\n"
	    		+ "    <Button\r\n"
	    		+ "      style={{...styles.button, ...styles.facebookButton}}\r\n"
	    		+ "      onClick={this.signIn.bind(this, 'facebook')}\r\n"
	    		+ "    >\r\n"
	    		+ "      Facebook\r\n"
	    		+ "    </Button>\r\n";
		return ResponseEntity.ok().body(body);
	}
	
	@GetMapping("/pagina")
	@ResponseBody
	public String getFoosBySimplePath() {
	    return " <div>\r\n"
	    		+ "    <p style={styles.title}>Choose your flavor</p>\r\n"
	    		+ "\r\n"
	    		+ "    <Button\r\n"
	    		+ "      style={{...styles.button, ...styles.facebookButton}}\r\n"
	    		+ "      onClick={this.signIn.bind(this, 'facebook')}\r\n"
	    		+ "    >\r\n"
	    		+ "      Facebook\r\n"
	    		+ "    </Button>\r\n"
	    		+ "\r\n"
	    		+ "    <Button\r\n"
	    		+ "      style={{...styles.button, ...styles.googleButton}}\r\n"
	    		+ "      onClick={this.signIn.bind(this, 'google')}\r\n"
	    		+ "    >\r\n"
	    		+ "      Google\r\n"
	    		+ "    </Button>\r\n"
	    		+ "\r\n"
	    		+ "    <Button\r\n"
	    		+ "      style={{...styles.button, ...styles.twitterButton}}\r\n"
	    		+ "      onClick={this.signIn.bind(this, 'twitter')}\r\n"
	    		+ "    >\r\n"
	    		+ "      Twitter\r\n"
	    		+ "    </Button>\r\n"
	    		+ "  </div>";
	}
	*/

}
