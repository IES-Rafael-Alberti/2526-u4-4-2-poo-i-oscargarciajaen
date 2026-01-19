class Tiempo(var hora: Int) {
    var minuto: Int = 0
    var segundo: Int = 0

    constructor(hora: Int, minuto: Int) : this(hora) {
        this.minuto = minuto
    }

    constructor(hora: Int, minuto: Int, segundo: Int) : this(hora, minuto) {
        this.segundo = segundo
    }

    override fun toString(): String = "${hora}h ${minuto}m ${segundo}s"

    fun incrementar(t: Tiempo): Boolean{
        var segundoTotal = t.segundo + this.segundo
        var minutoTotal = t.minuto + this.minuto
        var horaTotal = t.hora + this.hora

        if (segundoTotal >= 60){
            minutoTotal += (segundoTotal / 60)
            segundoTotal %= 60
        }
        if (minutoTotal >= 60){
            horaTotal += (horaTotal / 60)
            minutoTotal %= 60
        }
        if (horaTotal > 23){
            return false
        } else {
            this.segundo = segundoTotal
            this.minuto = minutoTotal
            this.hora = horaTotal
            return true
        }
    }

    fun decrementar(t: Tiempo): Boolean{
        var tiempoIncial = (this.hora * 3600) + (this.minuto * 60) + this.segundo
        val tiempoADecrementar = (t.hora * 3600) + (t.minuto * 60) + t.segundo
        if (tiempoIncial > tiempoADecrementar){
            tiempoIncial = tiempoIncial - tiempoADecrementar
            if (tiempoIncial >= 3600){
                this.hora = tiempoIncial / 3600
                tiempoIncial %= 3600
            }
            if (tiempoIncial >= 60) {
                this.minuto = tiempoIncial / 60
                tiempoIncial %= 60
            }
            this.segundo = tiempoIncial
            return true
        } else {
            return false
        }
    }

    fun comparar(t: Tiempo): Int{
        val tiempoInicial = (this.hora * 3600) + (this.minuto * 60) + this.segundo
        val tiempoIntroducido = (t.hora * 3600) + (t.minuto * 60) + t.segundo

        var igual = 0
        if (tiempoInicial > tiempoIntroducido){
            igual = 1
        } else if (tiempoIntroducido > tiempoInicial){
            igual = -1
        } else {
            igual = 0
        }
        return igual
    }

    fun copiar(): Tiempo {
        var nuevoTiempo = Tiempo(this.hora, this.minuto, this.segundo)
        return nuevoTiempo
    }

    fun copiar(t: Tiempo): Tiempo {
        this.segundo = t.segundo
        this.minuto = t.minuto
        this.hora = t.hora
        return this
    }

    fun sumar(t: Tiempo): Tiempo?{
        var nuevoTiempo: Tiempo? = null
        var hora = t.hora + this.hora
        var minuto = t.minuto + this.minuto
        var segundo = t.segundo + this.segundo

        if (segundo >= 60){
            minuto += (segundo / 60)
            segundo %= 60
        }

        if (minuto >= 60){
            hora += (minuto / 60)
            minuto %= 60
        }

        if (hora >= 24){
            nuevoTiempo = null
        } else {
            nuevoTiempo = Tiempo(hora, minuto, segundo)
        }
        return nuevoTiempo
    }

    fun restar(t: Tiempo): Tiempo?{
        var nuevaHora = 0
        var nuevoTiempo: Tiempo? = null
        val tiempoIncial = (this.hora * 3600) + (this.minuto * 60) + this.segundo
        val tiempoARestar = (t.hora * 3600) + (t.minuto * 60) + t.segundo
        var nuevoMinuto = 0
        var nuevoSegundo = 0


        if (tiempoIncial <  tiempoARestar){
            return nuevoTiempo
        } else {
            var tiempoTotal = tiempoIncial - tiempoARestar
            if (tiempoTotal >= 3600) {
                nuevaHora = tiempoTotal / 3600
                tiempoTotal %= 3600
            }

            if (tiempoTotal > 60){
                nuevoMinuto = tiempoTotal / 60
                tiempoTotal %= 60
            }
            nuevoSegundo = tiempoTotal
            nuevoTiempo = Tiempo(nuevaHora, nuevoMinuto, nuevoSegundo)
            return nuevoTiempo
        }
    }

    fun esMayorQue(t: Tiempo): Boolean{
        var mayorQue = false
        val tiempoIncial = (this.hora * 3600) + (this.minuto * 60) + this.segundo
        val tiempoIntroducido = (t.hora * 3600) + (t.minuto * 60) + t.segundo

        if (tiempoIncial > tiempoIntroducido){
            mayorQue = true
        }
        return mayorQue
    }

    fun esMenorQue(t: Tiempo): Boolean{
        var menorQue = false
        val tiempoIncial = (this.hora * 3600) + (this.minuto * 60) + this.segundo
        val tiempoIntroducido = (t.hora * 3600) + (t.minuto * 60) + t.segundo

        if (tiempoIncial < tiempoIntroducido){
            menorQue = true
        }
        return menorQue
    }
}

