/*
    Crear una clase Rectángulo, con atributos base y altura. La clase debe disponer del constructor y 
    los métodos para calcular el area y el perimetro. Los atributos no se podrán modificar, aunque si consultar. 
    Por último, tendrán que ser mayor que 0.

    Opcionalmente se puede crear el método toString() para mostrar información sobre el 
    rectángulo: override fun toString() = "". (Pulsa Ctrl+o)

    En el programa principal, crear varios rectángulos. Mostarlos y mostrar por pantalla sus áreas y perímetros.
 */

class Rectangulo(val base:Double, val altura:Double){

    init {
        require(altura > 0) { "La altura debe ser mayor a 0" }
        require(base > 0) { "La base debe ser mayor a 0" }
    }

    fun calcularArea():Double{
        val area: Double = base * altura
        return area
    }

    fun calcularPerimetro():Double{
        val perimetro: Double = (base * 2) + (altura * 2)
        return perimetro
    }

    override fun toString(): String = "El rectangulo tiene un base de ${calcularArea()} y una altura de ${calcularPerimetro()} "

}

fun main(){
    try {
        val rectangulo1 = Rectangulo(6.0, 2.0)
        val rectangulo2 = Rectangulo(8.0, 6.0)
        val rectangulo3 = Rectangulo(2.0, 1.0)
        println(rectangulo1)
        println(rectangulo2)
        println(rectangulo3)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

}


