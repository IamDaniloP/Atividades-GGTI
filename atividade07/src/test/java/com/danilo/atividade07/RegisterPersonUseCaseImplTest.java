package com.danilo.atividade07;

import com.danilo.atividade07.domain.entities.Person;
import com.danilo.atividade07.domain.exceptions.InvalidAgeException;
import com.danilo.atividade07.domain.exceptions.InvalidEmailException;
import com.danilo.atividade07.domain.exceptions.InvalidNameException;
import com.danilo.atividade07.implementation.usecases.RegisterPersonUseCaseImpl;
import com.danilo.atividade07.repository.impl.PersonRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RegisterPersonUseCaseImplTest {
    @Mock
    PersonRepository personRepository;
    @InjectMocks
    RegisterPersonUseCaseImpl registerPersonUseCase;

    Person mockPerson = new Person("ana", "sá leitão", "ana@gmail.com", 22);

    @Test
    @DisplayName("Nao deve receber nome de pessoas abaixo de 3 caracteres")
    void case01() {
        assertThrows(InvalidNameException.class, () -> {
            registerPersonUseCase.execute(new Person("an", "", mockPerson.getEmail(), mockPerson.getAge()));
        });
    }

    @Test
    @DisplayName("Deve receber nome de pessoas que não contenham números")
    void case02() {
        assertThrows(InvalidNameException.class, () -> {
           registerPersonUseCase.execute(new Person("ana", "sá leitã0", mockPerson.getEmail(), mockPerson.getAge()));
        });
    }

    @Test
    @DisplayName("Deve receber nome de pessoas sem padronização e salvá- lo com padronização")
    void case03() {
        ArgumentCaptor<Person> personCaptor = ArgumentCaptor.forClass(Person.class);
        Mockito.when(personRepository.registerPerson(personCaptor.capture())).thenReturn(mockPerson);

        var newPerson = registerPersonUseCase.execute(mockPerson);

        assertEquals("Ana Sá Leitão", newPerson.getFullName());
        assertEquals(mockPerson.getEmail(), newPerson.getEmail());
        assertEquals(mockPerson.getAge(), newPerson.getAge());
    }

    @Test
    @DisplayName("Nao deve receber emails inválidos")
    void case04() {
        assertThrows(InvalidEmailException.class, () -> {
            registerPersonUseCase.execute(new Person("ana", "sá leitão", "anagmail.com", 18));
        });
    }

    @Test
    @DisplayName("Nao deve possuir idades menores que 17 ou maiores que 66")
    void case05() {
        assertThrows(InvalidAgeException.class, () -> {
            registerPersonUseCase.execute(new Person("ana", "sá leitão", "ana@gmail.com", 17));
        });

        assertThrows(InvalidAgeException.class, () -> {
            registerPersonUseCase.execute(new Person("ana", "sá leitão", "ana@gmail.com", 66));
        });
    }

    @Test
    @DisplayName("Deve validar que nenhum campo seja undefined ou null")
    void case06() {
        assertThrows(InvalidNameException.class, () -> {
            registerPersonUseCase.execute(new Person("", "", "ana@gmail.com", 20));
        });

        assertThrows(InvalidEmailException.class, () -> {
            registerPersonUseCase.execute(new Person("ana", "sá leitão", "", 20));
        });

        assertThrows(InvalidAgeException.class, () -> {
            registerPersonUseCase.execute(new Person("ana", "sá leitão", "ana@gmail.com", null));
        });

    }
}
