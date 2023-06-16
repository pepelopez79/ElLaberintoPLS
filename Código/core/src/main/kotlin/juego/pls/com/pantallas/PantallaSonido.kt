package juego.pls.com.pantallas

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputListener
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import juego.pls.com.*

class PantallaSonido(game: Juego): Pantalla() {
    var juego: Juego
    private var escenario: Stage = Stage()

    companion object{
        var musicaEncendida = true
    }

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
        val etiqueta = Label("Sonido", skinBoton)
        tabla.addActor(etiqueta)
        etiqueta.setPosition(etiqueta.originX - 45, etiqueta.originY + 200)

        // Etiqueta Música
        val etiquetaMusica = Label("Musica", skinBoton)
        tabla.addActor(etiquetaMusica)
        etiquetaMusica.setPosition(etiquetaMusica.originX - 170, etiquetaMusica.originY + 60)

        // Botón Música On
        val botonMusicOn = TextButton("On", skinBoton)
        botonMusicOn.setPosition(etiqueta.originX - 50, etiqueta.originY + 30)
        botonMusicOn.width = 150f
        botonMusicOn.height = 80f
        botonMusicOn.addListener(object: InputListener() {
            override fun touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                sonidoBoton.play(volumenBotones)
                return true
            }
            override fun touchUp(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int) {
                volumenMusica = 0.5f
                musicaEncendida = true
            }
        })
        tabla.addActor(botonMusicOn)

        // Botón Música Off
        val botonMusicOff = TextButton("Off", skinBoton)
        botonMusicOff.setPosition(etiqueta.originX + 50, etiqueta.originY + 30)
        botonMusicOff.width = 150f
        botonMusicOff.height = 80f
        botonMusicOff.addListener(object: InputListener() {
            override fun touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                sonidoBoton.play(volumenBotones)
                return true
            }
            override fun touchUp(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int) {
                volumenMusica = 0f
                musicaEncendida = false
            }
        })
        tabla.addActor(botonMusicOff)

        // Etiqueta Botones
        val etiquetaEfectos = Label("Botones", skinBoton)
        tabla.addActor(etiquetaEfectos)
        etiquetaEfectos.setPosition(etiquetaEfectos.originX - 170, etiquetaEfectos.originY)

        // Botón Sonido Botones On
        val botonBotonOn = TextButton("On", skinBoton)
        botonBotonOn.setPosition(etiqueta.originX - 50, etiqueta.originY - 30)
        botonBotonOn.width = 150f
        botonBotonOn.height = 80f
        botonBotonOn.addListener(object: InputListener() {
            override fun touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                sonidoBoton.play(volumenBotones)
                return true
            }
            override fun touchUp(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int) {
                musica.play()
                volumenBotones = 1f
            }
        })
        tabla.addActor(botonBotonOn)

        // Botón Sonido Botones Off
        val etiquetaBotonOff = TextButton("Off", skinBoton)
        etiquetaBotonOff.setPosition(etiqueta.originX + 50, etiqueta.originY - 30)
        etiquetaBotonOff.width = 150f
        etiquetaBotonOff.height = 80f
        etiquetaBotonOff.addListener(object: InputListener() {
            override fun touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                sonidoBoton.play(volumenBotones)
                return true
            }
            override fun touchUp(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int) {
                musica.stop()
                volumenBotones = 0f
            }
        })
        tabla.addActor(etiquetaBotonOff)

        // Botón Volver
        val botonVolver = crearBoton("Volver", skinBoton, etiqueta , juego, 200, - 90, false, PantallaAjustes(juego))
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