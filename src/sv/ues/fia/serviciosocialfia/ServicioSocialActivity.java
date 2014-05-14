package sv.ues.fia.serviciosocialfia;

import android.app.ListActivity;
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
		
		//Código provisional para llenar la BD y hacer pruebas
		if(position == 3){
			//A modo de prueba ingresare algunos datos
			//en la tabla TUTOR
			
			Tutor tutor = new Tutor();
			tutor.setApellido("Pleitez");
			tutor.setCodigoTutor("aac1234");
			tutor.setIdBeneficiario("Alguien2");
			tutor.setNombre("Raul");
			tutor.setSexo("M");
			
			//Abriré la BD
			BDControl db = new BDControl(getApplicationContext());
			//Ingreso datos
			String registrosInsertados = db.insertar(tutor);
			
			//Cerraré la BD
			db.close();
			Toast.makeText(this,registrosInsertados,Toast.LENGTH_LONG).show();
			
//			//Prueba con la tabla ALUMNOEXPEDIENTE
//			
//			AlumnoExpediente alumExpediente = new AlumnoExpediente();
//			alumExpediente.setApellido("Trujillo");
//			alumExpediente.setCarnet("PT11007");
//			alumExpediente.setCarnetEmpleado("PP11223");
//			alumExpediente.setCodCarrera("car44");
//			alumExpediente.setEmail("mail@mail.com");
//			alumExpediente.setEstado("Programando");
//			alumExpediente.setFechaAcumula("fecha");
//			alumExpediente.setFechaFinServicio("fechaFin");
//			alumExpediente.setFechaInicioServicio("fechaIni");
//			alumExpediente.setHorasAcumula(20);
//			alumExpediente.setIdBitacora("aaaa");
//			alumExpediente.setIdExpediente("expdff");
//			alumExpediente.setNombre("nombre");
//			alumExpediente.setObservaciones("observ");
//			alumExpediente.setSexo("M");
//			alumExpediente.setTelefono("000000");
//			alumExpediente.setValorServicio(120);
//			
//			//Abriré la BD
//			db = new BDControl(getApplicationContext());
//			//Ingreso datos
//			registrosInsertados = db.insertar(alumExpediente);
//			
//			//Cerraré la BD
//			db.close();
//			Toast.makeText(this,registrosInsertados,Toast.LENGTH_LONG).show();
			
			//Prueba con la tabla ALUMNOEXPEDIENTE
			
			AlumnoExpediente alumExpediente = new AlumnoExpediente();
			alumExpediente.setApellido("Pleitez Trujillo");
			alumExpediente.setCarnet("PT11007");
			alumExpediente.setCarnetEmpleado("PP11223");
			alumExpediente.setCodCarrera("car44");
			alumExpediente.setEmail("racsoraul@mail.com");
			alumExpediente.setEstado("Programando");
			alumExpediente.setFechaAcumula("fecha");
			alumExpediente.setFechaFinServicio("fechaFin");
			alumExpediente.setFechaInicioServicio("fechaIni");
			alumExpediente.setHorasAcumula(20);
			alumExpediente.setIdBitacora("aaaa");
			alumExpediente.setIdExpediente("expdff");
			alumExpediente.setNombre("Oscar Raul");
			alumExpediente.setObservaciones("observ");
			alumExpediente.setSexo("M");
			alumExpediente.setTelefono("000000");
			alumExpediente.setValorServicio(120);
			
			//Abriré la BD
			db = new BDControl(getApplicationContext());
			//Ingreso datos
			registrosInsertados = db.actualizar(alumExpediente);
			
			//Cerraré la BD
			db.close();
			Toast.makeText(this,registrosInsertados,Toast.LENGTH_LONG).show();
			
			
		}
	}
	
	

}
