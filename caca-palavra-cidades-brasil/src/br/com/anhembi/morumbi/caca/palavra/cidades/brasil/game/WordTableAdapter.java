package br.com.anhembi.morumbi.caca.palavra.cidades.brasil.game;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import br.com.anhembi.morumbi.caca.palavra.cidades.brasil.R;
import br.com.anhembi.morumbi.caca.palavra.cidades.brasil.prefs.Constants;
import br.com.anhembi.morumbi.caca.palavra.cidades.brasil.prefs.Settings;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;


public class WordTableAdapter extends BaseAdapter implements ListAdapter {

    private Locale locale;
    private Set<Word> correctWords;
    private Context context;
    private List<Word> words;

    public WordTableAdapter(Context ctx, List<Word> wordList) {
        context = ctx;
        words = wordList;
        correctWords = new HashSet<>();
        String localeCode = Settings.getStringValue(context, context.getString(R.string.pref_key_language), Constants.DEFAULT_LANGUAGE);
        locale = new Locale(localeCode);
    }

    public int getCount() {
        return words.size();

    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    public void setWordsFound(Set<Word> words) {
        correctWords.addAll(words);
    }

    public void setWordFound(Word word) {
        correctWords.add(word);
        notifyDataSetChanged();
    }

    public Object getItem(int position) {
        return words.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(context).inflate(R.layout.word_item, null);
        }

        Word word = (Word) getItem(position);
        TextView tv = (TextView) v.findViewById(R.id.txt_word);
        v.setFocusable(false);
        tv.setFocusable(false);
        String wordStr = word.getText().toUpperCase(locale);
        //wordStr = wordStr.substring(0, 1).toUpperCase(locale) + wordStr.substring(1);
        tv.setText(wordStr);
        if (!correctWords.contains(word)) {
            tv.setTypeface(Typeface.DEFAULT_BOLD);
            tv.setPaintFlags(tv.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            tv.setTypeface(Typeface.DEFAULT);
            tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }

        return v;
    }
}
