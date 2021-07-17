package com.company.exception;

import java.io.IOException;

public class ExceptionThrowTest {
    public static void main(String[] args) throws IOException {
        throw new IOException("IO exception");
    }
}
