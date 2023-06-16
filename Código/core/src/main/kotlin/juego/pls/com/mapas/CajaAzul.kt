package juego.pls.com.mapas

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Rectangle
import juego.pls.com.sb

class CajaAzul(x: Float, y: Float): Sprite(tipoCaja) {
    val mascara = Rectangle()

    companion object {
        private val tipoCaja = Texture("Mapas/CajaAzul.png")
    }

    init {
        setPosition(x, y)
        mascara.set(x, y, width, height)
    }

    fun actualizar(delta: Float) {
        mascara.x = x
        mascara.y = y
    }

    fun dibujar() {
        draw(sb)
    }
}