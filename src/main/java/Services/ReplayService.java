package Services;

import Entity.Replay;
import Repository.ReplayRepository;

public class ReplayService {
    private ReplayRepository replayRepository = new ReplayRepository();

    public void save(Replay replay) {
        replayRepository.save(replay);
    }

    public void deleteById(Long id) {
        replayRepository.findById(id);
    }

    public void update(Replay replay) {
        replayRepository.update(replay);
    }

    public Replay findById(Long id) {
        return replayRepository.findById(id);
    }

    public void findAll() {
        replayRepository.findAll();
    }
}
