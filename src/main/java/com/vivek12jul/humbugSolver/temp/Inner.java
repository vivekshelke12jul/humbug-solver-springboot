package com.vivek12jul.humbugSolver.temp;

public class Inner {

    int number;

    public Inner(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public void meth() {
        String path = this.getClass().getResource("viveksrough.txt").getPath();
        System.out.println(path);
    }
    public static void main(String[] args) {

        Inner inner = new Inner(0);
        inner.meth();

    }


}
