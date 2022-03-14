package Services;

import Entity.Comment;
import Entity.DisLike;
import Repository.CommentRepository;
import Repository.DisLikeRepository;

public class CommentService {
    private CommentRepository commentRepository = new CommentRepository();

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteById(Long id) {
        commentRepository.findById(id);
    }

    public void update(Comment comment) {
        commentRepository.update(comment);
    }

    public Comment findById(Long id) {
        return commentRepository.findById(id);
    }

    public void findAll() {
        commentRepository.findAll();
    }
}
