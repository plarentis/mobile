package br.com.anhembi.morumbi.caca.palavra.cidades.brasil.game;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

import java.util.HashSet;
import java.util.Set;


class GameStatus extends View.BaseSavedState {

    public Set<Word> foundWords;



    GameStatus() {
        super(Parcel.obtain());
        foundWords = new HashSet<>();
    }

    private GameStatus(Parcel in) {
        super(in);
        foundWords = new HashSet<>();
        Parcelable[] parcels = in.readParcelableArray(Word.class.getClassLoader());
        for (Parcelable parcel : parcels) {
            foundWords.add((Word) parcel);
        }

    }

    GameStatus(Parcelable parcelable) {
        super(parcelable);
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelableArray(foundWords.toArray(new Word[]{}), flags);
    }



    @SuppressWarnings("unused")
    public static final Creator<GameStatus> CREATOR =  new Creator<GameStatus>() {

        public GameStatus createFromParcel(Parcel source) {
            return new GameStatus(source);
        }

        public GameStatus[] newArray(int size) {
            return new GameStatus[size];
        }
    };

}
