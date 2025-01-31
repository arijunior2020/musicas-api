package com.example.musicas.service;

import com.example.musicas.model.Musica;
import com.example.musicas.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicaService {
    @Autowired
    private MusicaRepository musicaRepository;

    public List<Musica> listarTodas() {
        return musicaRepository.findAll();
    }

    public Optional<Musica> buscarPorId(Long id) {
        return musicaRepository.findById(id);
    }

    public Musica salvar(Musica musica) {
        return musicaRepository.save(musica);
    }

    public void deletar(Long id) {
        musicaRepository.deleteById(id);
    }
}
