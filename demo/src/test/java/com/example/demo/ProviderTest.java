package com.example.demo;

import au.com.dius.pact.provider.junitsupport.Consumer;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactBroker;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.DemoService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Provider("demo")
@Consumer("demo-consumer")
@PactBroker(host = "",port = "")
public class ProviderTest {

    @State("Employee present with given id")
    public void testEmployee(){

       DemoService mock = Mockito.mock(DemoService.class);
      EmployeeDto employeeDto =   EmployeeDto.builder()
                .id(2)
                .name("Arikaran")
                .designation("Software Engineer III")
                .build();

       Mockito.when(mock.getEmployeeById(1)).thenReturn(employeeDto);
    }
}
