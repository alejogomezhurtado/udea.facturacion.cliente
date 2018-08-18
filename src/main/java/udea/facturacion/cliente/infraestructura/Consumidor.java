package udea.facturacion.cliente.infraestructura;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;
import udea.facturacion.cliente.controllers.Cliente;
import udea.facturacion.cliente.modelo.DtoCliente;

@Component
public class Consumidor implements MessageListener {
    private static final Logger logger = LogManager.getLogger(Consumidor.class);

    @Override
    public void onMessage(Message message) {
        Gson gson = new Gson();
        DtoCliente cliente = gson.fromJson(new String(message.getBody()), DtoCliente.class);
        if(cliente == null){
            logger.info("No creado, cliente null");
            return;
        }
        logger.info("Creando o actualizando cliente "+cliente.toString());
        Cliente.crear(cliente);
    }
}