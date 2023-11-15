
package com.brights.zwitscher;

import com.brights.zwitscher.artikel.Artikel;
import com.brights.zwitscher.artikel.ArtikelRepository;
import com.brights.zwitscher.user.User;
import com.brights.zwitscher.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;
    private ArtikelRepository artikelRepository;

    @Autowired
    public DataLoader(UserRepository userRepository, ArtikelRepository artikelRepository) {
        this.userRepository = userRepository;
        this.artikelRepository = artikelRepository;
    }

    public void run(ApplicationArguments args) {
        // Create user
        User user1= new User("user1","123456","jffjf");
        userRepository.save(user1);

        // Create admin
        User user2= new User("admin","12345","JFJSDFJS");
        user2.setAdmin(true);
        userRepository.save(user2);

        //create blogpost
        Artikel artikel= new Artikel();
        artikel.setTitel("was geht");
        artikel.setText("hey");
        artikel.setUrl("hdhhdah");
        artikel.setUser(user1);
        artikelRepository.save(artikel);

        Artikel artikel2= new Artikel();
        artikel2.setTitel("was geht");
        artikel2.setText("hey");
        artikel2.setUrl("hdhhdah");
        artikel2.setUser(user1);
        artikelRepository.save(artikel2);

        Artikel artikel3= new Artikel();
        artikel3.setTitel("was geht");
        artikel3.setText("hey");
        artikel3.setUrl("hdhhdah");
        artikel3.setUser(user1);
        artikelRepository.save(artikel3);
    }
}

