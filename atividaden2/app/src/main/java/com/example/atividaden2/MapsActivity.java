package com.example.atividaden2;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Bundle retornpais = getIntent().getExtras();

       // String v="";
       // String v1="";
        String value ="";
            double v=0;
            double v1=0;
        if(retornpais != null){
            value = (String) retornpais.get("pais");

        }

        switch(value) {
            case "Angola":
                v=-12.5;
                v1=18.5;
                break;
            case "Brazil":
                v=-10.0;
                v1=-55.0;
                break;
            case "Cabo Verde":
                v=16.0;
                v1=-24.0;
                break;
            case "Guinea-Bissau":
                v=12.0;
                v1=-15.0;
                break;
            case "Macao":
                v=22.166667;
                v1=113.55;
                break;
            case "Mozambique":
                v=-18.25;
                v1=35.05;
                break;
            case "Portugal":
                v=39.5;
                v1=-8.0;
                break;
            case "Sao Tome and Principe":
                v=0.1864;
                v1=6.6131;
                break;
            case "Timor-Leste":
                v=-8.83333333;
                v1=125.91666666;
                break;
            default:
                v=-33.8688;
                v1=151.2093;
                break;
        }
       // String[] separated  = value.split(",");

       // v = separated[0];
       // v1 = separated[1];
      //  Integer v2 =Integer.parseInt(v);
      //  Integer v3 =Integer.parseInt(v1);
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(v, v1);

        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}