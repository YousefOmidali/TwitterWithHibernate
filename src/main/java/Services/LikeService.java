package Services;

import Entity.Liking;
import Entity.Replay;
import Repository.LikeRepository;
import Repository.ReplayRepository;

public class LikeService {
    private LikeRepository likeRepository = new LikeRepository();

    public void save(Liking like) {
        likeRepository.save(like);
    }

    public void deleteById(Long id) {
        likeRepository.findById(id);
    }

    public void update(Liking like) {
        likeRepository.update(like);
    }

    public Liking findById(Long id) {
        return likeRepository.findById(id);
    }

    public void findAll() {
        likeRepository.findAll();
    }
}
