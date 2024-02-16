package com.nandhu.onedatabluetoothapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nandhu.onedatabluetoothapp.Dataclass.CountryList
import com.nandhu.onedatabluetoothapp.R
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone


class CountryListAdapter(var context: Context, var countryList: List<CountryList>) : RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.countrylist_layout,parent,false)

        return CountryViewHolder(view)


    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        holder.country_name.setText("CountryName :"+ " "+countryList.get(position).name)
        holder.country_captial.setText("CountryCapital :"+ " "+countryList.get(position).capital)
        holder.country_region.setText("CountryRegion :"+ " "+countryList.get(position).region)
        // val istTime = convertToIST(countryList.get(position).timezones.toString())

        holder.country_timezone.setText("CountryTime :"+ " "+countryList.get(position).timezones.toString())
        Picasso.get().load(countryList.get(position).flags.png).into(holder.country_imageview)
//Toast.makeText(context,"t"+countryList.get(position).timezones.get(position).timezones,Toast.LENGTH_SHORT).show()
    }

    class CountryViewHolder(itemview : View): RecyclerView.ViewHolder(itemview){

        val country_name = itemview.findViewById<TextView>(R.id.country_name)
        val country_captial = itemview.findViewById<TextView>(R.id.country_captial)
        val country_region = itemview.findViewById<TextView>(R.id.country_region)
        val country_timezone = itemview.findViewById<TextView>(R.id.country_time)
        val country_imageview = itemview.findViewById<ImageView>(R.id.flag_img)


    }

    fun convertToIST(utcOffset: String): String {
        // Extracting time zone offset from the input string
        val offset = utcOffset.substring(4, 10)

        // Define the date format with time zone
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault())
        val outputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

        // Parse the input date string with UTC offset
        val date = inputFormat.parse("2024-02-11T11:34:43.847$offset")

        // Convert the date to IST
        val istTimeZone = TimeZone.getTimeZone("Asia/Kolkata")
        outputFormat.timeZone = istTimeZone
        return outputFormat.format(date)
    }

}