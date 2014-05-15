package sv.ues.fia.serviciosocialfia;



import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AutorizarProyectos extends Activity {
	// creo una lista donde guardare los proyectos que saque de la consulta
	public ArrayList<String> listaProyectos = new ArrayList<String>();
	public ArrayList<String> idproy =new ArrayList<String>();
	
	//CREAMOS EL HELPER
BDControl	helper; 
	String[] roles = {"Estudiante", "Tutor","Director","LlenarBD(Para pruebas)"};
	//Me ayudara a Llenar el ListView con los protyectos que reciba de la base
	ListView llenarlista ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_autorizar_proyectos);
		
		//HACEMOS LA CONSULTA
		helper = new BDControl(this);
	
		helper.consultarProyecto("P",listaProyectos,idproy);
		
	//finaliza la consulta
		
		llenarlista=(ListView)findViewById(R.id.listProyectosPendientes);
		//PRUEBA PARA VER SI SE LLENA LA LISTA CON TODOS LOS VALORES
		AlertDialog alertDialog;
		alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setTitle("Numero de registros encontradors");
		alertDialog.setMessage("Nº:"+listaProyectos.size());
		alertDialog.show();
		
		//llenamos el listview
		
		 ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaProyectos);
		    llenarlista.setAdapter(adaptador);
		   
		    
		    //Al hacer click en algun elemento realice la accion
		    // ListView Item Click Listener
            llenarlista.setOnItemClickListener(new OnItemClickListener() {
 
                  @Override
                  public void onItemClick(AdapterView<?> parent, View view,
                     int position, long id) {
                    
                   // ListView Clicked item index
                   int itemPosition     = position;
                   
                   // ListView Clicked item value
                   String  itemValue    = (String) llenarlista.getItemAtPosition(position);
                  
                      
                    // Show Alert 
                    Toast.makeText(getApplicationContext(),
                      "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                      .show();
                    AprobarReprobarProyecto.idproyecto=idproy.get(position);
                  //Abrimos el activity donde se mostrara el proyecto seleccionado
                    Intent AbrirActAproReproP = new Intent(AutorizarProyectos.this, AprobarReprobarProyecto.class);
                    startActivity(AbrirActAproReproP );
                   
                    
                
                  }
    
             }); 
		    
	}
	

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.autorizar_proyectos, menu);
		return true;
	}
	
	

}
