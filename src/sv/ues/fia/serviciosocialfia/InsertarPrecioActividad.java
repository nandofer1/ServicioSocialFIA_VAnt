package sv.ues.fia.serviciosocialfia;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class InsertarPrecioActividad extends Activity {
	//Lista con los tipos de actividades
ArrayList<String>ListaActividades=new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insertar_precio_actividad);
		//LLENAMOS LA LISTA CON LAS ACTIVIDADES
		ListaActividades.add("Servicio Social");
		ListaActividades.add("Apoyo a la investigaci�n cient�fica");
		ListaActividades.add("Pasant�as");
		ListaActividades.add("Voluntariado");
		ListaActividades.add("Pr�cticas profe sionales");
		ListaActividades.add("Extensi�n cultural");
		ListaActividades.add("Transferencia de tecnolog�a");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.insertar_precio_actividad, menu);
		return true;
	}

}
