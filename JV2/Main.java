import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    static BufferedReader br = null;
    static List<Persona> personas = new ArrayList<>();

    public static void main(String[] args) {

        try {
            br = new BufferedReader(new FileReader("src\\datos.txt"));
            String linea;

            //Leer el fichero y guardar las personas en la lista
            while ((linea = br.readLine()) != null) {
                //Utilizar metodo de Optional para trabajar con los datos que faltan
                String nombre = String.valueOf(getDataOptional(linea.split(":"), 0).orElse("DESCONOCIDO"));
                String poblacion = String.valueOf(getDataOptional(linea.split(":"), 1).orElse("DESCONOCIDO"));
                String edad = String.valueOf(getDataOptional(linea.split(":"), 2).orElse("100"));
                Persona persona = new Persona(nombre, poblacion, edad);
                personas.add(persona);
                System.out.println("Nombre: " + persona.getNombre() + " Poblacion: " + persona.getPoblacion() + " Edad: " + persona.getEdad());
            }

            //Stream para filtrar por edad
            System.out.println("MENORES DE 25");
            personas.stream().filter(persona -> Integer.parseInt(persona.getEdad()) < 25).forEach(persona -> System.out.println(persona.toString()));

        } catch (FileNotFoundException e) {
            System.err.println("Error en el buffer" + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer la linea "+  e.getMessage());
        }

    }

    //metodo para devolver un Optional
    public static Optional<String> getDataOptional(String[] datos, int i){
        try{
            if(datos[i].isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(datos[i]);
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }
}
