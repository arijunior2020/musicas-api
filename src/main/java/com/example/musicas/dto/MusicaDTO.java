package com.example.musicas.dto;

import com.example.musicas.model.Musica;
import lombok.Data;

@Data
public class MusicaDTO {
    private Long id;
    private String titulo;
    private String artista;
    private String album;
    private String genero;
    private int duracao;

    public MusicaDTO(Musica musica) {
        this.id = musica.getId();
        this.titulo = musica.getTitulo();
        this.artista = musica.getArtista();
        this.album = musica.getAlbum();
        this.genero = musica.getGenero();
        this.duracao = musica.getDuracao();
    }
}