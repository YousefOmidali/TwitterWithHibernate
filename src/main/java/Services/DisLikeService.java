package Services;

import Entity.DisLike;
import Repository.DisLikeRepository;

public class DisLikeService {
    private DisLikeRepository disLikeRepository = new DisLikeRepository();

    public void save(DisLike disLike) {
        disLikeRepository.save(disLike);
    }

    public void deleteById(Long id) {
        disLikeRepository.findById(id);
    }

    public void update(DisLike disLike) {
        disLikeRepository.update(disLike);
    }

    public DisLike findById(Long id) {
        return disLikeRepository.findById(id);
    }

    public void findAll() {
        disLikeRepository.findAll();
    }
}
