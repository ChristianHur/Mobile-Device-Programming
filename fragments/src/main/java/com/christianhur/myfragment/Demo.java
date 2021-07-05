package com.christianhur.myfragment;


//Delegates - DI (Dependency Injection)
public class Demo {
    public static void main(String[] args) {
        HP hp = new HP();
        Epson epson = new Epson();
        Printer printer = new Printer(epson);
        printer.print();
    }

}
interface Task{
    public void print();
}
class Printer implements Task{
    Task printer;
    public Printer(Task printer){
        this.printer = printer;
    }
    @Override
    public void print() {
        this.printer.print();
    }
}

class HP implements Task{

    @Override
    public void print() {
        System.out.println("HP Printing...");
    }
}
class Epson implements Task{
    @Override
    public void print() {
        System.out.println("Epson Printing...");
    }
}