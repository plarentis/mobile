package br.com.anhembi.morumbi.caca.palavra.cidades.brasil.prefs;



import br.com.anhembi.morumbi.caca.palavra.cidades.brasil.R;
import android.os.Bundle;
import android.preference.PreferenceFragment;

public class PrefsFragment extends PreferenceFragment {




	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		// Load the preferences from an XML resource
		addPreferencesFromResource(R.xml.prefs);

	}


}