package juego.pls.com.pantallas

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import juego.pls.com.objetos.Jugador.Companion.abajo
import juego.pls.com.objetos.Jugador.Companion.arriba
import juego.pls.com.objetos.Jugador.Companion.derecha
import juego.pls.com.objetos.Jugador.Companion.izquierda
import juego.pls.com.*

class PantallaControles(game: Juego): Pantalla() {
    var juego: Juego
    private var escenario: Stage = Stage()

    // Teclas
    private val a = Texture("Controles/a.png")
    private val botonIzquierda = Texture("Controles/botonIzquierda.png")
    private val w = Texture("Controles/w.png")
    private val botonArriba = Texture("Controles/botonArriba.png")
    private val s = Texture("Controles/s.png")
    private val botonAbajo = Texture("Controles/botonAbajo.png")
    private val d = Texture("Controles/d.png")
    private val botonDerecha = Texture("Controles/botonDerecha.png")
    private val botonEspacio = Texture("Controles/espacio.png")
    private val botonEsc = Texture("Controles/escape.png")

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
        val etiqueta = Label("Controles", skinBoton)
        tabla.addActor(etiqueta)
        etiqueta.setPosition(etiqueta.originX - 75, etiqueta.originY + 200)

        // Etiqueta Cambiar Cámara
        val etiquetaCamara = Label("Ver Mapa", skinBoton)
        tabla.addActor(etiquetaCamara)
        etiquetaCamara.setPosition(etiquetaCamara.originX - 8, etiquetaCamara.originY - 102)

        // Etiqueta Volver Menú Principal
        val etiquetaSalir = Label("Salir", skinBoton)
        tabla.addActor(etiquetaSalir)
        etiquetaSalir.setPosition(etiquetaSalir.originX + 18, etiquetaSalir.originY - 154)

        // Botón Volver
        val botonVolver = crearBoton("Volver", skinBoton, etiqueta , juego, 200, - 250, false, PantallaAjustes(juego))
        tabla.addActor(botonVolver)

        Gdx.input.inputProcessor = escenario
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
        sb.draw(a, 340f, 430f)
        sb.draw(botonIzquierda, 410f, 430f)
        sb.draw(izquierda, 480f, 430f)
        sb.draw(w, 340f, 370f)
        sb.draw(botonArriba, 410f, 370f)
        sb.draw(arriba, 480f, 370f)
        sb.draw(s, 340f, 310f)
        sb.draw(botonAbajo, 410f, 310f)
        sb.draw(abajo, 480f, 310f)
        sb.draw(d, 340f, 250f)
        sb.draw(botonDerecha, 410f, 250f)
        sb.draw(derecha, 480f, 250f)
        sb.draw(botonEspacio, 360f, 180f)
        sb.draw(botonEsc, 375f, 144f)
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