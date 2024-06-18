package com.danilo.atividade08.domain.usecases;

import java.util.UUID;

public interface IDeletePersonUseCase {
    void execute(UUID personId);
}
