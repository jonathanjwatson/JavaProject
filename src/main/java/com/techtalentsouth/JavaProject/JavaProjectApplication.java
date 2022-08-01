package com.techtalentsouth.JavaProject;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.techtalentsouth.JavaProject.domain.Address;
import com.techtalentsouth.JavaProject.repository.AddressRepository;

@SpringBootApplication
public class JavaProjectApplication {
	private static final Logger log = LoggerFactory.getLogger(JavaProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JavaProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner start(AddressRepository repository) {
		return (args) -> {
			Boolean quit = false;
			Scanner scanner = new Scanner(System.in);
//			log.info("Welcome to our address book.");

			while (!quit) {
				String prompt = "1) Go to Zoo \n2) Eat Icecream \n3) Watch a movie\n4) Quit";
				System.out.println("Welcome to our address book.");
				System.out.println(prompt);

				Integer userInput = scanner.nextInt();

				System.out.println(userInput);

				if (userInput == 1) {
					// TODO: Go to the zoo
					System.out.println("Go to the zoo has been selected!");
					repository.save(new Address("Bob", "Smith"));
					repository.findAll().forEach((a) -> {
						System.out.println(a.toString());
					});

					continue;
				} else if (userInput == 4) {
					quit = true;
					System.out.println("Goodbye!");
					continue;
//					System.exit(0);
				}
			}

			scanner.close();
		};
	}

}
