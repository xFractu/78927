package mx.uv.practica06;

import java.util.ArrayList;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import mx.uv.t4is.grados.ConvertirCelsiusAFarenheitResponse;
import mx.uv.t4is.grados.ConvertirCelsiusAFarenheitRequest;
import mx.uv.t4is.grados.ConvertirFarenheitACelsiusResponse;
import mx.uv.t4is.grados.HistorialResponse;
import mx.uv.t4is.grados.HistorialResponse.Grados;
import mx.uv.t4is.grados.ConvertirFarenheitACelsiusRequest;


@Endpoint
public class GradosEndPoint {
    ArrayList<Grados> grados = new ArrayList<>();
    int i = 0;

    @PayloadRoot(localPart = "ConvertirCelsiusAFarenheitRequest",namespace = "t4is.uv.mx/grados")

    @ResponsePayload
    public ConvertirCelsiusAFarenheitResponse ConvertirCaF(@RequestPayload ConvertirCelsiusAFarenheitRequest peticion){
        ConvertirCelsiusAFarenheitResponse respuesta = new ConvertirCelsiusAFarenheitResponse();
        double convertirCtoF = ((peticion.getGradosC())*9/5)+32;
        respuesta.setRespuesta("Grados Farenheit: "+convertirCtoF);
                /*Simular persistencia*/
                Grados e = new Grados();
                e.setGrados("Grados Celsius: "+peticion.getGradosC()+" Convertidos a Farenheit: "+convertirCtoF);
                e.setId(i);
                i=i+1;
                grados.add(e);
        return respuesta;
    }    

    @PayloadRoot(localPart = "ConvertirFarenheitACelsiusRequest",namespace = "t4is.uv.mx/grados")

    @ResponsePayload
    public ConvertirFarenheitACelsiusResponse ConvertirFaC(@RequestPayload ConvertirFarenheitACelsiusRequest peticion){
        ConvertirFarenheitACelsiusResponse respuesta = new ConvertirFarenheitACelsiusResponse();
        double convertirFtoC = ((peticion.getGradosF())-32) * 5/9;
        respuesta.setRespuesta("Grados Celsius: "+convertirFtoC);
        /*Simular persistencia*/
        Grados e = new Grados();
        e.setGrados("Grados Farenheit: "+peticion.getGradosF()+ " Convertidos a Celsius: "+convertirFtoC);
        e.setId(i);
        i=i+1;
        grados.add(e);
        return respuesta;
    }

    @PayloadRoot(localPart = "HistorialRequest", namespace = "t4is.uv.mx/grados")
    @ResponsePayload
    public HistorialResponse buscarSaludos(){
        HistorialResponse respuesta = new HistorialResponse();
        //respuesta.getSaludos().add();
        //for(int i = 0; i < saludos.size(); i++){
          //  System.out.println(saludos.get(i));
            //respuesta.getSaludos().add(saludos.get(i));
        //}
        respuesta.getGrados().addAll(grados);
        return respuesta;
    }
}

