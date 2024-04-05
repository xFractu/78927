using System;
using WSDL.calculadora;

namespace WSDL.operaciones{
    public class Operaciones : Calculadora{

        public int Suma (int a, int b){
            return a + b;
        }

        public int Resta (int a, int b){
            return a -b;
        }

        public int Multiplicacion (int a, int b){
            return a * b;
        }

        public double Division (double a, double b){
            return a / b;
        }


    }
}