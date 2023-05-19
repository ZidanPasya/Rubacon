package com.example.projekakhir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CardViewBookAdapter extends RecyclerView.Adapter<CardViewBookAdapter.CardViewViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;
    private ArrayList<Book> bookList;

    private Context context;

    public CardViewBookAdapter(Context context, RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    public ArrayList<Book> getBookList(){
        return bookList;
    }

    public void setBookList(ArrayList<Book> bookList){
        this.bookList = bookList;
    }

    @Override
    public CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        CardViewViewHolder viewHolder = new CardViewViewHolder(view, recyclerViewInterface);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewViewHolder holder, int position) {
        Book b = getBookList().get(position);
        Glide.with(context).load(b.getBook_picture()).override(350, 550).into(holder.book_image);
        holder.book_name.setText(b.getBook_name());
        holder.book_author.setText(b.getBook_author());
        holder.book_genre.setText(b.getBook_genre());
        holder.book_rating.setText(b.getBook_rating());
    }

    public int getItemCount(){
        return getBookList().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView book_image;
        TextView book_name, book_author, book_genre, book_rating;

        public CardViewViewHolder(View itemView, RecyclerViewInterface recyclerViewInterface){
            super(itemView);
            book_image = (ImageView) itemView.findViewById(R.id.bookPic);
            book_name = (TextView) itemView.findViewById(R.id.titleBook);
            book_author = (TextView) itemView.findViewById(R.id.authorBook);
            book_genre = (TextView) itemView.findViewById(R.id.genreBook);
            book_rating = (TextView) itemView.findViewById(R.id.ratingBook);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null){
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
