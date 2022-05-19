package com.apiRest.Gather.controller;

import com.apiRest.Gather.exception.RessourceNotFoundException;
import com.apiRest.Gather.model.Commentaire;
import com.apiRest.Gather.repository.CommentaireRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;


@RestController
@RequestMapping("/api/auth")
public class CommentaireController {
    @Autowired
    private CommentaireRepository commentaireRepository;

    @CrossOrigin
    @PostMapping("/commentaire")
    public Commentaire createCommentaire(@Validated @RequestBody Commentaire commentaire){
        Commentaire commentaire1 = commentaireRepository.save(commentaire);
        return commentaire1;
    }

    @CrossOrigin
    @PostMapping("/commentaireModify/{id}") // cette méthode ne fonctionne pas correctement
    public Commentaire modifyCommentaire(@Validated @RequestBody Commentaire comm, @PathVariable Long id){
        Commentaire comm1 =commentaireRepository.save(comm);
        return commentaireRepository.findById(id)
                .map(commentaire-> {
                    Commentaire comm11 = comm1;
                    return comm11;
                }).orElseThrow(() -> new RessourceNotFoundException("Commentaire not found with id " + id));
    }

    
    @CrossOrigin
    @GetMapping("/echo")
    public String echo() {
        return "Hello chad " ;
    }

    @CrossOrigin
    @GetMapping("/commentaire")
    public Page<Commentaire> listCommentaire(Pageable pageable){
        return commentaireRepository.findAll(pageable);
    }
    @CrossOrigin
    @GetMapping("/commentaire/{id}")
    public Commentaire getById(@PathVariable Long id){
        Commentaire commentaire = commentaireRepository.getOne(id);
        return commentaire;
    }
    @CrossOrigin
    @DeleteMapping("/commentaire/{id}")
    public ResponseEntity<?> deleteCommentaire(@PathVariable Long id){
        return commentaireRepository.findById(id)
                .map(commentaire -> {
                    commentaireRepository.delete(commentaire);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new RessourceNotFoundException("Commentaire not found with id " + id));
    }
}
