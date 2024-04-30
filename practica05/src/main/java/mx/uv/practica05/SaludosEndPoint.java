package mx.uv.practica05;

import java.util.ArrayList;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import mx.uv.t4is.saludos.BuscarSaludosResponse;
import mx.uv.t4is.saludos.SaludarRequest;
import mx.uv.t4is.saludos.SaludarResponse;
import mx.uv.t4is.saludos.BuscarSaludosResponse.Saludos;

@Endpoint
public class SaludosEndPoint {
    ArrayList<Saludos> saludos = new ArrayList<>();


    @PayloadRoot(localPart = "SaludarRequest",namespace = "t4is.uv.mx/saludos")

    @ResponsePayload
    public SaludarResponse saludar(@RequestPayload SaludarRequest peticion){
        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setRespuesta("Hola "+peticion.getNombre());
        /*Simular persistencia*/
        Saludos e = new Saludos();
        e.setNombre(peticion.getNombre());
        e.setId(0);
        saludos.add(e); //.add(peticion.getNombre());
        return respuesta;
    }

    @PayloadRoot(localPart = "BuscarSaludosRequest", namespace = "t4is.uv.mx/saludos")
    @ResponsePayload
    public BuscarSaludosResponse buscarSaludos(){
        BuscarSaludosResponse respuesta = new BuscarSaludosResponse();
        //respuesta.getSaludos().add();
        //for(int i = 0; i < saludos.size(); i++){
          //  System.out.println(saludos.get(i));
            //respuesta.getSaludos().add(saludos.get(i));
        //}
        respuesta.getSaludos().addAll(saludos);
        return respuesta;
    }
    
}
