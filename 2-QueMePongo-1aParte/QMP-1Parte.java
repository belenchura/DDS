
public class Color {
    public int R;
    public int G;
    public int B;

    public Color(int R, int G, int B) {
        this.R(R);
        this.G(G);
        this.B(B);
    }

    public final boolean esCombinableCon(Color otroColor) {
        return true; //En desarrollo
    }

}

public enum Categoria {
    PARTE_SUPERIOR,
    CALZADO,
    INFERIOR,
    ACCESORIOS;

}

public interface UnaCategoria {
    public Categoria GetCategoria();
}


public abstract class Prenda implements UnaCategoria {
    public Prenda(String material, ArrayList < Color > colores) {
        this.setMaterial(material);
        this.setColores(colores);
    }

    public String material;
    public ArrayList < Color > colores;

    public abstract Categoria GetCategoria();

    public final boolean hayMatchCombinacion(Prenda otraPrenda) {
        return true; //En desarrollo

    }
}

public class Pantalon extends Prenda {
    public Pantalon(String material, ArrayList <Color> colores) {
        super(material, colores);
    }

    @Override
    public Categoria GetCategoria() {
        return Categoria.INFERIOR;
    }
}


public class Camisa extends Prenda {
    public Camisa(String material, ArrayList <Color> colores) {
        super(material, colores);
    }
    @Override
    public Categoria GetCategoria() {
        return Categoria.PARTE_SUPERIOR;
    }
}

public class Zapatos extends Prenda {
    public Zapatos(String material, ArrayList <Color> colores) {
        super(material, colores);
    }
    @Override
    public Categoria GetCategoria() {
        return Categoria.CALZADO;
    }
}

public class Vestidor {
	//Ejemplo de implementacion
    public final void ejecutar() {}
        Color rojo = new Color(145, 162, 223);
        Color negro = new Color(0, 0, 0);
        Color blanco = new Color(255, 255, 255);
        Color amarillo = new Color(79, 62, 112);

        Pantalon pantalonFav = new Pantalon("cuero", new ArrayList < Color > (Arrays.asList(blanco, amarillo)));
        Pantalon patalonNegro = new Pantalon("jean", new ArrayList < Color > (Arrays.asList(negro)));
        Camisa camisaBlanca = new Camisa("algodon", new ArrayList < Color > (Arrays.asList(blanco)));

        ArrayList < Prenda > misPrendas = new ArrayList < Prenda > ();
        misPrendas.add(pantalonFav);
        misPrendas.add(camisaBlanca);
        misPrendas.add(patalonNegro);

        boolean combinan = pantalonFav.hayMatchCombinacion(camisaBlanca);
    }

}
