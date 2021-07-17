package com.company.multi_thread.PrintOddEvenWN;

class OddEvenPrinter {

    static boolean isEvenNumber = true;



    static class Printer{
        static int currentVal = 0;
    }

    static Printer printer = new Printer();

    static class EvenPrinter extends Thread {

        public EvenPrinter(String name) {
            super(name);
        }

        @Override
        public void run() {
            while(printer.currentVal <= 10) {
                synchronized (printer) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " : " + printer.currentVal);
                        printer.currentVal ++;
                        isEvenNumber = !isEvenNumber;
                        printer.notify();
                        printer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    public static void main(String[] args){

        Thread evenPrint = new EvenPrinter("even Printer");
        evenPrint.start();
        Thread oddPrint = new EvenPrinter("Odd Printer");
        oddPrint.start();
    }



}
