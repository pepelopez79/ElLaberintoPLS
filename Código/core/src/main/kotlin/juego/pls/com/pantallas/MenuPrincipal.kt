package juego.pls.com.pantallas

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import juego.pls.com.*

class MenuPrincipal(game: Juego): Pantalla() {
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
        val etiqueta = Label("El Laberinto", skinBoton)
        tabla.addActor(etiqueta)
        etiqueta.setPosition(etiqueta.originX - 90, etiqueta.originY + 200)

        // Botón Play
        val botonPlay = crearBoton("Nuevo / Continuar", skinBoton, etiqueta, juego, 200, 30, false, PantallaAccion(juego, Juego.ultimoMapaJugado))
        tabla.addActor(botonPlay)

        // Botón Mapas
        val botonMapas = crearBoton("Mapas", skinBoton, etiqueta, juego, 200, - 30, false, PantallaMapas(juego))
        tabla.addActor(botonMapas)

        // Botón Configuración
        val botonConfiguracion = crearBoton("Ajustes", skinBoton, etiqueta, juego, 200, - 90, false, PantallaAjustes(juego))
        tabla.addActor(botonConfiguracion)

        // Botón Salir
        val botonSalir = crearBoton("Salir", skinBoton, etiqueta, juego, 200, - 150, true, null)
        tabla.addActor(botonSalir)

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