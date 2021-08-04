package logic;
import objects.player;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class data_gestor {

    public ArrayList<player> DatosPlayer = new ArrayList<>();

    public boolean DatosCargados = false;
    public boolean CodigosCargados = false;

    public void cargarDatos() throws FileNotFoundException {

        int contadorLineas = 0;
        Scanner lector = new Scanner(new File("C:\\Users\\justi\\IdeaProjects\\Simulacion_2\\players_15.csv"));
        lista lista = new lista();
        try{
            while (lector.hasNextLine()) {
                contadorLineas++;
                String currentLine = lector.nextLine();
                String[] datos = currentLine.split(",");
                player player = new player();

                player.setLong_name(datos[0]);

                player.setAge(datos[1]);

                player.setDob(datos[2]);

                player.setHeight_cm(datos[3]);

                player.setWeight_kg(datos[4]);

                player.setNationality(datos[5]);

                player.setClub(datos[6]);

                player.setTeam_jersey_number(datos[7]);

                player.setNumero_filas(String.valueOf(contadorLineas));
                DatosPlayer.add(player);
                lista.Agregar(player);
                DatosCargados = true;
            }
        }catch (Exception e) {
        e.printStackTrace();
    }
        lector.close();
        CodigosCargados = true;
        System.out.println("Datos cargados con exito.");
    }

    public void imprimirDatos() {
        for (int i = 0; i < DatosPlayer.size(); i++) {
            System.out.println(DatosPlayer.get(i));
        }
    }


    public void BuscarNamePlayer(String player_buscar) {

        if (CodigosCargados==false){
            System.out.println("Primero tienes que cargar los datos.");
        }else{
            int productosEncontrados = 0;

            for (int i = 0; i < DatosPlayer.size(); i++) {

                String nombreProducto = DatosPlayer.get(i).getLong_name();

                if (nombreProducto.contains(player_buscar)) {
                    System.out.println(DatosPlayer.get(i) + "esta en la posicion lineal: " + i);
                    productosEncontrados++;
                } else {

                }
            }
            System.out.println("Se encontraron " + productosEncontrados + " productos");
        }
    }
    public void BuscarEdadPesoEstaturaPlayer(String player_buscar) {

        if (CodigosCargados==false){
            System.out.println("Primero tienes que cargar los datos.");
        }else{
            int productosEncontrados = 0;

            for (int i = 0; i < DatosPlayer.size(); i++) {

                String data_player_height = DatosPlayer.get(i).getHeight_cm();
                String data_player_weidht = DatosPlayer.get(i).getWeight_kg();
                String data_player_age = DatosPlayer.get(i).getAge();

                if (data_player_height.contains(player_buscar) || data_player_weidht.contains(player_buscar) || data_player_age.contains(player_buscar)){
                    System.out.println(DatosPlayer.get(i) + "esta en la posicion lineal: " + i);
                    productosEncontrados++;
                }
            }
            System.out.println("Se encontraron " + productosEncontrados + " jugadores");
        }
    }

    public void BuscarPaisPlayer(String player_buscar) {

        if (CodigosCargados==false){
            System.out.println("Primero tienes que cargar los datos.");
        }else{
            int productosEncontrados = 0;

            for (int i = 0; i < DatosPlayer.size(); i++) {

                String data_player_pais = DatosPlayer.get(i).getNationality();

                if (data_player_pais.contains(player_buscar)){
                    System.out.println(DatosPlayer.get(i) + "esta en la posicion lineal: " + i);
                    productosEncontrados++;
                }
            }
            System.out.println("Se encontraron " + productosEncontrados + " jugadores");
        }
    }

    public void BuscarDorsalPlayer(String player_buscar) {

        if (CodigosCargados==false){
            System.out.println("Primero tienes que cargar los datos.");
        }else{
            int productosEncontrados = 0;

            for (int i = 0; i < DatosPlayer.size(); i++) {

                String data_player_pais = DatosPlayer.get(i).getTeam_jersey_number();

                if (data_player_pais.contains(player_buscar)){
                    System.out.println(DatosPlayer.get(i) + "esta en la posicion lineal: " + i);
                    productosEncontrados++;
                }
            }
            System.out.println("Se encontraron " + productosEncontrados + " jugadores");
        }
    }

    public void escribirArchivoBat() throws IOException {
        FileOutputStream f = new FileOutputStream(new File("register//archivo.dat"));
        ObjectOutputStream o = new ObjectOutputStream(f);

        for (int i = 0; i<DatosPlayer.size(); i++){
            o.writeObject(DatosPlayer.get(i));
        }
        o.close();
        f.close();
    }
    public ArrayList<player> LecturaBat() throws IOException {
        FileInputStream fi = new FileInputStream(new File("//Simulacion 4//src//register//archivo.dat"));
        ObjectInputStream oi = new ObjectInputStream(fi);

        ArrayList<player> players = new ArrayList();
        try {
            player obj = null;
            while ((obj = (player) oi.readObject()) != null) {
                players.add(obj);
            }
        }catch (Exception e){
            oi.close();
            fi.close();
        }
        oi.close();
        fi.close();

        return players;
    }

    public HashMap DatosporIndex(String nameFile) throws IOException, ClassNotFoundException {
        FileInputStream fi = new FileInputStream(new File("register//datos//archivo.dat"));
        ObjectInputStream oi = new ObjectInputStream(fi);
        HashMap hashMap  = new HashMap();
        try {
            hashMap = (HashMap) oi.readObject();
        }catch (Exception e){
            oi.close();
            fi.close();
        }
        oi.close();
        fi.close();
        return hashMap;
    }

}
