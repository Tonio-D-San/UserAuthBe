package it.asansonne.common.ccsr.service;

import it.asansonne.common.ccsr.model.BaseModel;

public interface PostService<M extends BaseModel> {

  M create(M model);
}
