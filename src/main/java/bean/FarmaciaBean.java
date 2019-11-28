package bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import Service.FarmaciaService;
import exception.ValidacaoException;
import model.entity.Farmacia;

@Named
public class FarmaciaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Farmacia farmacia;
	
	@Inject
	private FarmaciaService farmaciaService;
	
	
	public Farmacia getFarmacia() {
		return farmacia;
	}
	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
	}
	public FarmaciaService getService() {
		return farmaciaService;
	}
	public void setService(FarmaciaService farmaciaService) {
		this.farmaciaService = farmaciaService;
	}

	public void adicionarFarmacia() throws Exception {
		try{
			farmaciaService.cadastrarFarmacia(farmacia);
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro Realizado Com Sucesso!"));
		}catch(ValidacaoException v) {
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "erro", "Erro no Cadastro"));
		}
		
	}
}
