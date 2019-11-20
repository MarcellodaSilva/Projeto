package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;

import Service.ClienteService;
import model.entity.Cliente;

@SuppressWarnings("deprecation")
@ManagedBean(name = "Cliente")
@NoneScoped
public class ClienteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Cliente cliente ;
	private ClienteService clienteService;
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ClienteService getClienteService() {
		return clienteService;
	}
	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
}
