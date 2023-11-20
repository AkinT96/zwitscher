

package com.brights.zwitscher;

import com.brights.zwitscher.artikel.Artikel;
import com.brights.zwitscher.artikel.ArtikelRepository;
import com.brights.zwitscher.kommentare.KommentarRepository;
import com.brights.zwitscher.kommentare.Kommentar;
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
        User user1 = new User("user1", "123456", "user@gmail.com");
        userRepository.save(user1);

// Create admin
        User user2 = new User("admin", "12345", "admin@gmail.com");
        user2.setAdmin(true);
        User user3 = new User("autoFan23", "pass123", "autofan23@gmail.com");
        User user4 = new User("speedyDriver", "drive456", "speedydriver@gmail.com");
        User user5 = new User("carEnthusiast", "carpass789", "enthusiast@gmail.com");
        User user6 = new User("roadExplorer", "explore321", "explorer@gmail.com");
        User user7 = new User("motorhead", "engine777", "motorhead@gmail.com");
        User user8 = new User("gearLover", "gear888", "gearlover@gmail.com");

        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);
        userRepository.save(user7);
        userRepository.save(user8);
        userRepository.save(user2);

// Create blogpost 1
        Artikel artikel = new Artikel();
        artikel.setTitel("BMW auf Überholspur");
        artikel.setText("BMW, die bayerische Automarke, setzt ihre Erfolgsgeschichte fort. Mit innovativen Technologien und einem klaren Fokus auf Nachhaltigkeit präsentiert BMW bahnbrechende Modelle, die die Straßen erobern. Die neuesten Entwicklungen im Bereich Elektromobilität und autonomes Fahren positionieren BMW als Vorreiter in der Automobilindustrie. Mit einem kraftvollen Design und modernster Technik bleibt BMW seinen Werten treu: Fahrspaß, Eleganz und zukunftsweisende Mobilität.");
        artikel.setUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f4/BMW_logo_%28gray%29.svg/900px-BMW_logo_%28gray%29.svg.png");
        artikel.setUser(user1);
        artikelRepository.save(artikel);

// Create blogpost 2
        Artikel artikel2 = new Artikel();
        artikel2.setTitel("VW mit einigen Umsatzeinbußen");
        artikel2.setText("Volkswagen, ein Gigant in der Automobilbranche, kämpft mit einigen Herausforderungen im Umsatz. Die Gründe hierfür können vielfältig sein, von globalen Markttrends bis hin zu internen strategischen Entscheidungen. VW bleibt dennoch entschlossen, durch Innovation und Anpassungsfähigkeit seine Position zu stärken. Die Automobilwelt verändert sich ständig, und VW setzt alles daran, sich diesen Veränderungen anzupassen und die Zukunft erfolgreich zu gestalten.");
        artikel2.setUrl("https://uploads.vw-mms.de/system/production/images/vwn/030/145/images/7a0d84d3b718c9a621100e43e581278433114c82/DB2019AL01950_retina_2000.jpg?1649155356");
        artikel2.setUser(user1);
        artikelRepository.save(artikel2);

