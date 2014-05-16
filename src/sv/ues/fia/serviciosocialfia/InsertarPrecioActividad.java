package sv.ues.fia.serviciosocialfia;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class InsertarPrecioActividad extends Activity {
	//Lista con los tipos de actividades
ArrayList<String>NombreTipo=new ArrayList<String>();
ArrayList<String>idTipo=new ArrayList<String>();
Spinner Listanombres;
BDControl helper=new BDControl(this);

//TipoDeTrabajo tipodetrabajo=new TipoDeTrabajo();

//llenamos el listview



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insertar_precio_actividad);
		helper.consultarTipoTrabajo(NombreTipo, idTipo);
		Listanombres=(Spinner)findViewById(R.id.CspinnerTipoTrabajo);
		//llenamos el combobox
	
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, NombreTipo);
		   Listanombres.setAdapter(adaptador);
		   
		   Listanombres.setOnItemSelectedListener(new OnItemSelectedListener() {

			   
			   
			   /*public void onItemClick(AdapterView<?> parent, View view,
	                     int position, long id) {
				   
			   }*/
			   
			   
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				// Spinner  item selected index
                int itemPosition     = position;
                
                // sSpinner selected item value
                String  itemValue    = (String) idTipo.get(itemPosition);
               
                   
                 // Show Alert 
                 Toast.makeText(getApplicationContext(),
                   "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                   .show();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			   
			  
		});
		   
		   
	
   
          
		    
		  
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.insertar_precio_actividad, menu);
		return true;
	}

}
