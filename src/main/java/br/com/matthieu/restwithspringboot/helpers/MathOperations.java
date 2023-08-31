package br.com.matthieu.restwithspringboot.helpers;

public class MathOperations {

    public Double sum(Double firstNumber, Double secondNumber) {
        return firstNumber + secondNumber;
    }

    public Double sub(Double firstNumber, Double secondNumber) {
        return firstNumber - secondNumber;
    }

    public Double div(Double firstNumber, Double secondNumber) {
        return firstNumber / secondNumber;
    }

    public Double avg(Double firstNumber, Double secondNumber) {
        return (firstNumber + secondNumber) / 2;
    }

    public Double sqrt(Double number) {
        return Math.sqrt(number);
    }
}
