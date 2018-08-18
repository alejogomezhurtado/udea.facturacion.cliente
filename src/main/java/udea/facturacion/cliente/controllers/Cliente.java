package udea.facturacion.cliente.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import udea.facturacion.cliente.modelo.DtoCliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cliente {
    private static final Logger logger = LogManager.getLogger(ClienteController.class);
    private static Map<Integer, DtoCliente> listaClientes = new HashMap<>();

    static{
        listaClientes.put(1, new DtoCliente(1, "federico"));
        listaClientes.put(2, new DtoCliente(2, "lorena"));
        listaClientes.put(3, new DtoCliente(3, "marcela"));
    }

    public static void crear(DtoCliente cliente){
        listaClientes.put(cliente.getIdCliente(), cliente);
        logger.info("Cliente Creado o modificado");
    }

    public static DtoCliente obtener(Integer id){
        DtoCliente cliente = listaClientes.get(id);
        logger.info("Retorna cliente "+cliente);
        return cliente;
    }

    public static ArrayList<DtoCliente> lista(){
        logger.info("Retorna "+listaClientes.size()+" clientes");
        return new ArrayList<DtoCliente>(listaClientes.values());
    }
}
