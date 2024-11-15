package es.crisvega.pantallaprincipal.utilidades;

import java.util.ArrayList;

import es.crisvega.pantallaprincipal.R;
import es.crisvega.pantallaprincipal.models.Equipo;

public class listaEquipos {

    private ArrayList<Equipo> equipos;

    public listaEquipos() {
        this.equipos = crearLista();
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    private ArrayList<Equipo> crearLista() {
        ArrayList<Equipo> eqps = new ArrayList<Equipo>();


        eqps.add(new Equipo("Los Angeles Lakers","Los Angeles Lakers son un equipo de la NBA, " +
                "conocido por sus 17 campeonatos y estrellas como Magic Johnson, Kobe Bryant y LeBron James", R.drawable.lakers));
        eqps.add(new Equipo("Dallas Mavericks","Los Dallas Mavericks son un equipo de la NBA," +
                " conocido por su campeonato de 2011 liderado por Dirk Nowitzki y su competitivo espíritu en el Oeste", R.drawable.dallas));
        eqps.add(new Equipo("Golden State Warriors","Los Golden State Warriors son un equipo de la NBA, " +
                "famoso por sus recientes campeonatos y el estilo de juego de estrellas como Stephen Curry y Klay Thompson", R.drawable.warriors));
        eqps.add(new Equipo("Miami Heat","El Miami Heat es un equipo de la NBA," +
                " conocido por sus tres campeonatos y jugadores emblemáticos como Dwyane Wade, LeBron James y Shaquille O'Neal", R.drawable.miami));
        eqps.add(new Equipo("Boston Celtics","Los Boston Celtics son un equipo de la NBA," +
                " histórico por sus 17 campeonatos y leyendas como Larry Bird, Bill Russell y Paul Pierce.", R.drawable.boston));
        eqps.add(new Equipo("Chicago Bulls","Los Chicago Bulls son un equipo de baloncesto de la NBA, " +
                "famoso por sus seis campeonatos en los años 90 liderados por Michael Jordan", R.drawable.bulls));

        return eqps;
    }

}
