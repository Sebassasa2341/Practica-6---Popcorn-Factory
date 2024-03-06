package mx.itson.edu.practica6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView

class detalle_pelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        var tv_pelicula_image: ImageView = findViewById(R.id.tv_pelicula_imagen)
        var tv_nombre_pelicula: TextView = findViewById(R.id.tv_nombre_pelicula)
        var tv_pelicula_desc: TextView = findViewById(R.id.tv_pelicula_desc)
        val bundle = intent.extras
        var numeroAsiento = 0
        var id = -1
        var title = ""
        var setLeft: TextView = findViewById(R.id.setLeft)
        var buyTicket: Button = findViewById(R.id.buyTicket)


        if(bundle!=null){
            numeroAsiento = bundle.getInt("numberSeats")
            title = bundle.getString("titulo")!!
            tv_pelicula_image.setImageResource(bundle.getInt("header"))
            tv_nombre_pelicula.setText(bundle.getString("titulo"))
            tv_pelicula_desc.setText(bundle.getString("sinopsis"))
            setLeft.setText("$numeroAsiento Seats Available")
            id = bundle.getInt("pos")

        }

        if(numeroAsiento==0){
            buyTicket.isEnabled = false
        }else{
            buyTicket.isEnabled = true
            buyTicket.setOnClickListener{
                val intent: Intent = Intent(this, SeatSelection::class.java)

                intent.putExtra("id", id)
                intent.putExtra("name", title)

                this.startActivity(intent)
            }
        }
    }
}