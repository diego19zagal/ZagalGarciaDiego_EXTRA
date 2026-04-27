package com.Extraordinario.web.services;


import com.Extraordinario.web.modules.BeanCliente;
import com.Extraordinario.web.modules.BeanPedido;
import com.Extraordinario.web.modules.RepositoryCliente;
import com.Extraordinario.web.modules.RepositoryPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {
    private RepositoryPedido repositoryPedido;
    private RepositoryCliente repositoryCliente;

    public CompraService(RepositoryPedido repositoryPedido) {
        this.repositoryPedido = repositoryPedido;
    }

    public CompraService(RepositoryCliente repositoryCliente) {
        this.repositoryCliente = repositoryCliente;
    }

    public BeanPedido crearpedido(Integer clienteid, String descripcion, Integer pedidoid){
        BeanCliente cliente = repositoryCliente.findById(clienteid).get();
        BeanPedido pedido = repositoryPedido.findById(pedidoid).get();


        if(!cliente.isActivo()){
            throw new RuntimeException("cliente no esta activo");
        }
        if(descripcion.equals(descripcion)){
            throw new RuntimeException("no hay descripcion");
        }
        if(pedido.getTotal() > 0){
            throw new RuntimeException("Error debe ser mayor la compra");
        }

        pedido.setEstado("CREADO");
        pedido.setId(clienteid);
        pedido.setDescripcion(descripcion);




        return repositoryPedido.save(pedido);
    }

    //---------------------------------------------------------------------------------------------
    public BeanPedido avanzarestado(Integer pedidoid){
        BeanPedido pedido = repositoryPedido.findById(pedidoid).get();
        String actual = pedido.getEstado();

        if (actual.equals("CREADO")){
         pedido.setEstado("preparado");
        } else if (pedidoid.equals("Preparado")) {
            pedido.setEstado("ENTREGADO");
        } else if (pedidoid.equals("ENTREGADO")) {
            throw new RuntimeException("YAA FUE ENTREGADO");
        } else if (pedidoid.equals("Cancelado")) {
            throw new RuntimeException("Ya fue cancelado");
        }
        repositoryPedido.save(pedido);

        return repositoryPedido.save(pedido);

    }

    //-----------------------------------------------------------------------------------------
    private void desactivarcliente(Integer clienteid){
        BeanCliente cliente = repositoryCliente.findById(clienteid).get();
        cliente.setActivo(false);
        repositoryCliente.save(cliente);
    }

    //-------------

    private BeanPedido Cancelarpedido(Integer pedidoid){
        BeanPedido pedido = repositoryPedido.findById(pedidoid).get();

        pedido.setEstado("CREADO");

        if (pedidoid.equals("Cancelado")){

        } else if (pedidoid.equals("CANCELADO")) {
            throw new RuntimeException("error");
        }

        return repositoryPedido.save(pedido);

    }


}
