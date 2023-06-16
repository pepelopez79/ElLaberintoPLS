package juego.pls.com.pantallas

import com.badlogic.gdx.Files
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import juego.pls.com.*
import juego.pls.com.pantallas.PantallaSonido.Companion.musicaEncendida

class PantallaCreditos(game: Juego): Pantalla() {
    var sonidoFin: Sound = Gdx.audio.newSound(Gdx.files.getFileHandle("Sonidos/MusicaFinal.mp3", Files.FileType.Internal))

    var juego: Juego
    private var escenario: Stage = Stage()
    private val seta = Texture("Objetos/SetaGrande.png")

    init {
        this.juego = game
        sonidoFin.play(volumenMusica)
    }

    private fun pantallaMenu() {
        val tabla = Table()
        tabla.setPosition(ANCHO / 2f, ALTO / 2f)
        tabla.setFillParent(true)
        tabla.height = 400f
        escenario.addActor(tabla)

        // Etiqueta de texto
        val etiquetaGameOver = Label("Fin del Juego", skinBoton)
        tabla.addActor(etiquetaGameOver)
        etiquetaGameOver.setPosition(etiquetaGameOver.originX - 90, etiquetaGameOver.originY + 220)
        val etiquetaEliminado = Label("El Laberinto", skinBoton)
        tabla.addActor(etiquetaEliminado)
        etiquetaEliminado.setPosition(etiquetaEliminado.originX - 88, etiquetaEliminado.originY + 170)
        val etiquietaAutor = Label("Pepe Lopez", skinBoton)
        tabla.addActor(etiquietaAutor)
        etiquietaAutor.setPosition(etiquietaAutor.originX - 78, etiquietaAutor.originY + 120)

        // Botón Menú Principal
        val botonMenu = crearBoton("Menu Principal", skinBoton, etiquetaGameOver, juego, 200,  - 270, false, MenuPrincipal(juego))
        tabla.addActor(botonMenu)

        Gdx.input.inputProcessor = escenario
    }

    override fun show() {
        musica.volume = 0f
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
        sb.draw(seta, 340f, 70f)
    }

    override fun depurar(delta: Float) {
        escenario.draw()
    }

    override fun dispose() {
        escenario.dispose()
    }

    override fun hide() {
        sonidoFin.stop()
        if (musicaEncendida) musica.volume = volumenMusica
    }

    override fun pause() {
    }

    override fun resize(width: Int, height: Int) {
    }

    override fun resume() {
    }
}