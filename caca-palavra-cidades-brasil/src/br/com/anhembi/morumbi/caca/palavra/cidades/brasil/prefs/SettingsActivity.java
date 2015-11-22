package br.com.anhembi.morumbi.caca.palavra.cidades.brasil.prefs;


import android.os.Bundle;
import android.preference.PreferenceActivity;


public class SettingsActivity extends PreferenceActivity {

	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		PrefsFragment fragment = new PrefsFragment();
		getFragmentManager().beginTransaction().replace(android.R.id.content, fragment).commit();

	}



	@Override
	public void onBackPressed() {
		Settings.saveBooleanValue(SettingsActivity.this, Constants.MADE_SETTINGS, true);
		super.onBackPressed();
	}



}
