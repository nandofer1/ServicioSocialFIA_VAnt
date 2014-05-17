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

public class ConsultarTipodeTrabajoActivity extends Activity {
	
	ListView listaTipoTrabajo;
	BDControl helper;
	ArrayList<String>Tipo=new ArrayList<String>();
	ArrayList<String>idTipo=new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_consultar_tipode_trabajo);
		listaTipoTrabajo=(ListView)findViewById(R.id.ClistViewMostrarTipoDeTrabajo);
		
		
		helper = new BDControl(this);
		helper.consultarTipoTrabajo(Tipo, idTipo);
		

		//llenamos el listview
		
		 ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Tipo);
		    listaTipoTrabajo.setAdapter(adaptador);
		    
		    SeleccionarItem();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.consultar_tipode_trabajo, menu);
		return true;
	}
	
	
	public void SeleccionarItem()
	{
		//Al hacer click en algun elemento realice la accion
	    // ListView Item Click Listener
        listaTipoTrabajo.setOnItemClickListener(new OnItemClickListener() {

              @Override
              public void onItemClick(AdapterView<?> parent, View view,
                 int position, long id) {
                
               // ListView Clicked item index
               int itemPosition     = position;
               
               // ListView Clicked item value
               String  itemValue    = idTipo.get(itemPosition);
              
                  
                // Show Alert 
                Toast.makeText(getApplicationContext(),
                  "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                  .show();
                ModElimTipoTrabajo idp=new ModElimTipoTrabajo();
                idp.idtipotrabajo=itemValue;
              //Abrimos el activity donde se mostrara el Tipo trabajo seleccionado
                Intent AbrirActAModElimPreciosActividad = new Intent(ConsultarTipodeTrabajoActivity.this, ModElimTipoTrabajo.class);
                startActivity(AbrirActAModElimPreciosActividad );
              //Cerramos este activity
                finish();
                
            
              }

         }); 
		
		
	}

}
