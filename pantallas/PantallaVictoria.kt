package juego.pls.com.pantallas

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import juego.pls.com.*

class PantallaVictoria(game: Juego, var contadorMonedas: Int): Pantalla() {
    var juego: Juego
    private var escenario: Stage = Stage()
    var moneda = Texture("Objetos/MonedaGrande.png")

    init {
        this.juego = game
    }

    private fun pantallaMenu() {
        val tabla = Table()
        tabla.setPosition(ANCHO / 2f, ALTO / 2f)
        tabla.setFillParent(true)
        tabla.height = 400f
        escenario.addActor(tabla)

        // Etiqueta de texto
        val etiquetaGameOver = Label("Nivel Completado", skinBoton)
        tabla.addActor(etiquetaGameOver)
        etiquetaGameOver.setPosition(etiquetaGameOver.originX - 125, etiquetaGameOver.originY + 200)
        val etiquetaEliminado = Label("$contadorMonedas / 3", skinBoton)
        tabla.addActor(etiquetaEliminado)
        etiquetaEliminado.setPosition(etiquetaEliminado.originX, etiquetaEliminado.originY + 150)

        // Botón Siguiente Nivel
        val botonSiguiente = crearBoton("Siguiente Nivel", skinBoton, etiquetaGameOver, juego, 200, 30, false, PantallaAccion(juego, siguienteNivel()))
        tabla.addActor(botonSiguiente)

        // Botón Mapas
        val botonMapas = crearBoton("Mapas", skinBoton, etiquetaGameOver, juego, 200, - 30, false, PantallaMapas(juego))
        tabla.addActor(botonMapas)

        // Botón Menú Principal
        val botonMenu = crearBoton("Menu Principal", skinBoton, etiquetaGameOver, juego, 200, - 90, false, MenuPrincipal(juego))
        tabla.addActor(botonMenu)

        Gdx.input.inputProcessor = escenario
    }

    fun siguienteNivel(): IntArray {
        var siguiente = mapa1
        if (Juego.ultimoMapaJugado.contentEquals(mapa1)) siguiente = mapa2
        if (Juego.ultimoMapaJugado.contentEquals(mapa2)) siguiente = mapa3
        return siguiente
    }

    override fun show() {
        pantallaMenu()
    }

    override fun leerEntrada(delta: Float) {
    }

    override fun actualizar(delta: Float) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        escenario.act(delta)
    }

    override fun dibujar(delta: Float) {
        sb.draw(fondoMenus, 0f, 0f, 0, 0, ANCHO, ALTO)
        sb.draw(moneda, 450f, - 128f, 0, 0, ANCHO, ALTO)
    }

    override fun depurar(delta: Float) {
        escenario.draw()
    }

    override fun dispose() {
        escenario.dispose()
    }

    override fun hide() {
    }

    override fun pause() {
    }

    override fun resize(width: Int, height: Int) {
    }

    override fun resume() {
    }
}