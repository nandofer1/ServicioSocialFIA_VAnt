package sv.ues.fia.serviciosocialfia;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.widget.TextView;

public class AprobarReprobarProyecto extends Activity {
	TextView NombreProyecto;
public static String idproyecto;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aprobar_reprobar_proyecto);
	
		
		NombreProyecto=(TextView)findViewById(R.id.ClblContenidoNombreProyecto);
		
		NombreProyecto.setText(idproyecto);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.aprobar_reprobar_proyecto, menu);
		return true;
	}

}
