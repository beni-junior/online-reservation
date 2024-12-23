package ir.hatami.onlinereservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Date;

@SpringBootApplication
public class OnlineReservationApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineReservationApplication.class, args);
//
//        long epochSecond = Instant.now().getEpochSecond();
//        Instant instant = Instant.ofEpochSecond(epochSecond);
//        Date from = Date.from(instant);
//        System.out.println("epochSecond = " + epochSecond);
    }

}
