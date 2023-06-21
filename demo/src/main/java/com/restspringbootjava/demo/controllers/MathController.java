package com.restspringbootjava.demo.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restspringbootjava.demo.converters.NumberConverter;
import com.restspringbootjava.demo.exceptions.UnsupportedMathOperationException;
import com.restspringbootjava.demo.math.SimpleMath;

@RestController
public class MathController {
    
    private final AtomicLong counter = new AtomicLong();
    private SimpleMath math = new SimpleMath();
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
    
    if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
        throw new UnsupportedMathOperationException("Please set a numeric value!");
    }
    return math.media(NumberConverter.convertToDoube(numberOne), NumberConverter.convertToDoube(numberTwo));
    }


    @RequestMapping(value = "/raiz/{numberOne}", method=RequestMethod.GET)
    public Double raiz(
        @PathVariable(value = "number") String number
        ) throws Exception{
    
    if(!NumberConverter.isNumeric(number)) {
        throw new UnsupportedMathOperationException("Please set a numeric value!");
    }
    return math.raiz(NumberConverter.convertToDoube(number));
    }

    @RequestMapping(value = "/soma/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
        )throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.sum(NumberConverter.convertToDoube(numberOne), NumberConverter.convertToDoube(numberTwo));
    }

    @RequestMapping(value = "/subtracao/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sub(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception{
    if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
        return math.sub(NumberConverter.convertToDoube(numberOne), NumberConverter.convertToDoube(numberTwo));
    }

    @RequestMapping(value = "/multiplicacao/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    // Adicionar as outras operações matemáticas
    public Double mult(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
        return math.mult(NumberConverter.convertToDoube(numberOne), NumberConverter.convertToDoube(numberTwo));
    }

    @RequestMapping(value = "/divisao/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    // Adicionar as outras operações matemáticas
    public Double divs(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
        return math.divs(NumberConverter.convertToDoube(numberOne), NumberConverter.convertToDoube(numberTwo));
    }
}
