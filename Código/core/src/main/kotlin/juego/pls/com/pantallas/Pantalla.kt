package juego.pls.com.pantallas

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputListener
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import kotlin.system.exitProcess
import juego.pls.com.*

abstract class Pantalla: Screen {
    companion object {
        fun crearBoton(texto: String, skin: Skin, etiqueta: Label, juego: Juego, xPosicion: Int, yPosicion: Int, salir: Boolean, pantallaSiguiente: Pantalla?): TextButton {
            val boton = TextButton(texto, skin)
            boton.setPosition(etiqueta.originX - xPosicion, etiqueta.originY + yPosicion)
            boton.width = 400f
            boton.height = 80f
            boton.addListener(object: InputListener() {
                override fun touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                    sonidoBoton.play(volumenBotones)
                    return true
                }
                override fun touchUp(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int) {
                    Juego.instancia.screen.dispose()
                    if (salir) {
                        sonidoBotonSalir.play(volumenMusica)
                        Thread.sleep(2 * 1000)
                        exitProcess(0)
                    }
                    Juego.instancia.screen = pantallaSiguiente
                }
            })
            return boton
        }
    }

    override fun render(delta: Float) {
        musica.play()
        if (!PantallaSonido.musicaEncendida) musica.stop()
        leerEntrada(delta)
        actualizar(delta)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT) // Limpia la pantalla
        sb.begin()
        dibujar(delta)
        sb.end()
        depurar(delta)
    }

    abstract fun leerEntrada(delta:Float)
    abstract fun actualizar(delta:Float)
    abstract fun dibujar(delta:Float)
    abstract fun depurar(delta:Float)
}