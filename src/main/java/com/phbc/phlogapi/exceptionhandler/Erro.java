package com.phbc.phlogapi.exceptionhandler;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Erro {

    private Integer status;
    private LocalDateTime dataHora;
    private String titulo;
    private List<Campo> campos;
}
