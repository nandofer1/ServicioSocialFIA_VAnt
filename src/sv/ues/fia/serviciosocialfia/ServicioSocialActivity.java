package sv.ues.fia.serviciosocialfia;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;


public class ServicioSocialActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_servicio_social);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.servicio_social, menu);
		return true;
		
	}

}
