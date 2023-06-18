package com.restspringbootjava.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restspringbootjava.demo.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
    
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    // Adicionar as outras operações matemáticas
    public Double media(
    @PathVariable(value = "numberOne") String numberOne, 
    @PathVariable(value = "numberTwo") String numberTwo 
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }
        return convertToDoube(numberOne) + convertToDoube(numberTwo);
    }


    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    // Adicionar as outras operações matemáticas
    public Double sum(
    @PathVariable(value = "numberOne") String numberOne, 
    @PathVariable(value = "numberTwo") String numberTwo 
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }
        return convertToDoube(numberOne) + convertToDoube(numberTwo);
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    // Adicionar as outras operações matemáticas
    public Double sub(
    @PathVariable(value = "numberOne") String numberOne, 
    @PathVariable(value = "numberTwo") String numberTwo 
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }
        return convertToDoube(numberOne) - convertToDoube(numberTwo);
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
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

    @RequestMapping(value = "/divs/{numberOne}/{numberTwo}", method=RequestMethod.GET)
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
