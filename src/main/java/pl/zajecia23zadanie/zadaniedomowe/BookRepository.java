package pl.zajecia23zadanie.zadaniedomowe;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class BookRepository {

    private EntityManager entityManager;

    public BookRepository(EntityManagerFactory entityManagerFactory) {
        entityManager = entityManagerFactory.createEntityManager();
    }

    public List<Book> getAll() {
        TypedQuery<Book> query = entityManager.createQuery("select b from Book b", Book.class);
        List<Book> movies = query.getResultList();
        return movies;
    }

    public Book getByID(Long id) {
        Book book = entityManager.find(Book.class, id);
        return book;
    }
    public Book getByIsbn(int isbn) {
        Book book = entityManager.find(Book.class, isbn);
        return book;
    }

    public void saveNewBook(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

}
