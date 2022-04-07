public class Prenda
{
    // Se instancian de variables
    String estado;
    String tipo;
    int precio;
    int descuentoPorPromocion = 0;
 
    // Constructor de clase
    public Prenda(String estado, String tipo,int precio, int descuentoPorPromocion)
    {
        this.estado = estado;
        this.tipo = tipo;
        this.descuentoPorPromocion = descuentoPorPromocion;
        setPrecio(precio,tipo,descuentoPorPromocion);
    }
 
    public void setPrecio(int precio, String tipo, int descuentoPorPromocion)
    {
        int precioResult = precio;
		//Aca haria un switch usando enum para los tipo de prendas (re-pensar)
        //No pongo el caso de prenda nueva porque no hay modificacion en su precio
        if(tipo == "promocion"){
            precioResult = precioResult - variacionPrecio;
        }
        if(tipo == "liquidacion"){
            precioResult = precioResult*0.5;
        }
        this.precio = precioResult;
    }

    public String getPrecio()
    {
        return this.precio;
    }
    public String getTipo()
    {
        return this.tipo;
    }
 
}


/*Ah, un requerimiento más: Macowins registra las ventas de estas prendas y necesita saber las ganancias de un determinado día. 

“Cada venta tiene asociada las prendas que se vendieron, su cantidad y la fecha de venta. 
Las ventas pueden ser en efectivo o con tarjeta. En el caso que sea con tarjeta, tienen el mismo comportamiento que en efectivo (el cual no modifica el precio), sólo que se le aplica un recargo 
según la cantidad de cuotas seleccionadas (cantidad de cuotas * un coeficiente fijo + 0.01 del valor de cada prenda).”
 */

public class Venta{
    ArrayList<Prenda> prendas;
    int cantidadPrendasVendidas; //esto tambn se podria deducir del size de la lista de prendas
    String fecha; // Formato: dd-MM-aaaa (esto tambn podria implementarse con Date)
    String metodoPago; //Efectivo o tarjeta (quiero usar intss)
    int cantidadCuotas = 0;

    
}


