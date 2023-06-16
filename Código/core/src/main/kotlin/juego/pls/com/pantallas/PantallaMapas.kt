package juego.pls.com.pantallas

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import juego.pls.com.*

class PantallaMapas(game: Juego): Pantalla() {
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
        val etiqueta = Label("Mapas", skinBoton)
        tabla.addActor(etiqueta)
        etiqueta.setPosition(etiqueta.originX - 40, etiqueta.originY + 200)

        // Botón Mapa1
        val botonMapa1 = crearBoton("Almacen", skinBoton, etiqueta, juego, 200, 30, false, PantallaAccion(juego, mapa1))
        tabla.addActor(botonMapa1)

        // Botón Mapa2
        val botonMapa2 = crearBoton("Fabrica", skinBoton, etiqueta, juego, 200, - 30, false, PantallaAccion(juego, mapa2))
        tabla.addActor(botonMapa2)

        // Botón Mapa3
        val botonMapa3 = crearBoton("Parque", skinBoton, etiqueta , juego, 200, - 90, false, PantallaAccion(juego, mapa3))
        tabla.addActor(botonMapa3)

        // Botón Volver
        val botonVolver = crearBoton("Volver", skinBoton, etiqueta , juego, 200, - 150, false, MenuPrincipal(juego))
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