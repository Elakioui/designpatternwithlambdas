package com.tonasolution;

import java.util.function.Consumer;

class Resource {
    private Resource(){
        System.out.println("Created ..");
    }

    public Resource firstOperation(){
        System.out.println("First Operation");
        return this;
    }

    public Resource secondOperation(){
        System.out.println("Second Operation");
        return this;
    }

    private void close(){
        System.out.println("Cleanup ...");
    }

    public static void use(Consumer<Resource> block){

        Resource resource = new Resource();

        try {
            block.accept(resource);
        } finally {
            resource.close();
        }
    }

}


public class AroundMethodPattern {
    public static void main(String[] args) {

        Resource.use( resource -> {
            resource.firstOperation()
                    .secondOperation();
        });

    }
}
