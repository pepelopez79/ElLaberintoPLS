package juego.pls.com.pantallas

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import juego.pls.com.*

class PantallaGameOver(game: Juego): Pantalla() {
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
        val etiquetaGameOver = Label("Game Over", skinBoton)
        tabla.addActor(etiquetaGameOver)
        etiquetaGameOver.setPosition(etiquetaGameOver.originX - 75, etiquetaGameOver.originY + 200)
        val etiquetaEliminado = Label("Jugador Eliminado", skinBoton)
        tabla.addActor(etiquetaEliminado)
        etiquetaEliminado.setPosition(etiquetaEliminado.originX - 135, etiquetaEliminado.originY + 150)

        // Botón Reintentar
        val botonReintentar = crearBoton("Reintentar", skinBoton, etiquetaGameOver, juego, 200, 30, false, PantallaAccion(juego, Juego.ultimoMapaJugado))
        tabla.addActor(botonReintentar)

        // Botón Mapas
        val botonMapas = crearBoton("Mapas", skinBoton, etiquetaGameOver, juego, 200, - 30, false, PantallaMapas(juego))
        tabla.addActor(botonMapas)

        // Botón Menú Principal
        val botonMenu = crearBoton("Menu Principal", skinBoton, etiquetaGameOver, juego, 200,  - 90, false, MenuPrincipal(juego))
        tabla.addActor(botonMenu)


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