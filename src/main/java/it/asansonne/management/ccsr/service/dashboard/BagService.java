package it.asansonne.management.ccsr.service.dashboard;

import it.asansonne.authhub.ccsr.service.GetService;
import it.asansonne.authhub.ccsr.service.PatchService;
import it.asansonne.authhub.ccsr.service.PostService;
import it.asansonne.management.model.Bag;

public interface BagService extends
    GetService<Bag>, PatchService<Bag>, PostService<Bag> {

}
