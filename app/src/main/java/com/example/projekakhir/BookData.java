package com.example.projekakhir;

import java.util.ArrayList;

public class BookData {

    public static String[][] data = new String[][]{
            {"Perahu Kertas", "Dewi Lestari", "Romance", "8.3", "https://deelestari.com/wp-content/uploads/2014/09/perahukertas-jaketfilm.jpg"},
            {"Perahu Kertas", "Dewi Lestari", "Romance", "8.3", "https://deelestari.com/wp-content/uploads/2014/09/perahukertas-jaketfilm.jpg"},
            {"Perahu Kertas", "Dewi Lestari", "Romance", "8.3", "https://deelestari.com/wp-content/uploads/2014/09/perahukertas-jaketfilm.jpg"},
            {"Perahu Kertas", "Dewi Lestari", "Romance", "8.3", "https://deelestari.com/wp-content/uploads/2014/09/perahukertas-jaketfilm.jpg"},
            {"Perahu Kertas", "Dewi Lestari", "Romance", "8.3", "https://deelestari.com/wp-content/uploads/2014/09/perahukertas-jaketfilm.jpg"},
            {"Perahu Kertas", "Dewi Lestari", "Romance", "8.3", "https://deelestari.com/wp-content/uploads/2014/09/perahukertas-jaketfilm.jpg"}
    };

public static ArrayList<Book> getListData(){
        Book book = null;
        ArrayList<Book> list= new ArrayList<>();
        for(int i = 0; i < data.length; i++){
            book = new Book();
            book.setBook_name(data[i][0]);
            book.setBook_author(data[i][1]);
            book.setBook_genre(data[i][2]);
            book.setBook_rating(data[i][3]);
            book.setBook_picture(data[i][4]);
            list.add(book);
        }
        return list;
    }
}
