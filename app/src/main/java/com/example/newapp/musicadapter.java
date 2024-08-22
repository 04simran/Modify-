package com.example.newapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class musicadapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<musiccmodel> myarraylist;

  private   MediaPlayer mediaPlayer;
  private  boolean flag= true;

    public musicadapter(Context context, int layout, ArrayList<musiccmodel> myarraylist) {
        this.context = context;
        this.layout = layout;
        this.myarraylist = myarraylist;
    }

    @Override
    public int getCount() {
        return myarraylist.size();
    }

    @Override
    public Object getItem(int position) {
        return myarraylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public  class ViewHolder{
        TextView  textview_song , textView_artist;
        ImageView imageView_play, imageView_stop,imageView_music, imageView_pause;
        private  View convertview;
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        public ViewHolder(){
            convertview = layoutInflater.inflate(layout, null);
            textview_song = convertview.findViewById(R.id.text_songs);
            textView_artist = convertview.findViewById(R.id.text_artist);
            imageView_play = convertview.findViewById(R.id.image_play);
            imageView_stop = convertview.findViewById(R.id.image_stop);
            imageView_pause = convertview.findViewById(R.id.image_pause);
            imageView_music = convertview.findViewById(R.id.imageview_music);
        }

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final  ViewHolder viewHolder = new ViewHolder();
        if(convertView == null){
            convertView = viewHolder.convertview;
        }else {

        }
            final  musiccmodel music = myarraylist.get(position);
            viewHolder.textview_song.setText(music.getSongName());
            viewHolder.textView_artist.setText(music.getArtist());
            viewHolder.imageView_music.setImageResource(music.getImgurl());
            viewHolder.imageView_play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                       if(flag){
                           mediaPlayer = MediaPlayer.create(context, music.getSongs());
                           flag = false;
                           viewHolder.imageView_play.setImageResource(R.drawable.afterclickplay);
                           viewHolder.imageView_pause.setImageResource(R.drawable.pause);
                           viewHolder.imageView_stop.setImageResource(R.drawable.stop);
                       }
                       mediaPlayer.start();
                    viewHolder.imageView_play.setImageResource(R.drawable.afterclickplay);
                    viewHolder.imageView_pause.setImageResource(R.drawable.pause);
                    viewHolder.imageView_stop.setImageResource(R.drawable.stop);

                }
            });

        viewHolder.imageView_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    flag=true;
                    viewHolder.imageView_stop.setImageResource(R.drawable.afterclickstop);
                    viewHolder.imageView_pause.setImageResource(R.drawable.pause);
                    viewHolder.imageView_play.setImageResource(R.drawable.play);

                }

            }
        });
        viewHolder.imageView_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag){
                    mediaPlayer.pause();
                    viewHolder.imageView_pause.setImageResource(R.drawable.afterclickpause);
                    viewHolder.imageView_play.setImageResource(R.drawable.play);
                    viewHolder.imageView_stop.setImageResource(R.drawable.stop);

                }

            }
        });
        return convertView;
    }
}
