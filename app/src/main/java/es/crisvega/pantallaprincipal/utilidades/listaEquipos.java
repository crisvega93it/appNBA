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


        eqps.add(new Equipo("Los Angeles Lakers","Los Angeles Lakers es un equipo icónico de la NBA con sede en Los Ángeles, California." +
                " Fundado en 1947, es uno de los más exitosos de la liga, con 17 campeonatos en su historia." +
                " Con colores púrpura y dorado, los Lakers han sido hogar de leyendas como Magic Johnson, Kareem Abdul-Jabbar," +
                " Kobe Bryant y LeBron James. Conocidos por su estilo dominante y espectáculo, han marcado múltiples épocas doradas " +
                "en el baloncesto profesional.", R.drawable.lakers));

        eqps.add(new Equipo("Dallas Mavericks","\n" +
                "Los Dallas Mavericks, conocidos como los Mavs, son un equipo de la NBA con sede en Dallas, Texas." +
                " Fundados en 1980, han ganado un campeonato en su historia, en 2011, liderados por Dirk Nowitzki." +
                " Con colores azul, plata y blanco, los Mavericks se destacan por su estilo competitivo y su fiel base de fanáticos." +
                " Iconos como Nowitzki y Luka Dončić han sido clave en su legado como contendientes en la liga.", R.drawable.dallas));

        eqps.add(new Equipo("Golden State Warriors","\n" +
                "Los Golden State Warriors son un equipo de la NBA con sede en San Francisco, California. " +
                "Fundados en 1946, han ganado 7 campeonatos, destacándose por su dominio reciente con estrellas como Stephen Curry" +
                ", Klay Thompson y Draymond Green. Con colores azul y dorado, los Warriors son conocidos por su juego dinámico " +
                "y el desarrollo del \"Small Ball\"." +
                " Su estilo revolucionó el baloncesto moderno, marcando una era de éxito y espectáculo en la liga.", R.drawable.warriors));

        eqps.add(new Equipo("Miami Heat","El Miami Heat es un equipo de la NBA con sede en Miami, Florida. " +
                "Fundado en 1988, ha ganado 3 campeonatos (2006, 2012 y 2013) con estrellas como Dwyane Wade, " +
                "LeBron James y Shaquille O’Neal. Con colores rojo, negro y blanco, el Heat es conocido por su " +
                "cultura de trabajo duro y competitividad bajo la dirección de Pat Riley y Erik Spoelstra, consolidándose como" +
                " una de las franquicias más exitosas de la liga.", R.drawable.miami));

        eqps.add(new Equipo("Boston Celtics","Los Boston Celtics son uno de los equipos más históricos de la NBA," +
                " con sede en Boston, Massachusetts. Fundados en 1946, han ganado 17 campeonatos, igualados con los Los Angeles Lakers." +
                " Con colores verde y blanco, los Celtics son conocidos por su legado de éxito, con jugadores icónicos como Bill Russell," +
                " Larry Bird y Paul Pierce. Su estilo de " +
                "juego basado en el trabajo en equipo y la defensa ha sido una marca registrada de la franquicia a lo largo de los años.", R.drawable.boston));

        eqps.add(new Equipo("Chicago Bulls","Los Chicago Bulls son un equipo de la NBA con sede en Chicago, Illinois." +
                " Fundados en 1966, los Bulls son famosos por su dinastía en los años 90, cuando ganaron 6 campeonatos, liderados " +
                "por Michael Jordan y Scottie Pippen. Con colores rojo, negro y blanco, los Bulls son conocidos por su dominio en esa " +
                "era, que marcó la historia de la liga." +
                " La figura de Jordan sigue siendo un ícono global, representando el éxito y la grandeza de la franquicia.", R.drawable.bulls));

        return eqps;
    }

}
