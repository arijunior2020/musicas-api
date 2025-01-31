package com.example.musicas.controller;
import com.example.musicas.dto.MusicaRequestDTO;
import com.example.musicas.dto.MusicaDTO;
import com.example.musicas.model.Musica;
import com.example.musicas.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private MusicaService musicaService;

    @GetMapping
    public List<MusicaDTO> listarTodas() {
        return musicaService.listarTodas().stream()
                .map(MusicaDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public Optional<MusicaDTO> buscarPorId(@PathVariable Long id) {
        return musicaService.buscarPorId(id).map(MusicaDTO::new);
    }

    @PostMapping
    public Musica criar(@RequestBody MusicaRequestDTO musicaDTO) {
        Musica musica = new Musica();
        musica.setTitulo(musicaDTO.getTitulo());
        musica.setArtista(musicaDTO.getArtista());
        musica.setAlbum(musicaDTO.getAlbum());
        musica.setGenero(musicaDTO.getGenero());
        musica.setDuracao(musicaDTO.getDuracao());

        return musicaService.salvar(musica);
    }


    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        musicaService.deletar(id);
    }
}