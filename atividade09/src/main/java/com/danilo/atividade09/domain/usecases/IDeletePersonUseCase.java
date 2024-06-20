package com.danilo.atividade09.domain.usecases;

import java.util.UUID;

public interface IDeletePersonUseCase {
    void execute(UUID personId);
}
