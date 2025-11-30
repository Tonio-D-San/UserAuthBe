package it.asansonne.authhub.ccsr.service;

import it.asansonne.authhub.model.Models;

public interface PatchService<M extends Models> {

  void update(M model);
}
