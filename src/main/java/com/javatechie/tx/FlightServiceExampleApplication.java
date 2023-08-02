package com.javatechie.tx;

import com.javatechie.tx.dto.FlightBookingAcknowledgement;
import com.javatechie.tx.dto.FlightBookingRequest;
import com.javatechie.tx.entity.PassengerInfo;
import com.javatechie.tx.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class FlightServiceExampleApplication {

    @Autowired
    private FlightBookingService service;


    @PostMapping("/bookFlightTicket")
    public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request) {

//		for(int i=0;i<1000;i++) {
        service.bookFlightTicket(request);
//		}

        return null;
    }

    @GetMapping("/findAll")
    public Map<String, Object> findAll() throws ExecutionException, InterruptedException {

        Map<String, Object> map = new HashMap<>();
        map.put("passenger", service.findAllPassengerInfo().get());
        map.put("paymentInfo", service.findPaymentInfo().get());
        return map;

    }

    public static void main(String[] args) {

        System.out.println("Hello world");

        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(30);
        list.add(11);
        list.add(13);
        list.add(15);

        int sum = list.stream().filter(i -> i % 2 == 0).mapToInt(Integer::intValue).sum();
        int sum1 = list.stream().filter(i -> i % 2 == 0).mapToInt(i -> i).sum();
        System.out.println(sum1);



        SpringApplication.run(FlightServiceExampleApplication.class, args);

//        new FlightServiceExampleApplication().m1("rakesh");
//        new FlightServiceExampleApplication().m1(null);

    }

    public void m1(PassengerInfo s) {
        System.out.println("St");
    }

    public void m1(Object ob) {
        System.out.println("object");
    }


}
