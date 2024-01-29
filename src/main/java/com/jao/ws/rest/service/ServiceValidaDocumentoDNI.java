package com.jao.ws.rest.service;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jao.ws.rest.vo.VODocumentoDNI;

@Path("/jaoRest")
public class ServiceValidaDocumentoDNI {
	@POST//La forma por la que vamos a invocar el metodo
	@Path("/validarDNI")//el path del servicio, si tenemos en este servicio mas metodos habria que poner distintos paths
	@Consumes({MediaType.APPLICATION_JSON})//quien va a consumir este metodo:JSON
	@Produces({MediaType.APPLICATION_JSON})//que va a generar un objeto java que se va a transformar en JSON
	public VODocumentoDNI validaDNI(VODocumentoDNI vo){
		
		boolean res= validarDNI(vo.getDni());
		if(res== true){
			System.out.println("El DNI " + vo.getDni() + " es válido.");
			vo.setValido(true);
		} else{
			System.out.println("El DNI introducido es incorrecto, por favor introduzca un DNI válido.");
			vo.setValido(false);
		}
			
		/*String dniIntroducido = vo.getDni();
        Scanner miScanner = new Scanner(System.in);
        Pattern patron = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
        System.out.print("Introduce un DNI correcto: ");
        dniIntroducido = miScanner.nextLine();
        Matcher mat = patron.matcher(dniIntroducido);
        while(!mat.matches()){
           System.out.println("El DNI introducido es incorrecto, por favor introduzca un DNI válido.");
           System.out.print("Introduce un DNI correcto: ");
           dniIntroducido = miScanner.nextLine();
           mat = patron.matcher(dniIntroducido);
           vo.setValido(false);
        }
        System.out.println("El DNI " + dniIntroducido + " es válido.");
        	*/
		return vo;
	}
	private static final Pattern REGEXP = Pattern.compile("[0-9]{8}[A-Z]");
	  private static final String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
	  private static final String[] INVALIDOS = new String[] { "00000000T", "00000001R", "99999999R" };

	  public static boolean validarDNI(String dni) {
	    return Arrays.binarySearch(INVALIDOS, dni) < 0 // (1)
		    && REGEXP.matcher(dni).matches() // (2)
	        && dni.charAt(8) == DIGITO_CONTROL.charAt(Integer.parseInt(dni.substring(0, 8)) % 23); // (3)
	  }
	
}
