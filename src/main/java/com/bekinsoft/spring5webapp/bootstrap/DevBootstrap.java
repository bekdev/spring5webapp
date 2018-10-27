package com.bekinsoft.spring5webapp.bootstrap;

import com.bekinsoft.spring5webapp.model.Author;
import com.bekinsoft.spring5webapp.model.Book;
import com.bekinsoft.spring5webapp.model.Publisher;
import com.bekinsoft.spring5webapp.repositories.AuthorRepository;
import com.bekinsoft.spring5webapp.repositories.BookRepository;
import com.bekinsoft.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        // Emma
        Author emma = new Author("Emmanuel", "Bessah");
        Publisher hcol = new Publisher("Haper Collins", "483 Maven Street, California");
        Book ddd = new Book("Domain Driven Design", "1234", hcol);
        emma.getBooks().add(ddd);
        ddd.getAuthors().add(emma);

        authorRepository.save(emma);
        publisherRepository.save(hcol);
        bookRepository.save(ddd);

        // Harriet
        Author harri = new Author("Harriet", "Aboagye");
        Publisher worx = new Publisher("Worx", "233 Bretan Street, 554 9930, NY");
        Book j2ee = new Book("Java 2 Enterprise Edition", "23344", worx);
        harri.getBooks().add(j2ee);

        authorRepository.save(harri);
        publisherRepository.save(worx);
        bookRepository.save(j2ee);


    }
}
