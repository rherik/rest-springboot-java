package com.restspringbootjava.demo;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restspringbootjava.demo.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
    
    private final AtomicLong counter = new AtomicLong();

    //Média de uma lista
    // @RequestMapping(value = "/media/{valores}", method=RequestMethod.GET)
    // public Double media(
    // @PathVariable List<Integer> valores
    // ){
    //     int soma = 0;
    //     for (int valor : valores) {
            
    //         soma += valor;
    //     }
    //     return (double) soma / valores.size();
    // }

    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double media(
    @PathVariable(value = "numberOne") String numberOne, 
    @PathVariable(value = "numberTwo") String numberTwo 
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }
        return (convertToDoube(numberOne) + convertToDoube(numberTwo)) / 2;
    }


    @RequestMapping(value = "/raiz/{numberOne}", method=RequestMethod.GET)
    public Double raiz(
    @PathVariable(value = "numberOne") String numberOne
    ) throws Exception{
        if(!isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }
        Double resultado = convertToDoube(numberOne);
        return Math.sqrt(resultado);
    }

    @RequestMapping(value = "/soma/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(
    @PathVariable(value = "numberOne") String numberOne, 
    @PathVariable(value = "numberTwo") String numberTwo 
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }
        return convertToDoube(numberOne) + convertToDoube(numberTwo);
    }

    @RequestMapping(value = "/subtracao/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sub(
    @PathVariable(value = "numberOne") String numberOne, 
    @PathVariable(value = "numberTwo") String numberTwo 
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }
        return convertToDoube(numberOne) - convertToDoube(numberTwo);
    }

    @RequestMapping(value = "/multiplicacao/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    // Adicionar as outras operações matemáticas
    public Double mult(
    @PathVariable(value = "numberOne") String numberOne, 
    @PathVariable(value = "numberTwo") String numberTwo 
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }
        return convertToDoube(numberOne) * convertToDoube(numberTwo);
    }

    @RequestMapping(value = "/divisao/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    // Adicionar as outras operações matemáticas
    public Double divs(
    @PathVariable(value = "numberOne") String numberOne, 
    @PathVariable(value = "numberTwo") String numberTwo 
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }
        return convertToDoube(numberOne) / convertToDoube(numberTwo);
    }

    private Double convertToDoube(String strNumber) {
        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
