package br.com.anhembi.morumbi.caca.palavra.cidades.brasil.info;



import br.com.anhembi.morumbi.caca.palavra.cidades.brasil.R;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;


public class InfoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ActionBar actionBar = getActionBar();
		if(actionBar != null)
			actionBar.hide();

		setContentView(R.layout.activity_info);
	}
}
