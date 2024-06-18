package com.danilo.atividade08.infra.repositories;

import com.danilo.atividade08.infra.repositories.schemas.PersonSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IPersonRepositoryJPA extends JpaRepository<PersonSchema, UUID> {
}
