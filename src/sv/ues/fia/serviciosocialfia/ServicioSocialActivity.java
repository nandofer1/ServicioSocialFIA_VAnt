package sv.ues.fia.serviciosocialfia;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ServicioSocialActivity extends ListActivity {
	
	String[] roles = {"Estudiante", "Tutor","Director","LlenarBD(Para pruebas)"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, roles));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.servicio_social, menu);
		return true;
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		//PRUEBAS COSME
		
		if(position==0)
		{
			Intent act = new Intent(this, AutorizarProyectos.class);
			 
			 startActivity(act);
			
		}
		if(position==2)
		{
			Intent act = new Intent(this, GestionPrecios.class);
			 
			 startActivity(act);
			
		}
		
		
		//PRUEBA COSME PROYECTO
		

		
		//Código provisional para llenar la BD y hacer pruebas
		if(position == 3){
			//A modo de prueba ingresare algunos datos
			//en la tabla TUTOR
			
			Proyecto proyecto = new Proyecto();
			proyecto.setIdProyecto("C000");
			proyecto.setIdBeneficiario("cb31234");
			proyecto.setCarnetEmpleado("cm310005");
			
		proyecto.setIdExpediente("Alguien4");
			proyecto.setIdTipoProyecto("exraoficial2");
			proyecto.setNombre("LO HICIMOS 3!!");
			proyecto.setDescripcion("AJADAJSASDJADJASaJ");
			proyecto.setDuracion(300);
			proyecto.setFechaInicio("15/06/2014");
			proyecto.setFechaFin("11/06/2014");
			proyecto.setEstado("P");
			proyecto.setValor(505);
			//Abriré la BD
			BDControl db = new BDControl(getApplicationContext());
			//Ingreso datos
			String registrosInsertados = db.insertar(proyecto);
			
			//Cerraré la BD
			db.close();
			Toast.makeText(this,registrosInsertados,Toast.LENGTH_LONG).show();
			
		
		
		
		
		
			
		}//FIN IF
	}
	
	

}
