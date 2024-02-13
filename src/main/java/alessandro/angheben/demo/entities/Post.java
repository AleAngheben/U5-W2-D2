package alessandro.angheben.demo.entities;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Post {
    private long id;

    private String category;

    private String title;

    private String coverUrl;

    private String content;

    private int timeToRead;
}
