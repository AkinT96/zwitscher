/*

package com.brights.zwitscher;

import com.brights.zwitscher.artikel.Artikel;
import com.brights.zwitscher.artikel.ArtikelRepository;
import com.brights.zwitscher.artikel.KommentarRepository;
import com.brights.zwitscher.artikel.Kommentar;
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
    private KommentarRepository kommentarRepository;

    @Autowired
    public DataLoader(UserRepository userRepository, ArtikelRepository artikelRepository, KommentarRepository kommentarRepository) {
        this.userRepository = userRepository;
        this.artikelRepository = artikelRepository;
        this.kommentarRepository = kommentarRepository;
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

        // erstelle Kommentare
        Kommentar komm1 = new Kommentar("Kommentar 1", user1, artikel);
        Kommentar komm2 = new Kommentar("Kommentar 2.......", user1,artikel);
        Kommentar komm3 = new Kommentar("Kommentar 3.........................", user1,artikel2);
        Kommentar komm4 = new Kommentar("Hallo dies ist mein Kommentar!!!!!!!!!!!", user2, artikel);
        kommentarRepository.save(komm1);
        kommentarRepository.save(komm2);
        kommentarRepository.save(komm3);
        kommentarRepository.save(komm4);
    }
}

*/
