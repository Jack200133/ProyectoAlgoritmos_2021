import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;


public class FuncionesTest {

    @Test
    public void defun() {
        Funciones eva = new Funciones();
        String re = "( defun pollo ( x ) ( * x 2 )";
        assertEquals(eva.Defun(re).getClass(), Funciones.class);
  }
}