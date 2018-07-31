package com.ingenico.nl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/* This class is main class which start the application and
 * initialize dispatcherServlet
*/

@SpringBootApplication
public class SpringBootRestImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestImplApplication.class, args);
    }
}
