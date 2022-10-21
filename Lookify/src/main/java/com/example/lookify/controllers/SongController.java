package com.example.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.lookify.models.Song;
import com.example.lookify.services.SongService;

@Controller
public class SongController {
	
	@Autowired
	SongService service;
	
	
	@GetMapping("/")
	public String dashboard(Model model) {
		List<Song> allSongs = service.allSongs();
		model.addAttribute("allSongs", allSongs);
		return "dashboard.jsp";	
	}
	
	
	
	@GetMapping("/addPage")
	public String addPage(@ModelAttribute("song") Song song) {
		return "add.jsp";
	}
	
	@PostMapping("/add")
	public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors())
			return "add.jsp";
		else {
			service.addSong(song);
			return "redirect:/";
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		service.deleteSong(id);
		return "redirect:/";
	}
	
	
//	@GetMapping("/songs/{id}")
//	public String details(@PathVariable("id") Long id, Model model) {
//		Song song = songService.findSong(id);
//		model.addAttribute("song", song);
//		return "details.jsp";
//	}
//	
//	@GetMapping("/search/topTen")
//	public String details(Model model) {
//		List<Song> songs = songService.topTen();
//		model.addAttribute("songs", songs);
//		return "top.jsp";
//	}
//	
//	@GetMapping("/search/{artist}")
//	public String search(@PathVariable("artist") String artist, Model model) {
//		List<Song> songs = songService.findByArtist(artist);
//		model.addAttribute("songs", songs);
//		return "search.jsp";
//	}
//	
//	@RequestMapping("/delete/{id}")
//	public String deleteSong(@PathVariable("id") Long id) {
//		songService.deleteSong(songService.findSong(id));
//		return "redirect:/dashboard";
//	}
}
