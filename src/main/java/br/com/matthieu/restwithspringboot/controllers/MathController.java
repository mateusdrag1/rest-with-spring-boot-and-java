package br.com.matthieu.restwithspringboot.controllers;

import br.com.matthieu.restwithspringboot.exceptions.UnsupportedMathOperationException;
import br.com.matthieu.restwithspringboot.helpers.MathOperations;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import static br.com.matthieu.restwithspringboot.helpers.NumberConverter.convertToDouble;
import static br.com.matthieu.restwithspringboot.helpers.NumberConverter.isNumeric;

@RestController
public class MathController {
    private final AtomicLong counter = new AtomicLong();

    private final MathOperations mathOperations = new MathOperations();

    @RequestMapping(value = "/{action}/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
    public Double mathOperation(
            @PathVariable(value = "action") String operation,
            @PathVariable(value = "firstNumber") String firstNumber,
            @PathVariable(value = "secondNumber") String secondNumber
    ) throws Exception {

        double result = 0D;


        if (!isNumeric(firstNumber) || !isNumeric(secondNumber)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        switch (operation) {
            case "sum" -> result = mathOperations.sum(convertToDouble(firstNumber), convertToDouble(secondNumber));
            case "sub" -> result = mathOperations.sub(convertToDouble(firstNumber), convertToDouble(secondNumber));
            case "div" -> result = mathOperations.div(convertToDouble(firstNumber), convertToDouble(secondNumber));
            case "avg" -> result = mathOperations.avg(convertToDouble(firstNumber), convertToDouble(secondNumber));

            default -> throw new UnsupportedMathOperationException("This operation is not supported");
        }


        return result;
    }

    @RequestMapping(value = "/sqrt/{number}", method = RequestMethod.GET)
    public Double mathSqrt(
            @PathVariable(value = "number") String number
    ) throws Exception {

        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return mathOperations.sqrt(convertToDouble(number));
    }

}
