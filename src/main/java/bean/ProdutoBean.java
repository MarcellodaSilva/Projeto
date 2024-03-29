package bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Service.ProdutoService;
import exception.ValidacaoException;
import model.entity.Produto;

@Named
@ViewScoped
public class ProdutoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Produto produto;
	
	@Inject
	private ProdutoService produtoService;
	
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public ProdutoService getService() {
		return produtoService;
	}
	public void setService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	public void adicionarProduto() throws Exception {
		try{
			produtoService.cadastrarProduto(produto);
		  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro Realizado Com Sucesso!"));
		}catch(ValidacaoException v){
		  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "erro", "Erro no Cadastro"));
		}
	}
}
