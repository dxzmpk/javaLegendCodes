package com.company.useless;

import java.io.IOException;

public class ExceptionTest {

    public void main(){
        try {
            tryItOut();
        } catch (NullPointerException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            wrapItUp();
        }
    }

    public long wrapItUp() {
        ExceptionTest exceptionTest = new ExceptionTest();
        System.out.println("Wraping Up");
        synchronized (this) {
            System.out.println("I have a lock");
        }
        return 10L;
    }

    public void tryItOut() throws IOException {
        Object a = null;
        a.hashCode();
        throw new IOException("IOE excepted");
    }
    
    public static void main(String[] args){
        new ExceptionTest().main();
    }


}
