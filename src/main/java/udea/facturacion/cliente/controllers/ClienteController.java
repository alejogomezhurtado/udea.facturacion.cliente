package udea.facturacion.cliente.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udea.facturacion.cliente.modelo.DtoCliente;

import java.util.ArrayList;

@RestController
public class ClienteController {
    private static final Logger logger = LogManager.getLogger(ClienteController.class);

    @RequestMapping(method = RequestMethod.GET, value="/cliente")
    public @ResponseBody ResponseEntity<DtoCliente> nuevaSolicitud(@RequestParam(value = "idCliente", required = true) String idCliente){
        logger.info("Solicitado cliente "+idCliente);
        return new ResponseEntity<>(Cliente.obtener(new Integer(idCliente)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value="/clientes")
    public @ResponseBody ResponseEntity<ArrayList<DtoCliente>> nuevaSolicitud(){
        logger.info("Solicitado todos los clientes");
        return new ResponseEntity<>(Cliente.lista(), HttpStatus.OK);
    }
}