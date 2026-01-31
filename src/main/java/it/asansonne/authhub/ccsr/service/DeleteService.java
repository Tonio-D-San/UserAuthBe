package it.asansonne.authhub.ccsr.service;

import it.asansonne.authhub.model.BaseModel;
import java.util.UUID;

public interface DeleteService<M extends BaseModel> {

  M deleteByUuid(UUID uuid);
}
