package juego.pls.com.mapas

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Rectangle
import juego.pls.com.sb

class Meta(x: Float, y: Float): Sprite(lineaMeta) {
    val mascara = Rectangle()

    init {
        setPosition(x, y)
        mascara.set(x, y, width - 48, height)
    }

    companion object {
        private val lineaMeta = Texture("Mapas/Meta.png")
    }

    fun actualizar(delta: Float) {
        mascara.x = x + 48
        mascara.y = y
    }

    fun dibujar() {
        draw(sb)
    }
}