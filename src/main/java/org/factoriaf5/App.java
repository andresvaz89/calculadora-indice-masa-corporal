package org.factoriaf5;


import java.util.Scanner;

public class App {
    
    public double calcularIMC(double peso, double estatura) {
        if (peso <= 0 || estatura <= 0) {
            throw new IllegalArgumentException("Peso y estatura deben ser mayores que cero.");
        }
        return peso / Math.pow(estatura, 2);
    }

    public String clasificarIMC(double imc) {
        if (imc < 16) {
            return "Delgadez severa";
        } else if (imc >= 16 && imc < 17) {
            return "Delgadez moderada";
        } else if (imc >= 17 && imc < 18.5) {
            return "Delgadez leve";
        } else if (imc >= 18.5 && imc < 25) {
            return "Peso normal";
        } else if (imc >= 25 && imc < 30) {
            return "Sobrepeso";
        } else if (imc >= 30 && imc < 35) {
            return "Obesidad leve";
        } else if (imc >= 35 && imc < 40) {
            return "Obesidad moderada";
        } else if (imc >= 40) {
            return "Obesidad mórbida";
        } else {
            return "El valor no entra en los parámetros clasificables para el IMC";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce el peso en kilogramos: ");
        double peso = scanner.nextDouble();
        
        System.out.print("Introduce la estatura en metros: ");
        double estatura = scanner.nextDouble();
        
        App imcCalculator = new App();
        double imc = imcCalculator.calcularIMC(peso, estatura);
        String clasificacion = imcCalculator.clasificarIMC(imc);
        
        System.out.printf("Tu IMC es: %.2f\n", imc);
        System.out.println("Clasificación: " + clasificacion);
        
        scanner.close();
    }
}
