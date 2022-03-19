package Services;

import Entity.Comment;
import Repository.CommentRepository;

import java.util.List;

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

    public List<Comment> findAll(Long twit_id) {
        return commentRepository.findAll(twit_id);
    }
}
