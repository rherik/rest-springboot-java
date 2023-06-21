package com.restspringbootjava.demo.math;

public class SimpleMath {
    public Double media(Double numberOne, Double numberTwo){
            
            return (numberOne + numberTwo) / 2;
        }
    
        public Double raiz(Double number){
            return Math.sqrt(number);
        }
    
        public Double sum(Double numberOne, Double numberTwo){
           
            return numberOne + numberTwo;
        }
    
        public Double sub(Double numberOne, Double numberTwo){
            
            return numberOne - numberTwo;
        }
    
        public Double mult(Double numberOne, Double numberTwo){
            
            return numberOne * numberTwo;
        }
    
        public Double divs(Double numberOne, Double numberTwo){
          
            return numberOne / numberTwo;
        }
}