// Create blogpost 3
        Artikel artikel3 = new Artikel();
        artikel3.setTitel("Mercedes - Fortschritt durch Technik?");
        artikel3.setText("Mercedes-Benz, ein Synonym für Luxus und deutsche Ingenieurskunst, steht im Mittelpunkt der Diskussion über Fortschritt durch Technik. Die Marke hat eine reiche Geschichte, die von Innovationen und wegweisenden Designs geprägt ist. Mercedes strebt kontinuierlich danach, Technologien zu entwickeln, die nicht nur die Leistung ihrer Fahrzeuge verbessern, sondern auch den Weg für die Zukunft der Mobilität ebnen. In einer Welt, die sich ständig verändert, bleibt Mercedes-Benz ein Symbol für Qualität und Fortschritt.");
        artikel3.setUrl("https://upload.wikimedia.org/wikipedia/de/thumb/4/45/Mercedes-Benz-Logo.svg/1116px-Mercedes-Benz-Logo.svg.png?20100324062411");
        artikel3.setUser(user1);
        artikelRepository.save(artikel3);

        // Create additional articles
        Artikel artikel4 = new Artikel();
        artikel4.setTitel("Die Zukunft der Hybridtechnologie");
        artikel4.setText("Die Hybridtechnologie hat in der Automobilindustrie stark an Bedeutung gewonnen. Automobilhersteller investieren zunehmend in Hybridfahrzeuge, die eine Kombination aus Verbrennungs- und Elektromotor bieten. Dieser Artikel wirft einen Blick auf die Entwicklung und die Zukunft der Hybridtechnologie, ihre Auswirkungen auf die Umwelt und ihre Akzeptanz bei den Verbrauchern.");
        artikel4.setUser(user3);
        artikelRepository.save(artikel4);

        Artikel artikel5 = new Artikel();
        artikel5.setTitel("Die Herausforderungen autonomer Fahrzeuge");
        artikel5.setText("Autonome Fahrzeuge versprechen eine Revolution im Straßenverkehr, aber sie stehen auch vor erheblichen Herausforderungen. Von ethischen Fragen bis hin zu technischen Schwierigkeiten müssen autonome Fahrzeuge zahlreiche Hürden überwinden. Dieser Artikel beleuchtet die aktuellen Herausforderungen, mit denen die Branche konfrontiert ist, und wirft einen Blick darauf, wie sie diese meistern könnte.");
        artikel5.setUrl("https://cdn1.vogel.de/_olJNvTfCjL3G0I5hM64Rxt-XBE=/fit-in/800x0/p7i.vogel.de/wcms/e6/06/e606c3ec7292dde5852fd0482b8e8be8/0113872076.jpeg");
        artikel5.setUser(user4);
        artikelRepository.save(artikel5);

        Artikel artikel6 = new Artikel();
        artikel6.setTitel("Die Bedeutung von Elektromobilität in Städten");
        artikel6.setText("In urbanen Zentren spielt Elektromobilität eine entscheidende Rolle bei der Reduzierung von Emissionen und dem Aufbau nachhaltiger Verkehrssysteme. Dieser Artikel untersucht, wie Elektrofahrzeuge dazu beitragen können, die Luftqualität in Städten zu verbessern, und welche Herausforderungen es bei der Integration dieser Technologie in städtische Umgebungen gibt.");
        artikel6.setUrl("https://mittlerer-niederrhein.ihk.de/de/media/grafiken/standortpolitik/elektrofahrzeug-artikel2.jpeg");
        artikel6.setUser(user5);
        artikelRepository.save(artikel6);

        Artikel artikel7 = new Artikel();
        artikel7.setTitel("Die Entwicklung von Brennstoffzellenfahrzeugen");
        artikel7.setText("Brennstoffzellenfahrzeuge gelten als vielversprechende Alternative zu herkömmlichen Antriebsarten. Dieser Artikel beleuchtet die Fortschritte in der Entwicklung von Brennstoffzellenfahrzeugen, ihre potenziellen Vorteile und die Herausforderungen, die noch überwunden werden müssen, um diese umweltfreundliche Technologie weitläufig zu etablieren.");
        artikel7.setUrl("https://www.alternativ-mobil.info/fileadmin/_processed_/c/2/csm_Schema_FCEV_64d7e48460.jpg");
        artikel7.setUser(user6);
        artikelRepository.save(artikel7);

        Artikel artikel8 = new Artikel();
        artikel8.setTitel("Die Kunst der Auto-Finanzierung: Wege zu Ihrem Traumauto");
        artikel8.setText("Die Sparkasse präsentiert sich als herausragender Partner für eine erstklassige Autofinanzierung. Mit ihrer langjährigen Erfahrung im Bankwesen und ihrem kundenorientierten Ansatz bietet die Sparkasse maßgeschneiderte Finanzierungslösungen, die auf die individuellen Bedürfnisse ihrer Kunden zugeschnitten sind. Der Prozess der Autofinanzierung wird durch transparente Konditionen und faire Zinssätze erleichtert, was das Vertrauen der Kunden stärkt.\n" +
                "\n" +
                "Die Sparkasse legt großen Wert auf eine persönliche Beratung, die den Kunden bei jedem Schritt des Finanzierungsprozesses unterstützt. Dieser Fokus auf Servicequalität spiegelt sich in zahlreichen positiven Erfahrungen wider, die Kunden mit der Sparkasse gemacht haben. Von flexiblen Rückzahlungsplänen bis hin zu unkomplizierten Antragsverfahren bietet die Sparkasse eine umfassende Palette von Dienstleistungen, um den Autokauf zu einem reibungslosen und angenehmen Erlebnis zu machen.\n" +
                "\n" +
                "Die Sparkasse beweist, dass eine Autofinanzierung nicht nur eine finanzielle Transaktion ist, sondern eine Partnerschaft, die darauf abzielt, die automobilen Träume ihrer Kunden zu verwirklichen.");
        artikel8.setUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Sparkasse.svg/207px-Sparkasse.svg.png");
        artikelRepository.save(artikel8);
