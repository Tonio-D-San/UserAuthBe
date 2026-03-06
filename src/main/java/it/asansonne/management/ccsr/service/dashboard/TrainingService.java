package it.asansonne.management.ccsr.service.dashboard;

import it.asansonne.common.ccsr.service.DeleteService;
import it.asansonne.common.ccsr.service.GetService;
import it.asansonne.common.ccsr.service.PatchService;
import it.asansonne.common.ccsr.service.PostService;
import it.asansonne.management.model.Training;
import java.util.Optional;

public interface TrainingService extends
    GetService<Training>, PatchService<Training>,
    PostService<Training>, DeleteService
{
  Optional<Training> findByName(String name);
}
