using System;
using System.ServiceModel;

namespace WSDL.mensajes {
    [ServiceContract]
    public interface Mensajes {
        [OperationContract]
        string Saludar(String nombre);
        [OperationContract]
        string Mostrar();
    }
}