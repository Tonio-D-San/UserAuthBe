package it.asansonne.management.ccsr.service.dashboard;

import it.asansonne.authhub.ccsr.service.DeleteService;
import it.asansonne.authhub.ccsr.service.GetService;
import it.asansonne.authhub.ccsr.service.PatchService;
import it.asansonne.authhub.ccsr.service.PostService;
import it.asansonne.management.model.Realm;
import java.util.Optional;

public interface RealmService extends
    GetService<Realm>, PatchService<Realm>, PostService<Realm>, DeleteService<Realm>
{
  Optional<Realm> findByName(String name);
}
