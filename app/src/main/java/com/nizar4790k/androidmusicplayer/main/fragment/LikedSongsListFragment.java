package com.nizar4790k.androidmusicplayer.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nizar4790k.androidmusicplayer.R;
import com.nizar4790k.androidmusicplayer.main.connectors.SongService;
import com.nizar4790k.androidmusicplayer.main.model.Song;

import java.util.ArrayList;
import java.util.List;

public class LikedSongsListFragment extends Fragment {


    private RecyclerView mRecyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.music_activity_list,null,false);

        mRecyclerView = view.findViewById(R.id.music_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        SongService songService= new SongService(getContext());

        songService.getRecentlyPlayedTracks(() ->{});

         ArrayList<Song> songs = songService.getSongs();

        MusicAdapter adapter = new MusicAdapter(songs);
        mRecyclerView.setAdapter(adapter);

        return view;
    }





    private class MusicAdapter extends RecyclerView.Adapter<MusicHolder>{

        private List<Song> mMusicList;

        private MusicAdapter(List<Song> musicList){
            mMusicList = musicList;
        }


        @NonNull
        @Override
        public MusicHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

           LayoutInflater inflater = LayoutInflater.from(getActivity());


            return new MusicHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull MusicHolder holder, int position) {
            holder.bind(mMusicList.get(position));
        }

        @Override
        public int getItemCount() {
            return mMusicList.size();
        }
    }


    private class MusicHolder extends RecyclerView.ViewHolder{


        private TextView mTextViewArtist;
        private TextView mTextViewTitle;

        public MusicHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.music_activity_list,parent,false));
            mTextViewArtist = itemView.findViewById(R.id.textViewArtist);
            mTextViewTitle = itemView.findViewById(R.id.textViewTitle);

        }

        public void bind (Song song){

            mTextViewTitle.setText(song.getName());
            mTextViewArtist.setText(song.getId());

        }

    }



}
