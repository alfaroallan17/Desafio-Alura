package com.tuproyecto.literalura.principal;

import com.tuproyecto.literalura.model.DatosRespuesta;
import com.tuproyecto.literalura.service.ConsumoAPI;
import com.tuproyecto.literalura.service.ConvierteDatos;
import java.util.Scanner;

public class Principal {
    private Scanner lectura = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private final String URL_BASE = "https://gutendex.com/books/";

    public void muestraElMenu() {
        var menu = """
                1 - Buscar libro por título 
                0 - Salir
                """;
        System.out.println(menu);
        var opcion = lectura.nextInt();
        lectura.nextLine();

        if (opcion == 1) {
            buscarLibroWeb();
        }
    }

    private void buscarLibroWeb() {
        System.out.println("Ingrese el nombre del libro:");
        var nombreLibro = lectura.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + nombreLibro.replace(" ", "+"));
        var datos = conversor.obtenerDatos(json, DatosRespuesta.class);
        System.out.println(datos);
    }
}