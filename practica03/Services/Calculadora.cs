using System;
using System.ServiceModel;

namespace WSDL.calculadora {
    [ServiceContract]
    public interface Calculadora {
        [OperationContract]
        int Suma(int a, int b);
        [OperationContract]
        int Resta(int a, int b);
        [OperationContract]
        int Multiplicacion(int a, int b);
        [OperationContract]
        double Division(double a, double b);
    }
}