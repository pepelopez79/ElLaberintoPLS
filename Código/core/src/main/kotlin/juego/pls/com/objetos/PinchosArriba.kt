package juego.pls.com.objetos

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Rectangle
import juego.pls.com.sb

class PinchosArriba(x: Float, y: Float): Sprite(pinchosArribaTextura) {
    val mascara = Rectangle()
    private val velocidad = 30f
    var esconder = false
    var posicionTope = y + 64

    companion object {
        private val pinchosArribaTextura = Texture("Objetos/PinchosArriba.png")
    }

    init {
        setPosition(x, y)
        mascara.set(x, y, width - 30, height)
    }

    fun actualizar(delta: Float) {
        if (esconder && y <= posicionTope) y += velocidad * delta
        mascara.x = x + 20
        mascara.y = y
    }

    fun dibujar() {
        draw(sb)
    }

    fun esconder(delta: Float) {
        esconder = true
    }
}