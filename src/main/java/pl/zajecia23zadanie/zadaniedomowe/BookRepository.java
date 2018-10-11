package pl.zajecia23zadanie.zadaniedomowe;

import org.springframework.stereotype.Repository;
import pl.zajecia23zadanie.zadaniedomowe.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
    public List<Book> getAllByTitle() {
        TypedQuery<Book> query = entityManager.createQuery("select b from Book b order by b.title", Book.class);
        List<Book> movies = query.getResultList();
        return movies;
    }
    public List<Book> getAllByIsbn() {
        TypedQuery<Book> query = entityManager.createQuery("select b from Book b order by b.isbn", Book.class);
        List<Book> movies = query.getResultList();
        return movies;
    }
    public List<Book> getAllByDate() {
        TypedQuery<Book> query = entityManager.createQuery("select b from Book b order by b.releaseDate", Book.class);
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

    public void deleteBook(Long id){
        entityManager.getTransaction().begin();
        entityManager.remove(getByID(id));
        entityManager.getTransaction().commit();
    }

    public void edit(Book book){
        entityManager.getTransaction().begin();
        entityManager.persist(editBook(book));
        entityManager.getTransaction().commit();
    }

    private Book editBook(Book book){
        Long id = book.getId();
        Book editBook = getByID(id);
        editBook.setTitle(book.getTitle());
        editBook.setDescription(book.getDescription());
        editBook.setReleaseDate(book.getReleaseDate());
        editBook.setCategory(book.getCategory());
        editBook.setIsbn(book.getIsbn());
        return editBook;
    }



}
