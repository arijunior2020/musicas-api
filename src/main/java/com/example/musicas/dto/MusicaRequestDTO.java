package com.example.musicas.dto;

import lombok.Data;

@Data
public class MusicaRequestDTO {
    private String titulo;
    private String artista;
    private String album;
    private String genero;
    private int duracao;
}
