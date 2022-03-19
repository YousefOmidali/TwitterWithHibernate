package Services;

import Entity.Twit;
import Repository.TwitRepository;

import java.util.List;

public class TwitService {
    private TwitRepository twitRepository = new TwitRepository();

    public void save(Twit twit) {
        twitRepository.save(twit);
    }

    public void deleteById(Long id) {
        twitRepository.findById(id);
    }

    public void update(Twit twit) {
        twitRepository.update(twit);
    }

    public Twit findById(Long id) {
        return twitRepository.findById(id);
    }

    public List<Twit> findAll() {
        return twitRepository.findAll();
    }
}
