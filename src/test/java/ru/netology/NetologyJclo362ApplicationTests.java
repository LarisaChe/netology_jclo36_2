package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import ru.netology.repository.Authorities;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class NetologyJclo362ApplicationTests {

    private GenericContainer<?> devApp = new GenericContainer<>("devapp:latest")
            .withExposedPorts(8080);
    private GenericContainer<?> prodApp = new GenericContainer<>("prodapp:latest")
            .withExposedPorts(8081);

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeAll
    public void setUp() {
        devApp.start();
        prodApp.start();
    }

    @Test
    void checkPortDev() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + devApp.getMappedPort(8080) + "/authorize?user=John&password=s33pas33pas33", String.class);
        Assertions.assertEquals("[\"READ\"]", forEntity.getBody());
    }

    @Test
    void checkPortProd() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + prodApp.getMappedPort(8081) + "/authorize?user=Thomas&password=s33pas33pas33", String.class);
        Assertions.assertEquals("Unknown user Thomas", forEntity.getBody());
    }
}
