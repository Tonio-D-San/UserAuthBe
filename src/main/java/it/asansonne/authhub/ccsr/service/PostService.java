package it.asansonne.authhub.ccsr.service;

import it.asansonne.authhub.model.BaseModel;

public interface PostService<M extends BaseModel> {

  M create(M model);
}
