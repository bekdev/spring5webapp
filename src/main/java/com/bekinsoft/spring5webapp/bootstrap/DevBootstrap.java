package com.bekinsoft.spring5webapp.bootstrap;

import com.bekinsoft.spring5webapp.model.Author;
import com.bekinsoft.spring5webapp.model.Book;
import com.bekinsoft.spring5webapp.repositories.AuthorRepository;
import com.bekinsoft.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        // Emma
        Author emma = new Author("Emmanuel", "Bessah");
        Book ddd = new Book("Domain Driven Design", "1234", "Haper Collins");
        emma.getBooks().add(ddd);
        ddd.getAuthors().add(emma);

        authorRepository.save(emma);
        bookRepository.save(ddd);

        // Harriet
        Author harri = new Author("Harriet", "Aboagye");
        Book j2ee = new Book("Java 2 Enterprise Edition", "23344", "Worx");
        harri.getBooks().add(j2ee);

        authorRepository.save(harri);
        bookRepository.save(j2ee);

    }
}
