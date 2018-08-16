package udea.facturacion.facturador.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udea.facturacion.facturador.modelo.DtoCliente;

import java.util.ArrayList;

@RestController
public class SolicitudController {

    @RequestMapping(method = RequestMethod.GET, value="/cliente")
    public @ResponseBody ResponseEntity<DtoCliente> nuevaSolicitud(@RequestParam(value = "idCliente", required = true) String idCliente){
        return new ResponseEntity<>(Cliente.obtener(new Integer(idCliente)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value="/clientes")
    public @ResponseBody ResponseEntity<ArrayList<DtoCliente>> nuevaSolicitud(){
        return new ResponseEntity<>(Cliente.lista(), HttpStatus.OK);
    }
}