package sv.ues.fia.serviciosocialfia;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ConsultarPreciosActivity extends Activity {
ListView ListaPrecios;
 ArrayList<String> listaidTipoTrabajo = new ArrayList<String>();
 ArrayList<String> listanombresTipoTrabajo = new ArrayList<String>();
 ArrayList<String> idprecios =new ArrayList<String>();
 ArrayList<String> fechaprecios =new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_consultar_precios);
		ListaPrecios=(ListView)findViewById(R.id.ClistViewConsultaPrecios);
		
		BDControl helper = new BDControl(this);
		//llenamos las listas;
		helper.consultarPrecios(listaidTipoTrabajo, idprecios, fechaprecios);
		
		    TipoDeTrabajo  tipotrabajo=new TipoDeTrabajo();
			
			//for(int i=0;i<listaidTipoTrabajo.size();i++)
		  
			for(int i=0;i<listaidTipoTrabajo.size();i++)
				
			{
				
				tipotrabajo=helper.ConsultarTipoTrabajo(listaidTipoTrabajo.get(i));
			listanombresTipoTrabajo.add(tipotrabajo.getNombreTipo()+" "+"Fecha:"+fechaprecios.get(i));
			
			}
			
			/*Toast.makeText(getApplicationContext(),
	                  "Numero iteraciones items en la lista "+listanombresTipoTrabajo.get(0) , Toast.LENGTH_LONG)
	                  .show();*/
			

			 ArrayAdapter<String> adaptador = new ArrayAdapter<String>(ConsultarPreciosActivity.this, android.R.layout.simple_list_item_1,listanombresTipoTrabajo );
			    ListaPrecios.setAdapter(adaptador);
		    
			    ListaPrecios.setOnItemClickListener(new OnItemClickListener() {
			    	 
	                  @Override
	                  public void onItemClick(AdapterView<?> parent, View view,
	                     int position, long id) {
	                    
	                   // ListView Clicked item index
	                   int itemPosition     = position;
	                   
	                   // ListView Clicked item value
	                   String  itemValue    = (String) ListaPrecios.getItemAtPosition(position);
	                  
	                      
	                    // Show Alert 
	                    Toast.makeText(getApplicationContext(),
	                      "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
	                      .show();
	                    ModElimPreciosActivity.idprecio=idprecios.get(position);
	                    ModElimPreciosActivity.nombreTipoTrabajo=listanombresTipoTrabajo.get(position);
	                  //Abrimos el activity donde se mostrara el proyecto seleccionado
	                    Intent AbrirActModElimPrecios = new Intent(ConsultarPreciosActivity.this, ModElimPreciosActivity.class);
	                    startActivity(AbrirActModElimPrecios);
	                  //Cerramos este activity
	                    finish();
	                    
	                
	                  }
	    
	             }); 
			    
		    
		    
		//ConsultarPrecios();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.consultar_precios, menu);
		return true;
	}
	
	/*public void ConsultarPrecios(){

		
		
		
		
		
	}*/

}
