package com.tonasolution;

import java.util.function.*;


class Mailer {

    public void print( String msg ){
        System.out.println( msg );
    }

    public Mailer from( String addr ) {
        print( "From" );
        return this;
    }
    public Mailer to( String addr ){

        print("to");
        return this;
    }

    public Mailer subject (String subject) {
        print( "subject" );
        return this;
    }

    public Mailer body( String body ) {
        print( "body" );
        return this;
    }

    public static void send(Consumer<Mailer> mailerFunc) {

        Mailer mailer = new Mailer();
        mailerFunc.accept( mailer );
        
        System.out.println("... Sending ...");

    }
}
public class FluentInterface {
    public static void main(String[] args) {

        Mailer.send( mailer ->
                     mailer.from("from@gmail.com")
                        .to("receiver@gmail.com")
                        .subject("Your code sucks")
        );
    }
}




