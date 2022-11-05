package com.phbc.phlogapi.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Erro {

    private Integer status;
    private LocalDateTime dataHora;
    private String titulo;
    private List<Campo> campos;
}
