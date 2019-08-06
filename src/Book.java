public class Book {
    private int id;
    private String name;
    private String author;
    private String type;
    private String publisher;

    public Book(int id, String name, String author, String type, String publisher) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.type = type;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

}


