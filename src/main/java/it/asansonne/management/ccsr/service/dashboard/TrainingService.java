package it.asansonne.management.ccsr.service.dashboard;

import it.asansonne.authhub.ccsr.service.DeleteService;
import it.asansonne.authhub.ccsr.service.GetService;
import it.asansonne.authhub.ccsr.service.PatchService;
import it.asansonne.authhub.ccsr.service.PostService;
import it.asansonne.management.model.Training;
import java.util.Optional;

public interface TrainingService extends
    GetService<Training>, PatchService<Training>, PostService<Training>, DeleteService<Training>
{
  Optional<Training> findByName(String name);
}
