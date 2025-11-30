package it.asansonne.authhub.ccsr.service;

import it.asansonne.authhub.model.Models;

public interface PostService<M extends Models> {

  M create(M model);
}
