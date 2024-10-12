package dev.VictorO.parcialdamormeo20100835

import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import dev.VictorO.parcialdamormeo20100835.databinding.ActivityMenuNavigationBinding

class MenuActivityNavigation : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMenuNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMenuActivityNavigation.toolbar)

        binding.appBarMenuActivityNavigation.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController =
            findNavController(R.id.nav_host_fragment_content_menu_activity_navigation)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        // Aplico la logica aquí
        val buttonCalcular = findViewById<Button>(R.id.ButtonCalcularPresupuesto)
        val CostoVueloPresupuesto = findViewById<EditText>(R.id.CostoVuelotext)
        val CostoAlojamientoPresupuesto = findViewById<EditText>(R.id.costoAlojamientoText)
        val CantidadNochesPresupuesto = findViewById<EditText>(R.id.CantidadNochesText)
        val CostoDiarioComidaPresupuesto = findViewById<EditText>(R.id.CostoDiarioComidaText)
        val salida1 = findViewById<TextView>(R.id.salidaPresupuestoText)


        buttonCalcular.setOnClickListener {
            // Acción a realizar al hacer clic en el botón
            val costovuelo = CostoVueloPresupuesto.text.toString().toDouble()
            val costoalojamiento = CostoAlojamientoPresupuesto.text.toString().toDouble()
            val cantidadnoches = CantidadNochesPresupuesto.text.toString().toDouble()
            val costodicomida = CostoDiarioComidaPresupuesto.text.toString().toDouble()
            val respuesta = (costovuelo + (costoalojamiento * cantidadnoches) + (cantidadnoches * costodicomida))
            salida1.text = "El presupuesto total es de: " + respuesta.toString() + "USD"
        }



        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_activity_navigation, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController =
            findNavController(R.id.nav_host_fragment_content_menu_activity_navigation)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}