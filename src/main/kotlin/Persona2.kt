/*
    Actualizar el ejercicio 4.2 para añadir a la clase Persona el siguiente comportamiento:
        Debe retornar un saludo con su nombre... saludar():String
        Debe retornar si altura por encima de la media (solo si altura >= 1.75)... alturaEncimaMedia():Boolean
        Debe retornar si peso por encima de la media (solo si peso >= 70)... pesoEncimaMedia():Boolean

        Sería conveniente añadir también un método obtenerDescImc() para usar en obtenerDesc(), que implemente el retorno de la descripción del rango de tipo de imc al que equivale su cálculo.
            Si el IMC es menos de 18.5, se encuentra dentro del rango de "peso insuficiente".
            Si el IMC está entre 18.5 y 24.9, se encuentra dentro del rango de "peso saludable".
            Si el IMC está entre 25.0 y 29.9, se encuentra dentro del rango de "sobrepeso".
            Si el IMC es 30.0 o superior, se encuentra dentro del rango de "obesidad".

        Nota: (Mejora: Enum class en https://www.baeldung.com/kotlin/enum)

        Debe implementar también un método que muestre una descripción completa de la persona... obtenerDesc():String. Por ejemplo, este método mostrará por pantalla algo así:

        "Julia con una altura de 1.72m (Por debajo de la media) y un peso 64.7kg (Por encima de la media) tiene un IMC de 21,87 (peso saludable)". 

        2. Crear en el main() una estructura de datos con 4 o 5 personas más, recorrer la estructura y por cada persona debe saludar y mostrar su descripción completa.

    Finalmente, revisa el IDE e intenta actualizar el modificador de visibilidad de los métodos de tu clase cómo os estará indicando... veréis que los métodos que realmente no van a ser llamados desde fuera de la clase te recomienda que sean privados a la misma. De esta manera estamos encapsulando estos métodos para que se puedan utilizar solo desde dentro de la clase y no sean públicos.
 */

class Persona2(var altura:Double, var peso:Double){
    var nombre:String = ""
    val imc:Double get() = peso / (altura * altura)

    constructor(nombre:String, altura:Double, peso:Double) : this(altura, peso){
        this.nombre = nombre
    }

    override fun toString(): String {
        return "Nombre: $nombre | Peso: $peso | Altura: $altura | IMC: ${"%.2f".format(imc)}"
    }

    fun saludar():String{
        return "Hola soy ${nombre}"
    }

    fun alturaEncimaMedia():Boolean{
        var alturaEncimaMedia: Boolean = false
        if (altura >= 1.75){
            alturaEncimaMedia = true
        }
        return alturaEncimaMedia
    }

    fun pesoEncimaMedia():Boolean{
        var pesoEncimaMedia: Boolean = false
        if (peso >= 70){
            pesoEncimaMedia = true
        }
        return pesoEncimaMedia
    }

    fun obtenerDescImc():String{
        var estado: String = "null"
        if (imc < 18.5){
            estado = "peso insuficiente"
        } else if (imc >= 18.5 && imc <= 24.9) {
            estado = "peso saludable"
        } else if (imc >= 25.0 && imc <= 29.9){
            estado = "sobrepeso"
        } else if (imc > 30.0){
            estado = "obesidad"
        }
        return estado
    }

    fun solicitarNombre():String{
        var nombre: String? = null

        do{
            println("Introduce el nombre de la persona")
            val entrada:String? = readLine()
            if (entrada != null && entrada.isNotBlank() && entrada.all {it -> it.isLetter()}){
                nombre = entrada
            } else {
                println("Entrada Inválida")
            }
        } while(nombre == null)
        return nombre
    }
}

fun main(){
    var persona1 = Persona2("Pedro", 1.72, 54.8)
    var persona2 = Persona2("Juan", 1.56, 48.2)
    var persona3 = Persona2("Valeria", 1.97, 40.2)
    var persona4 = Persona2("Josemi", 1.56, 90.0)
    var persona5 = Persona2("Eduardo", 1.90, 80.0)
    val listaObjetos: List<Persona2> = listOf(persona1, persona2, persona3, persona4, persona5)
    var estadoAltura:String = "Nada"
    var estadoPeso:String = "Nada"
    for (i in listaObjetos){
        if (i.alturaEncimaMedia() == true){
            estadoAltura = "Por encima de la media"
        } else {
            estadoAltura = "Por debajo de la media"
        }

        if (i.pesoEncimaMedia() == true){
            estadoPeso = "Por encima de la media"
        } else {
            estadoPeso = "Por debajo de la media"
        }
        println(i.saludar())
        println("${i.nombre} con una altura de ${i.altura} (${estadoAltura}) y un peso ${i.peso} (${estadoPeso}) tiene un IMC de ${i.imc}(${i.obtenerDescImc()})")
    }
}
