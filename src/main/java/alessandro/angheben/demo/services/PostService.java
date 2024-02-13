package alessandro.angheben.demo.services;

import alessandro.angheben.demo.entities.Post;
import alessandro.angheben.demo.exceptions.NotFoudEx;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Service
public class PostService {

    private List<Post> posts = new ArrayList<>();

    public Post save(Post body){
        Random rnd = new Random();
        body.setId(rnd.nextInt(1,3000));
        body.setTimeToRead(rnd.nextInt(1,10));
        this.posts.add(body);
        return body;
    }

    public Post findById(int id) {
        Post found = null;
        for (int i = 0; i < posts.size(); i++) {
            if(posts.get(i).getId() == id) {
                found = posts.get(i);
            }
        }
        if(found == null) throw new NotFoudEx(id);
        return found;
    }

    public Post findByIdAndUpdate(int id, Post body) {
        Post found = null;
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId() == id) {
                found = posts.get(i);
                found.setCategory(body.getCategory());
                found.setTitle(body.getTitle());
                found.setContent(body.getContent());
                found.setTimeToRead(body.getTimeToRead());
            }
        }
        if (found == null) throw new NotFoudEx(id);
        return found;
    }

    public void findByIdAndDelete(int id) {
        Post found = this.findById(id);
        for (int i = 0; i < posts.size(); i++) {
            if(posts.get(i).getId() == found.getId()) {
                posts.remove(found);
            }
        }
    }


}
