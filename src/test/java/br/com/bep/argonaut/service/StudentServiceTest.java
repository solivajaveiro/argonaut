package br.com.bep.argonaut.service;

import br.com.bep.argonaut.dto.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService service;

    StudentDTO request;

    @BeforeEach
    public void setUp(){
        request = new StudentDTO();
        request.setName("Caio");
        request.setEmail("email@email.com");
        request.setIdentityNumber("123456789");
        request.setPostalCode("1245788");
        request.setAddressLine("Rua das ruas, 135, SP");
        request.setStudentSince(LocalDate.now());
        request.setBirthdate(LocalDate.now());
        request.setCellphone(1155478962L);
        request.setMonthlyBill(150.00);
        request.setLastpaydate(LocalDate.now());
    }

    @Test
    public void shouldCreateStudent() {
        Optional<StudentDTO> response = service.create(request);

        assertNotNull(response.get());
        assertEquals(request.getName(), response.get().getName());
    }

    @Test
    public void shouldCreateStudentWithoutPaymentInformation() {

        request.setMonthlyBill(0.0);
        request.setLastpaydate(null);
        Optional<StudentDTO> response = service.create(request);

        assertNotNull(response.get());
        assertEquals(request.getName(), response.get().getName());
        assertEquals(response.get().getMonthlyBill(), 0.0);
        assertNull(response.get().getLastpaydate());
    }

    @Test
    public void test() {
        System.out.println(LocalDate.now());
    }
}
