package edu.unicauca.payanmapsprototipe
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.firestore.FirebaseFirestore
import java.util.jar.Manifest

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener{

    private lateinit var map: GoogleMap
    private val db = FirebaseFirestore.getInstance()

    companion object {
        const val REQUEST_CODE_LOCATION = 0
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarker()
        map.setOnMyLocationButtonClickListener(this)
        map.setOnMyLocationClickListener(this)
        enableLocation()
    }

    private fun createMarker() {
        //Vista de trafico activa en el mapa (resalta las carreteras en color verde).
        map.setTrafficEnabled(true);

        //Ubicaciones -> Guia ecologica

        val volcanPurace = LatLng(2.31463930595868, -76.39549237734506)
        map.addMarker(
            MarkerOptions()
                .position(volcanPurace)
                .title("Volcán Puracé")
                .snippet("Guía ecológica")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        map.moveCamera(CameraUpdateFactory.newLatLng(volcanPurace))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(volcanPurace, 17.5f), 4000, null)

        val termalesAguastibias = LatLng(2.3068513404855033, -76.50626168911255);
        map.addMarker(
            MarkerOptions()
                .position(termalesAguastibias)
                .title("Termales Aguasturbias")
                .snippet("Guía ecológica")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        map.moveCamera(CameraUpdateFactory.newLatLng(termalesAguastibias))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(termalesAguastibias, 17.5f), 4000, null)

        val parqueNacionalpurace = LatLng(2.1272999706125835, -76.4093892180256);
        map.addMarker(
            MarkerOptions()
                .position(parqueNacionalpurace)
                .title("Parque Nacional Puracé")
                .snippet("Guía ecológica")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        map.moveCamera(CameraUpdateFactory.newLatLng(parqueNacionalpurace))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(parqueNacionalpurace, 17.5f), 4000, null)

        val charcoDelburro = LatLng(1.6997279681573063, -77.31325264874185);
        map.addMarker(
            MarkerOptions()
                .position(charcoDelburro)
                .title("Charco del Burro")
                .snippet("Guía ecológica")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        map.moveCamera(CameraUpdateFactory.newLatLng(charcoDelburro))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(charcoDelburro, 17.5f), 4000, null)

        val tourBalboa = LatLng(2.048471925363591, -77.21760786505828);
        map.addMarker(
            MarkerOptions()
                .position(tourBalboa)
                .title("Tour Balboa")
                .snippet("Guía ecológica")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        map.moveCamera(CameraUpdateFactory.newLatLng(tourBalboa))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(tourBalboa, 17.5f), 4000, null)

        val tierrAdentro = LatLng(2.571335418446577, -76.03611812169473);
        map.addMarker(
            MarkerOptions()
                .position(tierrAdentro)
                .title("Tierra Adentro")
                .snippet("Guía ecológica")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        map.moveCamera(CameraUpdateFactory.newLatLng(tierrAdentro))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(tierrAdentro, 17.5f), 4000, null)

        //Ubicaciones -> Restaurantes
        val restauranteRanchogrande =  LatLng(2.46374596071285, -76.5890343453484);
        map.addMarker(
            MarkerOptions()
                .position(restauranteRanchogrande)
                .title("Restaurante Rancho Grande")
                .snippet("Guía Restaurantes ")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))
        map.moveCamera(CameraUpdateFactory.newLatLng(restauranteRanchogrande))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(restauranteRanchogrande, 17.5f), 4000, null)

        val restauranteCarantanta = LatLng(2.453181459293656, -76.60181498671481);
        map.addMarker(
            MarkerOptions()
                .position(restauranteCarantanta)
                .title("Restaurante Carantanta")
                .snippet("Guía Restaurantes ")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))
        map.moveCamera(CameraUpdateFactory.newLatLng(restauranteCarantanta))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(restauranteCarantanta, 17.5f), 4000, null)

        val restauranteMestizo = LatLng(2.455427330198733, -76.59699955233086);
        map.addMarker(
            MarkerOptions()
                .position(tierrAdentro)
                .title("Restaurante Mestizo")
                .snippet("Guía Restaurantes")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))
        map.moveCamera(CameraUpdateFactory.newLatLng(restauranteMestizo))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(restauranteMestizo, 17.5f), 4000, null)

        //Ubicaciones -> Hoteleria
        val hotelDannmonasterio = LatLng(2.443468377406602, -76.60933299092184)
        map.addMarker(
            MarkerOptions()
                .position(hotelDannmonasterio)
                .title("Hotel Dann Monasterio")
                .snippet("Guía Hotelería")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))
        map.moveCamera(CameraUpdateFactory.newLatLng(hotelDannmonasterio))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(hotelDannmonasterio, 17.5f), 4000, null)

        val hotelSanmartin = LatLng(2.455340093132591, -76.59714347803472)
        map.addMarker(
            MarkerOptions()
                .position(hotelSanmartin)
                .title("Hotel San Martin")
                .snippet("Guía Hotelería")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))
        map.moveCamera(CameraUpdateFactory.newLatLng(hotelSanmartin))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(hotelSanmartin, 17.5f), 4000, null)

        val hotelCaminoreal = LatLng(2.441162493699364, -76.60571539090877)
        map.addMarker(
            MarkerOptions()
                .position(hotelCaminoreal)
                .title("Hotel Camino Real")
                .snippet("Guía Hotelería")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))
        map.moveCamera(CameraUpdateFactory.newLatLng(hotelCaminoreal))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(hotelCaminoreal, 17.5f), 4000, null)

        //Ubicaciones -> Discotecas
        val discotecaLatino = LatLng(2.4545689165648277, -76.5977213553342)
        map.addMarker(
            MarkerOptions()
                .position(discotecaLatino)
                .title("Discoteca Latino")
                .snippet("Guía Otros")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)))
        map.moveCamera(CameraUpdateFactory.newLatLng(discotecaLatino))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(discotecaLatino, 17.5f), 4000, null)

        val discotecaLanddisco = LatLng(2.4546750210659587, -76.60085213325415)
        map.addMarker(
            MarkerOptions()
                .position(discotecaLanddisco)
                .title("Discoteca Land Disco")
                .snippet("Guía Otros")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)))
        map.moveCamera(CameraUpdateFactory.newLatLng(discotecaLanddisco))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(discotecaLanddisco, 17.5f), 4000, null)

        val discotecaNewyork = LatLng(2.4477228791630097, -76.58408600072745)
        map.addMarker(
            MarkerOptions()
                .position(discotecaNewyork)
                .title("Discoteca New York")
                .snippet("Guía Otros")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)))
        map.moveCamera(CameraUpdateFactory.newLatLng(discotecaNewyork))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(discotecaNewyork, 17.5f), 4000, null)

        val discotecaEgipcia = LatLng(2.4867300604423646, -76.5597725277166)
        map.addMarker(
            MarkerOptions()
                .position(discotecaEgipcia)
                .title("Discoteca Egipcia")
                .snippet("Guía Otros")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)))
        map.moveCamera(CameraUpdateFactory.newLatLng(discotecaEgipcia))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(discotecaEgipcia, 17.5f), 4000, null)

        val discotecaTropical = LatLng(2.465366986119716, -76.58765201793571)
        map.addMarker(
            MarkerOptions()
                .position(discotecaTropical)
                .title("Discoteca Tropical")
                .snippet("Guía Otros")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)))
        map.moveCamera(CameraUpdateFactory.newLatLng(discotecaTropical))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(discotecaTropical, 17.5f), 4000, null)

        val discotecaKukaramakara = LatLng(2.4650465480862263, -76.58759500747082)
        map.addMarker(
            MarkerOptions()
                .position(discotecaKukaramakara)
                .title("Discoteca Kukaramakara")
                .snippet("Guía Otros")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)))
        map.moveCamera(CameraUpdateFactory.newLatLng(discotecaKukaramakara))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(discotecaKukaramakara, 17.5f), 4000, null)


        //Ubicaciones -> Bares
        val barBendito = LatLng(2.443200250878001, -76.60158480257319)
        map.addMarker(
            MarkerOptions()
                .position(barBendito)
                .title("Bar Bendito")
                .snippet("Guía Otros")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)))
        map.moveCamera(CameraUpdateFactory.newLatLng(barBendito))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(barBendito, 17.5f), 4000, null)

        val barMonk = LatLng(2.444652794662629, -76.60381008054766)
        map.addMarker(
            MarkerOptions()
                .position(barMonk)
                .title("Bar Monk")
                .snippet("Guía Otros")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)))
        map.moveCamera(CameraUpdateFactory.newLatLng(barMonk))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(barMonk, 17.5f), 4000, null)

        val barOvejanegra = LatLng(2.4536460212069486, -76.60339194305712)
        map.addMarker(
            MarkerOptions()
                .position(barOvejanegra)
                .title("Bar Oveja Negra")
                .snippet("Guía Otros")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)))
        map.moveCamera(CameraUpdateFactory.newLatLng(barOvejanegra))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(barOvejanegra, 17.5f), 4000, null)

        val barBBC = LatLng(2.453558779203148, -76.60080450564456)
        map.addMarker(
            MarkerOptions()
                .position(barBBC)
                .title("Bar BBC")
                .snippet("Guía Otros")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)))
        map.moveCamera(CameraUpdateFactory.newLatLng(barBBC))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(barBBC, 17.5f), 4000, null)

        val barElcantodelarana = LatLng(2.4425211964657834, -76.609953293839)
        map.addMarker(
            MarkerOptions()
                .position(barElcantodelarana)
                .title("Bar El Canto De La Rana")
                .snippet("Guía Otros")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)))
        map.moveCamera(CameraUpdateFactory.newLatLng(barElcantodelarana))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(barElcantodelarana, 17.5f), 4000, null)


        //Ubicaciones -> Eventos
        val carnavalesDepubenza = LatLng(2.455379334893284, -76.59192141422201)
        map.addMarker(
            MarkerOptions()
                .position(carnavalesDepubenza)
                .title("Carnavales de Pubenza")
                .snippet("Guía Eventos - Sede Principal")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))
        map.moveCamera(CameraUpdateFactory.newLatLng(carnavalesDepubenza))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(carnavalesDepubenza, 17.5f), 4000, null)

        val carnavalesDepubenza2 = LatLng(2.4481679431805694, -76.60320143067679)
        map.addMarker(
            MarkerOptions()
                .position(carnavalesDepubenza2)
                .title("Carnavales de Pubenza")
                .snippet("Guía Eventos - Sede Artística")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))
        map.moveCamera(CameraUpdateFactory.newLatLng(carnavalesDepubenza2))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(carnavalesDepubenza2, 17.5f), 4000, null)

        val semanaSanta = LatLng(2.4420975449321536, -76.60624905470605)
        map.addMarker(
            MarkerOptions()
                .position(semanaSanta)
                .title("Semana Santa")
                .snippet("Guía Eventos: Sede Princiapl")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))
        map.moveCamera(CameraUpdateFactory.newLatLng(semanaSanta))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(semanaSanta, 17.5f), 4000, null)

        val congresoGastronomico = LatLng(2.4419034877587786, -76.60666380886751)
        map.addMarker(
            MarkerOptions()
                .position(congresoGastronomico)
                .title("Congreso Gastronómico")
                .snippet("Guía Eventos: Sede Principal")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))
        map.moveCamera(CameraUpdateFactory.newLatLng(congresoGastronomico))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(congresoGastronomico, 17.5f), 4000, null)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun itsLocationPermissionGranted() = ContextCompat.checkSelfPermission(
        this,
        android.Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED


    private fun enableLocation() {
        if (!::map.isInitialized) return
        if (itsLocationPermissionGranted()) {
            map.isMyLocationEnabled = true
        } else {
            requestLocationPermission()
        }
    }

    private fun requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
        ) {
            Toast.makeText(
                this,
                "Por favor, ir a ajustes y aceptar los permisos ",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_CODE_LOCATION
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            REQUEST_CODE_LOCATION -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                map.isMyLocationEnabled = true
            } else {
                Toast.makeText(
                    this,
                    "Para activar la localizacion ve a ajustes y acepta los permisos",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else -> {}

        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        if (!::map.isInitialized) return
        if(!itsLocationPermissionGranted()){
            map.isMyLocationEnabled = false
            Toast.makeText(
                this,
                "Por favor, ir a ajustes y aceptar los permisos ",
                Toast.LENGTH_SHORT).show()
        }
    }

    override fun onMyLocationButtonClick(): Boolean {
        Toast.makeText(this, "¡Boton pulsado!", Toast.LENGTH_SHORT).show()
        return false
    }

    override fun onMyLocationClick(p0: Location) {
        Toast.makeText(this, "Tu ubicación es: ${p0.latitude}, ${p0.longitude}", Toast.LENGTH_SHORT).show()

    }

}