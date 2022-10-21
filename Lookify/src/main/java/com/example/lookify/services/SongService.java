package com.example.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lookify.models.Song;
import com.example.lookify.repos.SongRepository;

@Service
public class SongService {
	
	@Autowired
	SongRepository songRepository;
	
	public List<Song> allSongs(){
		return songRepository.findAll();
	}
	
	public Song addSong(Song song) {
		return songRepository.save(song);
	}
	
	
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}
	
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if (optionalSong.isPresent())
			return optionalSong.get();
		else 
			return null;
	}
	
}
