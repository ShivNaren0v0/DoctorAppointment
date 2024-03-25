plugins {
	java
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.doctorappointment"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	val gson_version = "2.10";
	val webmvc_version = "2.0.2";
	implementation("com.google.code.gson:gson:$gson_version")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:$webmvc_version")
	implementation("org.springframework.boot:spring-boot-starter-validation")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

//	// https://mvnrepository.com/artifact/org.springframework.security/spring-security-config
//	implementation("org.springframework.security:spring-security-config")
//
//// https://mvnrepository.com/artifact/org.springframework.security/spring-security-core
//	implementation("org.springframework.security:spring-security-core")
//// https://mvnrepository.com/artifact/org.springframework.security/spring-security-web
//	implementation("org.springframework.security:spring-security-web")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
