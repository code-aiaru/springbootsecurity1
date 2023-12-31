# springbootsecurity1
## 1. 프로젝트 생성
<Details>
<summary>프로젝트 생성(https://start.spring.io/)</summary>
<summary>

![img1.png](img1.png)

````
plugins {
	id 'java'
	id 'org.springframework.boot' version '2.7.14'
	id 'io.spring.dependency-management' version '1.0.15.RELEASE'
}

group = 'org.spring'
version = '0.0.1-SNAPSHOT'

java {
	sourceCompatibility = '11'
}

configurations {
	compileOnly {
		extendsFrom annotationProcessor
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-security'
	implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity5'
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-validation'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	// https://mvnrepository.com/artifact/nz.net.ultraq.thymeleaf/thymeleaf-layout-dialect
	implementation ('nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect') // thymeleaf layout 설정
	// https://mvnrepository.com/artifact/org.thymeleaf.extras/thymeleaf-extras-springsecurity5
	implementation ('org.thymeleaf.extras:thymeleaf-extras-springsecurity5') // thymeleaf sec:



	compileOnly 'org.projectlombok:lombok'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'com.mysql:mysql-connector-j'
	annotationProcessor 'org.springframework.boot:spring-boot-configuration-processor'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation 'org.springframework.security:spring-security-test'
}

tasks.named('test') {
	useJUnitPlatform()
}


````


</details>

</summary>

## Security

<details>

</details>