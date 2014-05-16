package sv.ues.fia.serviciosocialfia;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GestionDeValuacionDeProyectosActivity extends ListActivity {
	String[] opciones = {"Gestion de Precios"};
	String[] activities = {"GestionPrecios"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opciones));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		String nombre = activities[position];
		try {
			Class<?>clase=Class.forName("sv.ues.fia.serviciosocialfia."+nombre);
			Intent intent = new Intent(this, clase);
			startActivity(intent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	

}
