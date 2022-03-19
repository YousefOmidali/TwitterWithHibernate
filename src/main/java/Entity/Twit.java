package Entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Twit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 280)
    private String twit;
    private Long likes = 0L;
    private Long disLike = 0L;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Account account;

    public Twit(String twit, Long like, Long disLike, Account account) {
        this.twit = twit;
        this.likes = like;
        this.disLike = disLike;
        this.account = account;
    }
}
