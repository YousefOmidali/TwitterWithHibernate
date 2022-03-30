package Entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;

    @ManyToOne
    private Twit twit;

    @ManyToOne
    private Account account;

    public Comment(String comment, Twit twit, Account account) {
        this.comment = comment;
        this.twit = twit;
        this.account = account;
    }
}
