/*
    Crear una clase Persona que tenga nombre, peso (en kg con decimales), altura (en metros con decimales) y su imc.

    Crear un constructor primario con todos los atributos, excepto nombre e imc. 
    Este último atributo se calcula en función del peso y la altura. Por tanto no se debe poder modificar, pero si consultar.

    Crear un constructor secundario que también incluya el nombre de la persona cómo parámetro.

    Implementa el método toString, representación del objeto en forma de String: override fun toString() = "". (Pulsa Ctrl+o)

    En el main(), crear 3 personas diferentes (la primera sin nombre) utilizando el constructor primario y secundario. 
    Después mostrarlas por consola y a continuación, realizar lo siguiente:
        Sobre la persona 1:
            Modificar su nombre y para ello debes solicitarlo al usuario por consola. No puede ser nulo o vacio.
            Mostrar por consola sólo el nombre, peso y altura.
        Sobre la persona 3:
            Mostrar el peso, altura y imc.
            Modificar la altura, por ejemplo a 1.80
            Mostrar el peso, altura y imc.
        Sobre la persona 2:
            Modificar la altura para que tenga el mismo valor que la persona 3.
            Mostrar la persona 2 y persona 3.
            Comparar si las dos personas son iguales, y mostrar el resultado.
            Implementa el método equals():boolean (Pulsa Ctrl+o).
            Ejecutar la comparación.
 */

class Persona(var altura:Double, var peso:Double){
    var nombre:String = ""
    val imc:Double = peso / (altura * altura)

    constructor(nombre:String, altura:Double, peso:Double) : this(altura, peso){
        this.nombre = nombre
    }

    override fun toString(): String {
        return "Nombre: $nombre | Peso: $peso | Altura: $altura | IMC: ${"%.2f".format(imc)}"
    }   
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

fun main(){
    var persona1 = Persona(1.72, 54.8)
    var persona2 = Persona("juan", 1.56, 48.2)
    var persona3 = Persona("valeria", 1.48, 40.2)
    println(persona1)
    println(persona2)
    println(persona3)
    persona1.nombre = solicitarNombre()
    println("Nombre: ${persona1.nombre} Peso : ${persona1.peso} Altura: ${persona1.altura}")
    println("Peso : ${persona3.peso} Altura: ${persona3.altura} IMC: ${persona3.imc}")
    persona3.altura = 1.80
    println("Peso : ${persona3.peso} Altura: ${persona3.altura} IMC: ${persona3.imc}")
    persona2.altura = persona3.altura
    println(persona2)
    println(persona3)
    if (persona2.nombre == persona3.nombre && persona2.peso == persona3.peso && persona2.altura == persona3.peso){
        println("iguales")
    } else {
        println("diferentes")
    }
}
