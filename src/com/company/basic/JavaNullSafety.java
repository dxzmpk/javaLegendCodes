package com.company.basic;

import java.util.Optional;

public class JavaNullSafety {
    class Computer {
        private Optional<Soundcard> soundcard;
        public Optional<Soundcard> getSoundcard() { return soundcard; }
    }

    class Soundcard {
        public Optional<USB> usb;
        public Optional<USB> getUSB() { return usb; }

    }

    class USB{
        public String getVersion(){ return null; }
    }
    
    public static void main(String[] args){
        JavaNullSafety safety = new JavaNullSafety();
        Computer computer = safety.new Computer();
        //computer.soundcard = Optional.of(safety.new Soundcard());
        computer.soundcard = Optional.empty();
        //computer.soundcard.get().usb = Optional.of(safety.new USB());
        String result = Optional.of(computer).flatMap(Computer::getSoundcard)
                              .flatMap(Soundcard::getUSB)
                              .map(USB::getVersion)
                              .orElse("UNKNOW");
        System.out.println(result);
    }
}
