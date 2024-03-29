package bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Service.FarmaciaService;
import Service.UsuarioService;
import exception.ValidacaoException;
import model.entity.Farmacia;
import model.entity.Usuario;

@Named
@ViewScoped
public class FarmaciaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Farmacia farmacia;
	
	@Inject
	private FarmaciaService farmaciaService;
	@Inject
	private Usuario usuario;
	@Inject
	private UsuarioService usuarioService;
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public Farmacia getFarmacia() {
		return farmacia;
	}

	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
	}


	public FarmaciaService getFarmaciaService() {
		return farmaciaService;
	}


	public void setFarmaciaService(FarmaciaService farmaciaService) {
		this.farmaciaService = farmaciaService;
	}


	public void adicionarFarmacia() throws Exception {
		try{
			farmaciaService.cadastrarFarmacia(farmacia);
			usuarioService.cadastrarUsuario(usuario);
		}catch(ValidacaoException v) {
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "erro", "Erro no Cadastro"));
		}
		
	}
}
