package it.asansonne.common.ccsr.service;

import it.asansonne.common.ccsr.model.BaseModel;

public interface PatchService<M extends BaseModel> {

  void update(M model);

}
