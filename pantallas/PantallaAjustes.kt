package juego.pls.com.pantallas

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import juego.pls.com.*

class PantallaAjustes(game: Juego): Pantalla() {
    var juego: Juego
    private var escenario: Stage = Stage()

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
        val etiqueta = Label("Ajustes", skinBoton)
        tabla.addActor(etiqueta)
        etiqueta.setPosition(etiqueta.originX - 60, etiqueta.originY + 200)

        // Botón Ajustes de Sonido
        val botonSonido = crearBoton("Sonido", skinBoton, etiqueta, juego, 200, 30, false, PantallaSonido(juego))
        tabla.addActor(botonSonido)

        // Botón Controles
        val botonControles = crearBoton("Controles", skinBoton, etiqueta, juego, 200, - 30, false, PantallaControles(juego))
        tabla.addActor(botonControles)

        // Botón Volver
        val botonVolver = crearBoton("Volver", skinBoton, etiqueta , juego, 200, - 90, false, MenuPrincipal(juego))
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