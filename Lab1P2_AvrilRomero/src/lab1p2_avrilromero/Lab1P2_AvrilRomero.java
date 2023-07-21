/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_avrilromero;

import java.util.Scanner;

/**
 *
 * @author rodge
 */
public class Lab1P2_AvrilRomero {

    /**
     * @param args the command line arguments
     */
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("1.Ejercicio 1");
        System.out.println("2.Ejercicio 2");
        System.out.println("Ingrese opcion: ");
        int opcion = leer.nextInt();
        switch (opcion) {
            case 1: {
                System.out.println("Ingrese a :");
                int a = leer.nextInt();
                System.out.println("Ingrese b: ");
                int b = leer.nextInt();
                System.out.println("Ingrese c: ");
                int c = leer.nextInt();
                int desp = 200;
                int b1 = -1 * b;
                int denom = 2 * a;
                double vertice = (double) b1 / (double) denom;
                double desp1 = (vertice) - 200;
                double desp2 = (vertice) + 200;
                int cont = 0;
                int acum = 0;
                double resultado = newton(a, b, c, desp1, cont, vertice);
                double resultado2 = newton2(a, b, c, desp2, cont, vertice);
                System.out.println("La raiz 1 encontrada: " + resultado);
                System.out.println("La raiz 1 encontrada: " + resultado2);
            }
            break;
            case 2: {
                System.out.println("Ingrese el limite: ");
                int limite = leer.nextInt();
                System.out.println("Ingrese x: ");
                int x = leer.nextInt();
                while (limite < 0) {
                    System.out.println("Los valores deben ser mayor a 0");
                    System.out.println("Ingrese el limite: ");
                    limite = leer.nextInt();
                    System.out.println("Ingrese x: ");
                    x = leer.nextInt();
                }
                int i = 0;
                int y = 0;
                double resultado = sin(i, x, y, limite);
                System.out.println("El resultado de seno es: " + resultado);
                int z = 0;
                int a = 0;
                double resultado2 = cos(z, x, a, limite);
                System.out.println("El resultado de coseno es: " + resultado2);
                int s = 1;
                int w = 0;
                double resultado3 = tan(s, x, w, limite);
                if (x > 1.6) {
                    System.out.println("El resultado de la tangente es: " + 0.0);
                } else {
                    System.out.println("El resultado de la tangente es: " + resultado3);
                }
            }
            break;
            default: {
                System.out.println("Opcion incorrecta");
            }
            break;
        }

    }

    public static double newton(int a, int b, int c, double des, int cont, double vert) {
        if (cont == 100) {
            return des;
        } else {
            des = des - (ecuacion(a, b, c, des)) / derivada(a, b, c, des);
            return newton(a, b, c, des, cont + 1, vert);
        }
    }

    public static double newton2(int a, int b, int c, double des, int cont, double vert) {
        if (cont == 100) {
            return des;
        } else {
            des = des + (ecuacion(a, b, c, des)) / derivada(a, b, c, des);
            return newton(a, b, c, des, cont + 1, vert);
        }
    }

    public static double ecuacion(int a, int b, int c, double vertice) {
        double x = 0;
        double op = Math.pow(vertice, 2);
        x = (a * op) + (b * vertice) + (c);
        return x;
    }

    public static double derivada(int a, int b, int c, double vertice) {
        double op = (2 * a * vertice) + b;
        return op;
    }

    public static double sin(int i, int x, double y, int lim) {
        if (i == lim) {
            return y;
        } else {
            double exponente = Math.pow(-1, i);
            double denom = factorial((2 * i) + 1);
            double div = exponente / denom;
            double mult = Math.pow(x, (2 * i) + 1);
            double result = div * mult;
            y += result;
            return sin(i + 1, x, y, lim);
        }
    }

    public static double cos(int n, int x, int acum, int lim) {
        if (n == lim) {
            return acum;
        } else {
            double exponente = Math.pow(-1, n);
            double denom = factorial(2 * n);
            double mult = Math.pow(x, (2 * n));
            double result = (exponente / denom) * mult;
            acum += result;
            return cos(n + 1, x, acum, lim);
        }
    }

    public static double tan(int n, int x, int acum, int lim) {
        if (n == lim) {
            return acum;
        } else {
            double op1 = Math.pow(-4, n);
            double op2 = 1 + (Math.pow(-4, n));
            double op3 = factorial(2 * n);
            double op4 = (Math.pow(2, n)) * (op1) * (op2);
            double op5 = op4 / op3;
            double op = (2 * n) - 1;
            double op6 = Math.pow(x, op);
            double op7 = op5 * op6;
            acum += op7;
            return tan(n + 1, x, acum, lim);
        }
    }

    public static int factorial(int x) {
        int result = 1;
        for (int i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    }
}
