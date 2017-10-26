package io.github.benkoff.spring5webapp.bootsrap;

import io.github.benkoff.spring5webapp.model.Author;
import io.github.benkoff.spring5webapp.model.Book;
import io.github.benkoff.spring5webapp.model.Publisher;
import io.github.benkoff.spring5webapp.repositories.AuthorRepository;
import io.github.benkoff.spring5webapp.repositories.BookRepository;
import io.github.benkoff.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Ben on 2017-10-18.
 */

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(
            BookRepository bookRepository,
            AuthorRepository authorRepository,
            PublisherRepository publisherRepository
    ) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEventEvent) {
        initData();
    }

    private void initData() {
        initAndSaveToRepositories(
                "Eric","Evans",
                "Domain Driven Design", "1234",
                "Harper Collins", ""
        );
        initAndSaveToRepositories(
                "Rod", "Johnson",
                "J2EE Development without EJB", "23444",
                "Wrox", ""
        );

    }

    private void initAndSaveToRepositories(
            String authorFirstName,
            String authorLastName,
            String bookTitle,
            String bookIsbn,
            String bookPublisherName,
            String bookPublisherAddress
    ) {
        Author author = new Author(authorFirstName, authorLastName);
        Publisher publisher = new Publisher(bookPublisherName, bookPublisherAddress);
        Book book = new Book(bookTitle, bookIsbn, publisher);

        author.getBooks().add(book);
        book.getAuthors().add(author);

        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher);
    }
}