fun solicitarTiempo():Tiempo{
    var segundo: Int? = null

    do {
        println("Ingrese los segundos o 'x' para omitir")
        val entrada: String? = readLine()
        if (entrada != null && entrada != "x") {
            if (entrada.all {it -> it.isDigit()}) {
                segundo = entrada.toInt()
            } else {
                println("Entrada inválida")
            }
        } else {
            segundo = 0
        }
    } while(segundo == null)

    var minuto: Int? = null

    do {
        println("Ingrese los minutos o 'x' para omitir")
        val entrada: String? = readLine()
        if (entrada != null && entrada != "x") {
            if (entrada.all {it -> it.isDigit()}) {
                minuto = entrada.toInt()
            } else {
                println("Entrada inválida")
            }
        } else {
            minuto = 0
        }
    } while(minuto == null)

    var hora: Int? = null

    do {
        println("Ingrese las horas o 'x' para omitir")
        val entrada: String? = readLine()
        if (entrada != null && entrada != "x") {
            if (entrada.all {it -> it.isDigit()}) {
                hora = entrada.toInt()
            } else {
                println("Entrada inválida")
            }
        } else {
            hora = 0
        }
    } while(hora == null)

    val tiempo = Tiempo(hora, minuto, segundo)
    return tiempo
}

fun main() {

    val principal = solicitarTiempo()
    val t = solicitarTiempo()
    println("Objeto inicial: $principal")
    println("Objeto T: $t")

    val tiempoIncrementar = principal.copiar()
    if (tiempoIncrementar.incrementar(t) == true){
        println("Incrementar: $tiempoIncrementar")
    } else {
        println("Incrementar: Error (supera 23:59:59)")
    }

    val tiempoDecrementar = principal.copiar()
    if (tiempoDecrementar.decrementar(t) == true){
        println("Decrementar: $tiempoDecrementar")
        }  else {
            println("Decrementar: Error (menor que 00:00:00)")
    }

    val comparar = principal.comparar(t)
    if (comparar == -1){
        println("Principal menor")
    } else if (comparar == 1){
        println("Principal mayor")
    } else {
        println("Iguales")
    }

    val clon = principal.copiar()
    println("Copiado: $clon")

    val tiempoCopiaT = Tiempo(0).copiar(t)
    println("Copiar de T al objeto: $tiempoCopiaT")

    val suma = principal.sumar(t)
    if (suma == null){
        println("Error (Excede 24h)")
    } else {
        println(suma)
    }

    val resta = principal.restar(t)
    if (resta == null){
        println("Error resta negativa")
    } else {
        println(resta)
    }

    val mayorque = principal.esMayorQue(t)
    if (mayorque == true){
        println("Principal es mayor que t")
    } else {
        println("Principal no es mayor que t")
    }

    val menorque = principal.esMenorQue(t)
    if (menorque == true){
        println("Principal es menor que t")
    } else {
        println("Principal no es menor que t")
    }
}