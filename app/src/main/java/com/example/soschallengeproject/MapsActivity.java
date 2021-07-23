package com.example.soschallengeproject;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;

import java.util.concurrent.locks.Lock;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static android.view.View.Y;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMarkerClickListener, OnMapReadyCallback {

    private GoogleMap indyMap;
    Button menubtn,eventbtn,restbtn,barbtn,parkbtn,hotelbtn,shopbtn,allbtn,qpopupbg,qbtn,q1btn,q2btn,q3btn,q4btn;
    private Marker CurrentLoc,LOS,YardHouse,HarryIzzys,Iozzo,Arbys,PunchBowlSocial,TavernOnSouth,HighVelocity,Nada,SpaghettiFac,Kilroys,StadiumTav,Brothers,DenisonP, MerrillP,PanAmP,CapitolP,CPS,CCMall,LockerR,ChMus,EscapeR,IZoo;
    float zoomlevel;
    TextView Question;
    int Qnum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //initializations

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        menubtn = findViewById(R.id.menubtn);
        eventbtn = (Button)findViewById(R.id.eventbtn);
        restbtn = (Button)findViewById(R.id.restbtn);
        barbtn = (Button)findViewById(R.id.barbtn);
        parkbtn = (Button)findViewById(R.id.parkbtn);
        hotelbtn = (Button)findViewById(R.id.hotelbtn);
        shopbtn = (Button)findViewById(R.id.shopbtn);
        allbtn = (Button)findViewById(R.id.allbtn);
        qbtn = (Button)findViewById(R.id.qbtn);
        qpopupbg = (Button)findViewById(R.id.qpopupbg);
        Question = (TextView)findViewById(R.id.question);
        q1btn = (Button)findViewById(R.id.q1btn);
        q2btn = (Button)findViewById(R.id.q2btn);
        q3btn = (Button)findViewById(R.id.q3btn);
        q4btn = (Button)findViewById(R.id.q4btn);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //sets all button visibilities to starting condition

        eventbtn.setVisibility(INVISIBLE); // turns event button invisible
        restbtn.setVisibility(INVISIBLE); // turns rest button invisible
        barbtn.setVisibility(INVISIBLE); // turns bar button invisible
        parkbtn.setVisibility(INVISIBLE); // turns park button invisible
        hotelbtn.setVisibility(INVISIBLE); // turns hotel button invisible
        shopbtn.setVisibility(INVISIBLE); // turns shop button invisible
        allbtn.setVisibility(INVISIBLE); // turns shop button invisible
        qpopupbg.setVisibility(INVISIBLE);//turns q bg invisible
        Question.setVisibility(INVISIBLE);
        q1btn.setVisibility(INVISIBLE);
        q2btn.setVisibility(INVISIBLE);
        q3btn.setVisibility(INVISIBLE);
        q4btn.setVisibility(INVISIBLE);


    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        indyMap = googleMap;
        zoomlevel = 14.0f; //range from 2.0 up to 21.0

        // Add a marker at lucas oil stadium and current location, then moves/zooms the camera

        LatLng CurrentLocLL = new LatLng(39.765748198965125, -86.16111287556682); //used to show "current location" in final product this would
        CurrentLoc = indyMap.addMarker(new MarkerOptions().position(CurrentLocLL).title("Current Location")); //call for location data of phone and update
        CurrentLoc.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.locmarker));

        LatLng LOSLL = new LatLng(39.7601, -86.164);
        LOS = indyMap.addMarker(new MarkerOptions().position(LOSLL).title("Lucas Oil Stadium"));
        LOS.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.losmarker));

        //Here is where you declare and add all of the markers

        LatLng YardHouseLL = new LatLng(39.765749198965125, -86.15917287556682);
        YardHouse = indyMap.addMarker(new MarkerOptions().position(YardHouseLL).title("Yard House"));
        YardHouse.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.marker0sm));

        LatLng HarryIzzysLL = new LatLng(39.765240890104536, -86.15968488176759);
        HarryIzzys = indyMap.addMarker(new MarkerOptions().position(HarryIzzysLL).title("Harry & Izzy's"));
        HarryIzzys.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.marker15sm));

        LatLng IozzoLL = new LatLng(39.75440819291465,  -86.15953383323824);
        Iozzo = indyMap.addMarker(new MarkerOptions().position(IozzoLL).title("Iozzo’s Garden of Italy"));
        Iozzo.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.marker45sm));

        LatLng ArbysLL = new LatLng(39.761241413003134, -86.156933375567);
        Arbys = indyMap.addMarker(new MarkerOptions().position(ArbysLL).title("Arby's"));
        Arbys.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.marker0sm));

        LatLng PunchBowlLL = new LatLng(39.765098525060246, -86.15909807371818);
        PunchBowlSocial = indyMap.addMarker(new MarkerOptions().position(PunchBowlLL).title("Punch Bowl Social"));
        PunchBowlSocial.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.marker30sm));

        LatLng TavernOnSLL = new LatLng(39.76164283251077, -86.16635280255383);
        TavernOnSouth = indyMap.addMarker(new MarkerOptions().position(TavernOnSLL).title("Tavern On South"));
        TavernOnSouth.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.marker15sm));

        LatLng HighVelocityLL = new LatLng(39.766402943283175, -86.16771035082462);
        HighVelocity = indyMap.addMarker(new MarkerOptions().position(HighVelocityLL).title("High Velocity"));
        HighVelocity.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.marker45sm));

        LatLng NadaLL = new LatLng(39.76563996466511, -86.15859214303403);
        Nada = indyMap.addMarker(new MarkerOptions().position(NadaLL).title("Nada"));
        Nada.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.marker30sm));

        LatLng SpaghettiFacLL = new LatLng(39.76415972708445, -86.15836305837617);
        SpaghettiFac = indyMap.addMarker(new MarkerOptions().position(SpaghettiFacLL).title("The Old Spaghetti Factory"));
        SpaghettiFac.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.marker45sm));

        LatLng KilroysLL = new LatLng(39.76424826813903,  -86.1579773872861);
        Kilroys = indyMap.addMarker(new MarkerOptions().position(KilroysLL).title("Kilroy's"));

        LatLng StadiumTavLL = new LatLng(39.756814930813825,  -86.16772400255398);
        StadiumTav = indyMap.addMarker(new MarkerOptions().position(StadiumTavLL).title("Stadium Tavern"));

        LatLng BrothersLL = new LatLng(39.76843641073069,  -86.1597633396185);
        Brothers = indyMap.addMarker(new MarkerOptions().position(BrothersLL).title("Brothers Bar & Grill"));

        LatLng MerrillLL = new LatLng(39.75973350825829,   -86.1661641025539);
        MerrillP = indyMap.addMarker(new MarkerOptions().position(MerrillLL).title("415 W Merrill St Parking"));

        LatLng PanAmLL = new LatLng(39.76332825371239,   -86.16052851789587);
        PanAmP = indyMap.addMarker(new MarkerOptions().position(PanAmLL).title("Pan Am Garage"));

        LatLng CapitolLL = new LatLng(39.75718143387928,   -86.16204905412611);
        CapitolP = indyMap.addMarker(new MarkerOptions().position(CapitolLL).title("725 S Capitol Ave Parking"));

        LatLng DenisonLL = new LatLng(39.765458198965125,   -86.16161287556682);
        DenisonP = indyMap.addMarker(new MarkerOptions().position(DenisonLL).title("Dension Parking Lot"));

        LatLng CPSLL = new LatLng(39.76023264041247,    -86.16490916022495);
        CPS = indyMap.addMarker(new MarkerOptions().position(CPSLL).title("Colt's Pro Shop"));

        LatLng CCMallLL = new LatLng(39.76654362194451,   -86.15981811789577);
        CCMall = indyMap.addMarker(new MarkerOptions().position(CCMallLL).title("Circle Centre Mall"));

        LatLng LockerRLL = new LatLng(39.765526605772145,   -86.15934633138922);
        LockerR = indyMap.addMarker(new MarkerOptions().position(LockerRLL).title("Locker Room by Lids"));

        LatLng ChMusLL = new LatLng(39.81077800955343,   -86.15793461789418);
        ChMus = indyMap.addMarker(new MarkerOptions().position(ChMusLL).title("The Children's Museum"));

        LatLng EscapeRLL = new LatLng(39.76407883304156,   -86.15837020070511);
        EscapeR = indyMap.addMarker(new MarkerOptions().position(EscapeRLL).title("The Escape Room Indianapolis"));

        LatLng IZooLL = new LatLng(39.76759866635805,   -86.18075146022467);
        IZoo = indyMap.addMarker(new MarkerOptions().position(IZooLL).title("Indianapolis Zoo"));

        indyMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CurrentLocLL, zoomlevel)); //initial camera position
        indyMap.setOnMarkerClickListener(this);
        indyMap.setOnInfoWindowClickListener(MyOnInfoWindowClickListener);
    }

    /////////////////////////////////////////////////////////
    //Functions for all of the onClick activities of buttons
    /////////////////////////////////////////////////////////

    public void MenuBtnPress(View view) { //when the menu button gets pressed
        menubtn.setVisibility(view.INVISIBLE); // turns menubtn invisible
        eventbtn.setVisibility(VISIBLE); // turns event button visible
        restbtn.setVisibility(VISIBLE); // turns rest button visible
        barbtn.setVisibility(VISIBLE); // turns bar button visible
        parkbtn.setVisibility(VISIBLE); // turns park button visible
        hotelbtn.setVisibility(VISIBLE); // turns hotel button visible
        shopbtn.setVisibility(VISIBLE); // turns shop button visible
        allbtn.setVisibility(VISIBLE); // turns all button visible
    }

    public void EventBtnPress(View view) { //when the menu button gets pressed
        menubtn.setVisibility(VISIBLE); // turns menubtn visible
        eventbtn.setVisibility(view.INVISIBLE); // turns event button invisible
        restbtn.setVisibility(view.INVISIBLE); // turns rest button invisible
        barbtn.setVisibility(view.INVISIBLE); // turns bar button invisible
        parkbtn.setVisibility(view.INVISIBLE); // turns park button invisible
        hotelbtn.setVisibility(view.INVISIBLE); // turns hotel button invisible
        shopbtn.setVisibility(view.INVISIBLE); // turns shop button invisible
        allbtn.setVisibility(INVISIBLE); // turns all button invisible

        EventVis();
        RestInvis();
        BarInvis();
        ParkInvis();
        EntInvis();
        ShopInvis();
    }

    public void RestBtnPress(View view) { //when the menu button gets pressed
        menubtn.setVisibility(VISIBLE); // turns menubtn visible
        eventbtn.setVisibility(view.INVISIBLE); // turns event button invisible
        restbtn.setVisibility(view.INVISIBLE); // turns rest button invisible
        barbtn.setVisibility(view.INVISIBLE); // turns bar button invisible
        parkbtn.setVisibility(view.INVISIBLE); // turns park button invisible
        hotelbtn.setVisibility(view.INVISIBLE); // turns hotel button invisible
        shopbtn.setVisibility(view.INVISIBLE); // turns shop button invisible
        allbtn.setVisibility(INVISIBLE); // turns all button invisible

        RestVis();
        EventInvis();
        BarInvis();
        ParkInvis();
        EntInvis();
        ShopInvis();
    }

    public void BarBtnPress(View view) { //when the menu button gets pressed
        menubtn.setVisibility(VISIBLE); // turns menubtn visible
        eventbtn.setVisibility(view.INVISIBLE); // turns event button invisible
        restbtn.setVisibility(view.INVISIBLE); // turns rest button invisible
        barbtn.setVisibility(view.INVISIBLE); // turns bar button invisible
        parkbtn.setVisibility(view.INVISIBLE); // turns park button invisible
        hotelbtn.setVisibility(view.INVISIBLE); // turns hotel button invisible
        shopbtn.setVisibility(view.INVISIBLE); // turns shop button invisible
        allbtn.setVisibility(INVISIBLE); // turns all button invisible

        BarVis();
        EventInvis();
        RestInvis();
        ParkInvis();
        EntInvis();
        ShopInvis();
    }

    public void ParkBtnPress(View view) { //when the menu button gets pressed
        menubtn.setVisibility(VISIBLE); // turns menubtn visible
        eventbtn.setVisibility(view.INVISIBLE); // turns event button invisible
        restbtn.setVisibility(view.INVISIBLE); // turns rest button invisible
        barbtn.setVisibility(view.INVISIBLE); // turns bar button invisible
        parkbtn.setVisibility(view.INVISIBLE); // turns park button invisible
        hotelbtn.setVisibility(view.INVISIBLE); // turns hotel button invisible
        shopbtn.setVisibility(view.INVISIBLE); // turns shop button invisible
        allbtn.setVisibility(INVISIBLE); // turns all button invisible

        ParkVis();
        EventInvis();
        RestInvis();
        BarInvis();
        EntInvis();
        ShopInvis();
    }

    public void HotelBtnPress(View view) { //when the menu button gets pressed
        menubtn.setVisibility(VISIBLE); // turns menubtn visible
        eventbtn.setVisibility(view.INVISIBLE); // turns event button invisible
        restbtn.setVisibility(view.INVISIBLE); // turns rest button invisible
        barbtn.setVisibility(view.INVISIBLE); // turns bar button invisible
        parkbtn.setVisibility(view.INVISIBLE); // turns park button invisible
        hotelbtn.setVisibility(view.INVISIBLE); // turns hotel button invisible
        shopbtn.setVisibility(view.INVISIBLE); // turns shop button invisible
        allbtn.setVisibility(INVISIBLE); // turns all button invisible

        EntVis();
        EventInvis();
        RestInvis();
        BarInvis();
        ParkInvis();
        ShopInvis();
    }

    public void ShopBtnPress(View view) { //when the menu button gets pressed
        menubtn.setVisibility(VISIBLE); // turns menubtn visible
        eventbtn.setVisibility(view.INVISIBLE); // turns event button invisible
        restbtn.setVisibility(view.INVISIBLE); // turns rest button invisible
        barbtn.setVisibility(view.INVISIBLE); // turns bar button invisible
        parkbtn.setVisibility(view.INVISIBLE); // turns park button invisible
        hotelbtn.setVisibility(view.INVISIBLE); // turns hotel button invisible
        shopbtn.setVisibility(view.INVISIBLE); // turns shop button invisible
        allbtn.setVisibility(INVISIBLE); // turns all button invisible

        ShopVis();
        EventInvis();
        RestInvis();
        BarInvis();
        ParkInvis();
        EntInvis();
    }

    public void AllBtnPress(View view) {
        menubtn.setVisibility(VISIBLE); // turns menubtn visible
        eventbtn.setVisibility(view.INVISIBLE); // turns event button invisible
        restbtn.setVisibility(view.INVISIBLE); // turns rest button invisible
        barbtn.setVisibility(view.INVISIBLE); // turns bar button invisible
        parkbtn.setVisibility(view.INVISIBLE); // turns park button invisible
        hotelbtn.setVisibility(view.INVISIBLE); // turns hotel button invisible
        shopbtn.setVisibility(view.INVISIBLE); // turns shop button invisible
        allbtn.setVisibility(INVISIBLE); // turns all button invisible

        ShopVis();
        EventVis();
        RestVis();
        BarVis();
        ParkVis();
        EntVis();
    }

    public void PlusBtnPress(View view) {  //zoom in btn
        zoomlevel = zoomlevel + 0.5f;
        indyMap.animateCamera( CameraUpdateFactory.zoomTo( zoomlevel ) ); //set zoom to zoom level
    }

    public void MinusBtnPress(View view) { //zoom out btn
        zoomlevel = zoomlevel - 0.5f;
        indyMap.animateCamera( CameraUpdateFactory.zoomTo( zoomlevel ) ); //set zoom to zoom level
    }

    public void RecBtnPress(View view) { //opens recommendation page
        Intent RecIntent = new Intent(this, Recommendation_page.class);
        startActivity(RecIntent);
    }
    public void QBtnPress(View view) { //makes question interface visible/invisible on toggle

        if(qpopupbg.getVisibility() == INVISIBLE)
        {
            qpopupbg.setVisibility(VISIBLE);
            Question.setVisibility(VISIBLE);

            q1btn.setVisibility(VISIBLE);
            q2btn.setVisibility(VISIBLE);
            q3btn.setVisibility(VISIBLE);
            q4btn.setVisibility(VISIBLE);
        }
        else
        {
            qpopupbg.setVisibility(view.INVISIBLE);
            Question.setVisibility(INVISIBLE);

            q1btn.setVisibility(INVISIBLE);
            q2btn.setVisibility(INVISIBLE);
            q3btn.setVisibility(INVISIBLE);
            q4btn.setVisibility(INVISIBLE);
        }
    }

    public void QABtnPress(View view) { //run when a question is answered, would need to make one for every button to communicate with server in final version
        if(Qnum == 4) {
            Question.setText("40 Points Earned");
            Question.setTextSize(20);
            Qnum = 4;

            q1btn.setVisibility(INVISIBLE);
            q2btn.setVisibility(INVISIBLE);
            q3btn.setVisibility(INVISIBLE);
            q4btn.setVisibility(INVISIBLE);
        }

        if(Qnum == 3) {
            Question.setText("How busy is Denison Parking Lot?");
            Question.setTextSize(16);
            Qnum = 4;
        }

        if(Qnum == 2) {
            Question.setText("What is the wait time at Yard House");
            Question.setTextSize(15);
            Qnum = 3;
        }

        if(Qnum == 1) {
            Question.setText("What is the wait time at Harry & Izzy's?");
            Question.setTextSize(14);
            Qnum = 2;
        }
    }

    /////////////////////////////////////////////////////////////////////////
    //Detection of Marker clicks and Marker Info window clicks
    //initially used marker clicks to open pages but i changed to using
    //the info window listener to not open info page when marker was selected
    /////////////////////////////////////////////////////////////////////////

    @Override
    public boolean onMarkerClick(final Marker marker) { //unused at the current moment
        if(marker.getTitle().equals("Current Location")) //what we do when the LOS marker is clicked
        {

        }
        if(marker.getTitle().equals("Resturaunt 1")) //what we do when the R1 marker is clicked
        {
            //Intent R1intent = new Intent(this, Rest1InfoPage.class);
            //startActivity(R1intent);
        }

        return false;
    }

    GoogleMap.OnInfoWindowClickListener MyOnInfoWindowClickListener
            = new GoogleMap.OnInfoWindowClickListener(){
        @Override
        public void onInfoWindowClick(Marker marker) {
            if(marker.getTitle().equals("Lucas Oil Stadium")) //checks what marker
            {
                Intent LOSintent = new Intent(MapsActivity.this, LOSInfoPage.class);
                startActivity(LOSintent);
            }

            if(marker.getTitle().equals("Yard House"))
            {
                Intent YHintent = new Intent(MapsActivity.this, YardHouseInfoPage.class);
                startActivity(YHintent);
            }

        }
    };

    //////////////////////////////////////////////////////////
    //Functions used to toggle visibility of Markers
    //////////////////////////////////////////////////////////

    public void EventInvis() {
        LOS.setVisible(false); //makes marker invisible
    }

    public void EventVis() {
        LOS.setVisible(true); //makes marker invisible
    }

    public void RestInvis() {
        YardHouse.setVisible(false); //makes marker invisible
        HarryIzzys.setVisible(false);
        Iozzo.setVisible(false);
        Arbys.setVisible(false);
        TavernOnSouth.setVisible(false);
        PunchBowlSocial.setVisible(false);
        HighVelocity.setVisible(false);
        Nada.setVisible(false);
        SpaghettiFac.setVisible(false);
    }

    public void RestVis() {
        YardHouse.setVisible(true); //makes marker visible
        HarryIzzys.setVisible(true);
        Iozzo.setVisible(true);
        Arbys.setVisible(true);
        TavernOnSouth.setVisible(true);
        PunchBowlSocial.setVisible(true);
        HighVelocity.setVisible(true);
        Nada.setVisible(true);
        SpaghettiFac.setVisible(true);
    }

    public void BarInvis() {
        Kilroys.setVisible(false);
        StadiumTav.setVisible(false);
        Brothers.setVisible(false);
    }

    public void BarVis() {
        Kilroys.setVisible(true);
        StadiumTav.setVisible(true);
        Brothers.setVisible(true);
    }

    public void ParkInvis() {
        MerrillP.setVisible(false);
        PanAmP.setVisible(false);
        CapitolP.setVisible(false);
        DenisonP.setVisible(false);
    }

    public void ParkVis() {
        MerrillP.setVisible(true);
        PanAmP.setVisible(true);
        CapitolP.setVisible(true);
        DenisonP.setVisible(true);
    }

    public void EntInvis() {
        ChMus.setVisible(false);
        EscapeR.setVisible(false);
        IZoo.setVisible(false);
    }

    public void EntVis() {
        ChMus.setVisible(true);
        EscapeR.setVisible(true);
        IZoo.setVisible(true);
    }

    public void ShopInvis() {
        CPS.setVisible(false);
        CCMall.setVisible(false);
        LockerR.setVisible(false);
    }

    public void ShopVis() {
        CPS.setVisible(true);
        CCMall.setVisible(true);
        LockerR.setVisible(true);
    }

}
