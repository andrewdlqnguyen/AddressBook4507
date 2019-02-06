package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new BuddyInfo("Jack", "416-777-8907"));
            repository.save(new BuddyInfo("Chloe", "416-777-4234"));
            repository.save(new BuddyInfo("Kim", "647-908-1234"));
            repository.save(new BuddyInfo("David", "416-456-7654"));
            repository.save(new BuddyInfo("Michelle", "416-999-2345"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddy : repository.findAll()) {
                log.info(buddy.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            repository.findById(1L)
                    .ifPresent(customer -> {
                        log.info("Customer found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(customer.toString());
                        log.info("");
                    });

            // fetch customers by name
            log.info("Customer found with findByName('Homer'):");
            log.info("--------------------------------------------");
            repository.findByName("Homer").forEach(homer -> {
                log.info(homer.toString());
            });

            // fetch customers by phone number
//            log.info("Customer found with findByPhone('416-777-9808'):");
//            log.info("--------------------------------------------");
//            repository.findByPhone("416-777-9808").forEach(homer -> {
//                log.info(homer.toString());
//            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}