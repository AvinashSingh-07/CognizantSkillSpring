//package Week-2.JUnitTesting.src.main.java;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b){
        return a - b;
    }
    public int divide(int a, int b){
        //Exectional handlling may use for Arithmetic exeption when b==0...
        return a/b;
    }
    public int multiply(int a, int b){
        return a*b;
    }
}