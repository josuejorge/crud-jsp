package beans;

public class BeanCursoJsp {

	
	public String login;
	public String senha;
	
	public boolean validarLoginSenha(String login, String senha) {
		if(login.equalsIgnoreCase("admin") && (senha.equalsIgnoreCase("admin"))) {
			return true;
		}else {
			return false;
		}
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
