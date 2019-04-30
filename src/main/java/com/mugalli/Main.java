package com.mugalli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws SQLException,ClassNotFoundException{
        persistBook(new Book(5000L, "H2G2","Best IT book",12.5f,"1234567zu"));

    }

    static {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException{
        String url = "jdbc:derby://myhost.mydomain.com:1527/mydb;create=true";
        return DriverManager.getConnection(url,"app","app");
    }

    private static void persistBook(Book bookk) throws SQLException{
        String query = "INSERT INTO BOOK(ID,TITLE,DESCRE,UNICOST,ISBN )VALUE(?,?,?,?,?)";
        try(PreparedStatement stmt = getConnection().prepareStatement(query)){
            stmt.setLong(1,bookk.getId());
            stmt.setString(2,bookk.getTitle());
            stmt.setString(3,bookk.getDescrptions());
            stmt.setFloat(4,bookk.getUniCoast());
            stmt.setString(5,bookk.getIsbn());

            stmt.executeUpdate();
        }

    }





        /*
        Book book = new Book(2019L,"Clean Code","this book is for software developer",30);
        BookService service = new BookService();

        //Author author = new Author(23L,"Gayle","Mcdowel","she is ver famous author",new Date(06.09.1970),)

        //create and presist a book
        service.createBook(book);
        System.out.println(book);

        // find the book
        service.findBook(2019L);
        System.out.println("Book Found :"+book);

        //update the book
        service.updaprice(2019L,39);
        System.out.println("price is updated:"+ book);

        //delete the book
        service.removeBook(2019L);
        System.out.println("Book Removed "+ book);
*/
}


