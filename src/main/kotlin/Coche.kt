/*¶

    Crear una clase Coche, a través de la cual se pueda conocer el color del coche, la marca, el modelo, el número de caballos, el número de puertas y la matrícula. 
    Crear el constructor del coche, así como el método toString().
        Todas sus propiedades tendrán tipos de datos nulables.
        Marca y modelo no podrán ser vacíos, ni nulos. Tampoco podrán modificarse y solo se inicializarán al crear el objeto.
        Número de caballos, número de puertas y matrícula no podrán modificarse, ni podrán ser nulos.
        Color podrá modificarse, pero no podrá ser nulo.

    Recuerda que Kotlin añade los getters y setters con el comportamiento por defecto, por lo que no es necesario que los implementes, a no ser que tengas que añadir alguna funcionalidad extra.
        El atributo matricula no debe permitir un valor que no tenga 7 caracteres.
        Los atributos modelo y marca siempre se devolverán con la primera letra en mayúscula (getter).
        El número de caballosdeberá tener un valor entre 70 y 700.
        El número de puertas no podrá ser inferior a 3, ni superior a 5.
        Ten en cuenta todas estas condiciones a la hora de crear el constructor de la clase.

    En el programa principal, instancia varios coches, muéstralos por pantalla (toString) y realiza lo siguiente:
        Intenta instanciar un coche con la marca y modelo con valores nulos o vacíos y comprueba que no es posible.
        Intenta instanciar un coche con el número de caballos con un valor inferior a 70 o superior a 700 y comprueba que no es posible.
        Intenta instanciar un coche con el número de puertas con un valor inferior a 3 o superior a 5 y comprueba que no es posible.
        Intenta instanciar un coche con la matrícula con un valor que no tenga 7 caracteres y comprueba que no es posible.
        Intenta instanciar y modificar el color a un valor nulo y comprueba que no es posible.
        Todas estas pruebas debes hacerla capturando las excepciones que deben lanzarse desde la clase Coche cuando el valor de una propiedad no es correcto (según los resuisitos del ejercicio)
 */

class Coche(color: String, val marca:String, val modelo: String, val numeroCaballos: Int, val numeroPuertas: Int, val matricula:String) {

    init {
        require(color.isNotBlank() && marca.isNotBlank() && modelo.isNotBlank()) {"Atributos Vacíos"}
        require(matricula.length == 7) {"Tamaño de matrícula inválido"}
        require(numeroCaballos in 70..700) {"El número de caballos debe estar entre 70 - 700"}
        require(numeroPuertas in 3..5) {"El número de puertas debe estar entre 3 - 5"}
    }

    var color = color
        set(value){
            require(value.isNotBlank()) {"El color no puede ser nulo u estar vacío"}
        }

    val marcaUppercase:String
        get() = marca.uppercase()

    val modeloUppercase: String
        get() = modelo.uppercase()

    override fun toString(): String {
        return "Coche | Marca: ${marca} | Modelo: ${modelo} | Número de caballos: ${numeroCaballos} | Número de puertas: ${numeroPuertas} | Matricula: ${matricula} | Color: ${color}"
    }
}

fun main(){
    try {
        val urus = Coche("Verde", "Lamborghini", "Urus", 500, 3, "6453YCF")
        val carrera = Coche("Gris Mate", "Porsche", "911 Carrera", 285, 4, "7215KYF")
        val peugeot = Coche ("Azul", "Peugeot", "307 sw", 90, 5, "2824CTP")
        println(urus)
        println(carrera)
        println(peugeot)
        val marcanula = Coche("Rosa", "", "", 700, 4, "6578FDE")
        val caballosNoValidos = Coche("Rosa", "Toyota", "Supra", 701, 4, "6578FDJ")
        val puertasNoValidas = Coche("Rosa", "Toyota", "Supra", 700, 2, "6578FDE")
        val matriculaNoValida = Coche("Rosa", "Toyota", "Supra", 700, 3, "6578EJ")
        val colorNulo = Coche("Rosa", "Toyota", "Supra", 700, 3, "6578FJE")
        colorNulo.color = ""
        println(colorNulo)
    } catch (e: Exception) {
        println(e.message)
    }
}

