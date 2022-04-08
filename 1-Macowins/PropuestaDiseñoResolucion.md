# Macdowins

## 1) Requerimientos identificados
- Conocer el precio de venta por prenda y tipos.
- Conocer las ganancias de un determinado dia.

## 2) Diagrama de clases
![image](https://user-images.githubusercontent.com/29473055/162368065-6c1420e6-8820-4132-b370-5ced68842db3.png)

## 3) Implementacion de clases

### Clase Prenda
```java
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
``` 

### Clase Venta
```java
public class Venta{
    int coeficientePagoTarjeta = 0.5; // Valor Fijo
    ArrayList<Prenda> prendas;
    int cantidadPrendasVendidas; 
    String fecha; // Formato: dd-MM-aaaa (esto tambn podria implementarse con Date)
    String metodoPago; //Efectivo o tarjeta 
    int cantidadCuotas;

    // Constructor de clase
    public Venta(ArrayList<Prenda> prendas, int cantidadPrendasVendidas,String fecha, String metodoPago,int cantidadCuotas)
    {
        this.prendas = prendas;
        this.cantidadPrendasVendidas = cantidadPrendasVendidas;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.cantidadCuotas = cantidadCuotas;
    }

    public int getPrecioFinal(){
        int precioFinalResult = 0;
        //Recorro todas las prendas contenidas por la venta actual
        for (Prenda prenda:this.prendas) {
            int precioActual = prenda.getPrecio();
            if(this.metodoPago == "tarjeta"){
                precioActual = precioActual + getRecargoTarjeta(prenda);
            }
            precioFinalResult=precioFinalResult + precioActual;
        }
        return precioFinalResult;
    }

    private getRecargoTarjeta(Prenda prenda){
        return this.cantidadCuotas * this.coeficientePagoTarjeta + 0.1 * prenda.getPrecio();
    }
}
``` 

### Clase Contador
```java
public class Contador{
    ArrayList<Ventas> ventas;

    // Constructor de clase
    public Contador(ArrayList<Prenda> ventas)
    {
        this.ventas = ventas;
    }

    public int getGananciasPorDia(String fecha){
        int precioFinalResult = 0;
        for (Ventas venta:this.ventas) {
            if(venta.fecha == fecha){
                precioFinalResult = venta.getPrecioFinal();
            }
        }
        return precioFinalResult;
    }

    public void agregarVenta(Venta venta){
        this.ventas.add(venta);
    }
}
```
## 4) Aclaraciones
Para conocer el precio por prenda y sus tipos tenemos a la clase 'Prenda'
La clase 'Contador' sera la encargada de almacenar todas las ventas realizadas, es por esto que tiene un metodo para agregar ventas que se usara a medida que sigan efectuandose ventas, y a su vez tambien de informar segun fecha indicada las ganancias por ese día.

