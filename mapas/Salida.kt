package juego.pls.com.mapas

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Rectangle
import juego.pls.com.sb

class Salida(x: Float, y: Float): Sprite(lineaSalida) {
    val mascara = Rectangle()

    init {
        setPosition(x, y)
        mascara.set(x, y, width - 48, height)
    }

    companion object {
        private val lineaSalida = Texture("Mapas/Salida.png")
    }

    fun actualizar(delta: Float) {
        mascara.x = x
        mascara.y = y
    }

    fun dibujar() {
        draw(sb)
    }
}