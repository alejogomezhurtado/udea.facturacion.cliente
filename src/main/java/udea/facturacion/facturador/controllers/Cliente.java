package udea.facturacion.facturador.controllers;

import com.google.gson.Gson;
import udea.facturacion.facturador.modelo.DtoCliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cliente {

    private static Map<Integer, DtoCliente> listaClientes = new HashMap<>();

    public static void crear(String message){
        Gson gson = new Gson();
        DtoCliente cliente = gson.fromJson(message, DtoCliente.class);
        listaClientes.put(cliente.getIdCliente(), cliente);
        System.out.println(cliente);
    }

    public static DtoCliente obtener(Integer id){
        return listaClientes.get(id);
    }

    public static ArrayList<DtoCliente> lista(){
        return new ArrayList<DtoCliente>(listaClientes.values());
    }
}
