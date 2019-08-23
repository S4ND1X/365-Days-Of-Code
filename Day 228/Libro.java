//Jorge Sanchez Díaz
//A01635375
//22/08/2019

public class Libro{

    private String  titulo,
                    autor,
                    editorial,
                    isbn;
    public Libro(){

    }

    public Libro(String titulo, String autor, String editorial, String isbn){
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.isbn = isbn;
    }

    public void setTitutlo(String titulo) { this.titulo = titulo; }
    public String getTitulo() { return this.titulo; }

    public void setAutor(String autor) { this.autor = autor; }
    public String getAutor() { return this.autor;}

    public void setEditorial(String editorial) { this.editorial = editorial; }
    public String getEditorial() { return this.editorial; }

    public void setISBN(String isbn) { this.isbn = isbn; }
    public String getISBN() { return this.isbn;}



    public static void main(String[] args){
        Libro libro1 = new Libro("Harry Potter", "J.K Rowling", "Salamandra", "9780605039070");
        System.out.println(libro1.getAutor());
        System.out.println(libro1.getTitulo());
        System.out.println(libro1.getEditorial());
        System.out.println(libro1.getISBN());
    }

}