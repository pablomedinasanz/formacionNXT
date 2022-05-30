package com.example.DBA1;

import com.example.DBA1.controller.PersonController;
import com.example.DBA1.dto.PersonInputDTO;
import com.example.DBA1.dto.PersonOutputDTO;
import com.example.DBA1.entity.Person;
import com.example.DBA1.service.PersonService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class Dba1ApplicationTests {

	@Mock
	PersonService personServiceMock;

	@InjectMocks
	PersonController personController;

	PersonInputDTO personInputDTO =
			new PersonInputDTO(
					1,
					"pablo",
					"1111",
					"Pablo",
					"Medina",
					"pablo@bosonit.com",
					"pablo@gmail.com",
					"Madrid",
					true,
					new Date(),
					"",
					new Date());
	PersonOutputDTO personOutputDTO =
			new PersonOutputDTO(
					1,
					"pablo",
					"Pablo",
					"Medina",
					"pablo@bosonit.com",
					"pablo@gmail.com",
					"Madrid",
					true,
					new Date(),
					"",
					new Date());
	List<PersonOutputDTO> personOutputDTOList;
	@BeforeAll
	void before() {
		System.out.println("Before");
		personOutputDTOList = new ArrayList<>();
		personOutputDTOList.add(personOutputDTO);
	}

	@Test
	void findByIdTest() throws Exception {
		System.out.println("TEST1");
		when(personServiceMock.findById(1)).thenReturn(personOutputDTO);
		assertEquals(personOutputDTO, personController.getPersonById(1));
		System.out.println(personOutputDTO);
	}

	@Test
	void findAllTest() throws Exception {
		System.out.println("TEST2");
		when(personServiceMock.findAll()).thenReturn(personOutputDTOList);
		assertEquals(personOutputDTOList, personController.getAll());
		System.out.println(personOutputDTOList);
	}

	@Test
	void findByNameTest() throws Exception {
		System.out.println("TEST3");
		when(personServiceMock.findByName("luis")).thenReturn(personOutputDTO);
		assertEquals(personOutputDTO, personController.getPeopleByName("luis"));
		System.out.println(personOutputDTO);
	}

	@Test
	void addPersonTest() throws Exception {
		System.out.println("TEST4");
		when(personServiceMock.addPerson(personInputDTO))
				.thenReturn(new PersonOutputDTO(new Person(personInputDTO)));
		assertEquals(personOutputDTO, personController.addPerson(personInputDTO));
		System.out.println(personOutputDTO);
	}

	@Test
	void deletePersonTest() throws Exception {

		System.out.println("TEST5");
		when(personServiceMock.deletedById(1)).thenReturn(personOutputDTO);
		assertEquals(new Person(personInputDTO), personController.deletePerson(1));
	}

	@Test
	void contextLoads() {
	}

}
