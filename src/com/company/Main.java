package com.company;
import org.jsoup.*;
import org.jsoup.nodes.Document;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        Connection  connection = Jsoup.connect("http://localhost:8000/");
        connection.data("msid","1534626939.70181.22889.18571");
        connection.data("text","test");
        connection.method(Connection.Method.POST);

        Connection.Response r = connection.execute();
        Document doc = r.parse();
                String title = doc.title();
        System.out.println(title);
        System.out.println(connection.request().data());
        System.out.println(r.headers());
        System.out.println("*********");
        System.out.println(doc.html());

        System.out.println("Hello");
	// write your code here
    }
}
