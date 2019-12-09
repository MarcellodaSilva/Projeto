package bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import Service.LoginService;
import model.entity.Cliente;
import model.entity.Farmacia;
import model.entity.Usuario;

@Named
@RequestScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private LoginService loginService;
	private Cliente cliente;
	private Farmacia farmacia;
	private String login;
	private String senha;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Farmacia getFarmacia() {
		return farmacia;
	}

	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
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

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public String logar() {
		try {
			Usuario user = loginService.logar(senha, login);
			FacesContext sessao = FacesContext.getCurrentInstance(); 
			if (user.getTipo().equals("Pf")) {
				sessao.getExternalContext().getSessionMap().put("Pf", (Cliente) user);
				cliente = (Cliente) user;
				return "perfil_cliente";
			} else if (user.getTipo().equals("Pj")) {
				sessao.getExternalContext().getSessionMap().put("Pj", (Farmacia) user);
				farmacia = (Farmacia) user;
				return "perfil_farmacia";
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Email ou Senha Incorretos."));
			}

		} catch (Exception v) {
			v.printStackTrace();
		}
		return null;

	}

	/*
	public String logar() {
		try {
			Object user = loginService.logar(senha, login);
			FacesContext sessao = FacesContext.getCurrentInstance(); 
			if (user instanceof Cliente) {
				sessao.getExternalContext().getSessionMap().put("Perfil", (Cliente) user);
				cliente = (Cliente) user;
				return "perfil_cliente";
			} else if (user instanceof Farmacia) {
				sessao.getExternalContext().getSessionMap().put("Perfil", (Farmacia) user);
				farmacia = (Farmacia) user;
				return "perfil_farmacia";
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Email ou Senha Incorretos."));
			}

		} catch (Exception v) {
			v.printStackTrace();
		}
		return null;

	}
	*/

	public String Deslogar() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "pagina_inicial";
	}
}