// Create comments
        Kommentar komm1 = new Kommentar("Ein faszinierender Artikel über BMW! Die Marke setzt wirklich Maßstäbe in der Automobilindustrie.", user1, artikel);
        Kommentar komm2 = new Kommentar("Interessant, wie BMW auf die Herausforderungen der Zeit reagiert. Die Zukunft sieht vielversprechend aus!", user1, artikel);
        Kommentar komm3 = new Kommentar("VW hat einige Umsatzeinbußen, aber ich bin sicher, dass sie sich wieder erholen werden.", user1, artikel2);
        Kommentar komm4 = new Kommentar("BMW bleibt einfach unschlagbar in Sachen Design und Technologie.", user2, artikel);
        Kommentar komm5 = new Kommentar("Interessanter Artikel! Die Hybridtechnologie wird definitiv die Zukunft beeinflussen.", user3, artikel4);
        Kommentar komm6 = new Kommentar("Hybridfahrzeuge sind ein wichtiger Schritt in Richtung nachhaltiger Mobilität.", user4, artikel4);
        Kommentar komm7 = new Kommentar("Die Herausforderungen autonomer Fahrzeuge sind faszinierend. Ein spannendes Thema!", user5, artikel5);
        Kommentar komm8 = new Kommentar("Technologische Herausforderungen müssen überwunden werden, damit autonome Fahrzeuge erfolgreich sind.", user6, artikel5);
        Kommentar komm9 = new Kommentar("Elektromobilität in Städten ist ein Muss für eine saubere Zukunft. Guter Artikel!", user7, artikel6);
        Kommentar komm10 = new Kommentar("Wie können Städte Elektromobilität besser integrieren? Diskutieren Sie darüber!", user8, artikel6);
        Kommentar komm11 = new Kommentar("Brennstoffzellenfahrzeuge sind eine vielversprechende Technologie. Danke für den Überblick!", user3, artikel7);
        Kommentar komm12 = new Kommentar("Welche Herausforderungen gibt es bei der Infrastruktur für Brennstoffzellenfahrzeuge?", user4, artikel7);
        Kommentar komm13 = new Kommentar("Ich liebe es, wie BMW sich immer weiterentwickelt. Toller Artikel!", user1, artikel);
        Kommentar komm14 = new Kommentar("Die Umsatzeinbußen bei VW sind besorgniserregend. Hoffentlich erholen sie sich bald.", user2, artikel2);
        Kommentar komm15 = new Kommentar("Mercedes-Benz steht für Qualität und Technologie. Spannender Artikel!", user5, artikel3);
        Kommentar komm16 = new Kommentar("BMW-Fan hier! Ich freue mich auf mehr Innovationen von ihnen.", user6, artikel);
        Kommentar komm17 = new Kommentar("Unglaublich, wie sich die Automobilindustrie entwickelt. Danke für die Zusammenfassung.", user7, artikel2);
        Kommentar komm18 = new Kommentar("Autonomes Fahren wird unser Leben verändern. Bin gespannt auf die Zukunft!", user8, artikel5);
        Kommentar komm19 = new Kommentar("Interessante Einblicke in die Welt von VW. Danke für den Artikel!", user3, artikel2);
        Kommentar komm20 = new Kommentar("Mercedes-Benz bleibt die Ikone der deutschen Ingenieurskunst.", user1, artikel3);
        // Create additional comments
        Kommentar komm21 = new Kommentar("Hybridtechnologie ist definitiv auf dem Vormarsch. Toller Beitrag!", user4, artikel4);
        Kommentar komm22 = new Kommentar("Die Entwicklung autonomer Fahrzeuge ist eine faszinierende Reise. Danke für die Infos!", user7, artikel5);
        Kommentar komm23 = new Kommentar("Elektromobilität in Städten ist der Schlüssel zur nachhaltigen Zukunft.", user6, artikel6);
        Kommentar komm24 = new Kommentar("Brennstoffzellenfahrzeuge haben das Potenzial, die Art, wie wir reisen, zu revolutionieren.", user2, artikel7);
        Kommentar komm25 = new Kommentar("Ich kann es kaum erwarten, was die Zukunft der Hybridtechnologie bereithält.", user3, artikel4);
        Kommentar komm26 = new Kommentar("Autonome Fahrzeuge sind der nächste große Schritt in der Automobilbranche.", user5, artikel5);
        Kommentar komm27 = new Kommentar("Elektromobilität ist nicht nur umweltfreundlich, sondern auch wirtschaftlich.", user8, artikel6);
        Kommentar komm28 = new Kommentar("Brennstoffzellenfahrzeuge könnten eine Antwort auf die Herausforderungen der Umwelt darstellen.", user1, artikel7);
        Kommentar komm29 = new Kommentar("BMW setzt weiterhin Standards in Sachen Innovation. Beeindruckend!", user4, artikel);
        Kommentar komm30 = new Kommentar("VW muss sich strategisch neu ausrichten, um die Umsatzeinbußen zu überwinden.", user6, artikel2);
        Kommentar komm31 = new Kommentar("Mercedes-Benz verkörpert zeitlose Eleganz und technologische Exzellenz.", user3, artikel3);
        Kommentar komm32 = new Kommentar("Die BMW-Community ist leidenschaftlich und freut sich auf kommende Modelle.", user5, artikel);
        Kommentar komm33 = new Kommentar("VW hat einige Herausforderungen, aber ich bin zuversichtlich in ihre Zukunft.", user7, artikel2);
        Kommentar komm35 = new Kommentar("Die Innovationen von BMW sind wegweisend für die gesamte Automobilindustrie.", user8, artikel);
        Kommentar komm36 = new Kommentar("Interessante Einblicke in die finanzielle Seite von VW. Danke für den Artikel!", user1, artikel2);
        Kommentar komm37 = new Kommentar("Die Luxusklasse von Mercedes-Benz ist unübertroffen.", user3, artikel3);
        Kommentar komm38 = new Kommentar("Autonomes Fahren wird unseren Alltag verändern. Spannend!", user4, artikel5);
        Kommentar komm39 = new Kommentar("BMW, immer auf der Überholspur der Innovation.", user5, artikel);
        Kommentar komm40 = new Kommentar("VW muss sich auf dem Markt neu positionieren. Herausfordernde Zeiten.", user2, artikel2);
        Kommentar positivKommentar15 = new Kommentar("Sparkasse hat mir geholfen, meinen Traumwagen zu finanzieren. Ich bin wirklich beeindruckt von ihrer Professionalität.", user2, artikel8);
        Kommentar positivKommentar16 = new Kommentar("Die Sparkasse hat mein Vertrauen gewonnen. Ich würde mich jederzeit wieder für ihre Finanzierungsoptionen entscheiden.", user3, artikel8);
        Kommentar positivKommentar17 = new Kommentar("Die Sparkasse hat den Autokauf zu einer angenehmen Erfahrung gemacht. Ihr Engagement für Kunden ist spürbar.", user4, artikel8);
        Kommentar positivKommentar18 = new Kommentar("Ich schätze die Transparenz der Sparkasse. Keine versteckten Gebühren und faire Konditionen.", user5, artikel8);
        Kommentar positivKommentar19 = new Kommentar("Die Sparkasse hat mich durch den gesamten Finanzierungsprozess begleitet. Ihr Support war unschätzbar.", user6, artikel8);
        Kommentar positivKommentar20 = new Kommentar("Ich danke der Sparkasse für ihre großartige Unterstützung bei der Finanzierung meines Autos. Top-Service!", user7, artikel8);

        kommentarRepository.save(positivKommentar15);
        kommentarRepository.save(positivKommentar16);
        kommentarRepository.save(positivKommentar17);
        kommentarRepository.save(positivKommentar18);
        kommentarRepository.save(positivKommentar19);

        kommentarRepository.save(komm21);
        kommentarRepository.save(komm22);
        kommentarRepository.save(komm23);
        kommentarRepository.save(komm24);
        kommentarRepository.save(komm25);
        kommentarRepository.save(komm26);
        kommentarRepository.save(komm27);
        kommentarRepository.save(komm28);
        kommentarRepository.save(komm29);
        kommentarRepository.save(komm30);
        kommentarRepository.save(komm31);
        kommentarRepository.save(komm32);
        kommentarRepository.save(komm33);
        kommentarRepository.save(komm35);
        kommentarRepository.save(komm36);
        kommentarRepository.save(komm37);
        kommentarRepository.save(komm38);
        kommentarRepository.save(komm39);
        kommentarRepository.save(komm40);
        kommentarRepository.save(komm5);
        kommentarRepository.save(komm6);
        kommentarRepository.save(komm7);
        kommentarRepository.save(komm8);
        kommentarRepository.save(komm9);
        kommentarRepository.save(komm10);
        kommentarRepository.save(komm11);
        kommentarRepository.save(komm12);
        kommentarRepository.save(komm13);
        kommentarRepository.save(komm14);
        kommentarRepository.save(komm15);
        kommentarRepository.save(komm16);
        kommentarRepository.save(komm17);
        kommentarRepository.save(komm18);
        kommentarRepository.save(komm19);
        kommentarRepository.save(komm20);
        kommentarRepository.save(komm1);
        kommentarRepository.save(komm2);
        kommentarRepository.save(komm3);
        kommentarRepository.save(komm4);
    }
}


