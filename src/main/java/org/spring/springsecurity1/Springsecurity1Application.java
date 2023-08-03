package org.spring.springsecurity1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // BaseEntity를 사용하기위해선 해당 어노테이션을 사용
public class Springsecurity1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springsecurity1Application.class, args);
	}

}
