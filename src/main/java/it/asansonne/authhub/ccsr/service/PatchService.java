package it.asansonne.authhub.ccsr.service;

import it.asansonne.authhub.model.BaseModel;

public interface PatchService<M extends BaseModel> {

  void update(M model);

//  M update(M model, Consumer<M> mutator);
}
