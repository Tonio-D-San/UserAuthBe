package it.asansonne.management.ccsr.service.dashboard;

import it.asansonne.common.ccsr.service.DeleteService;
import it.asansonne.common.ccsr.service.GetService;
import it.asansonne.common.ccsr.service.PatchService;
import it.asansonne.common.ccsr.service.PostService;
import it.asansonne.management.model.AlchemyPath;
import java.util.Optional;

public interface AlchemyPathService extends
    GetService<AlchemyPath>, PatchService<AlchemyPath>,
    PostService<AlchemyPath>, DeleteService {
  Optional<AlchemyPath> findByName(String name);
}
