package juego.pls.com.objetos

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Circle
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.Array
import juego.pls.com.sb

class Sierra(xPosicion: Float, yPosicion: Float, xPosicionTope: Float, yPosicionTope: Float, var velocidad: Float): Sprite(sierraTextura) {
    private val anchoFrame = 32
    private val altoFrame = 32
    var tiempo = 0f
    val animacion = defineAnimacion(sierraTextura)
    var posicionInicialX = xPosicion
    var posicionInicialY = yPosicion
    var posicionTopeX = xPosicionTope
    var posicionTopeY = yPosicionTope
    var topey = false
    var topex = false

    val mascara = Circle()
    private val vector1 = Vector2(0f, 0f)
    private val vector2 = Vector2(24f, 24f)

    companion object {
        val sierraTextura = Texture("Objetos/Sierras.png")
    }

    init{
        setBounds(xPosicion, yPosicion, anchoFrame.toFloat(), altoFrame.toFloat())
        mascara.set(vector1, vector2)
    }

    fun actualizar(delta: Float, lateral: Boolean) {
        tiempo += 0.1f
        setRegion(animacion.getKeyFrame(tiempo, true))
        if (!lateral) reboteVertical(delta)
        else reboteHorizontal(delta)
        mascara.x = x + 16
        mascara.y = y + 16
    }

    fun dibujar(){
        draw(sb)
    }

    fun reboteVertical(delta: Float) {
        if (y >= posicionInicialY) {
            topey = false
        }
        if (y <= posicionTopeY) {
            topey = true
        }
        if (!topey) y -= velocidad * delta
        if (topey) y += velocidad * delta
    }

    fun reboteHorizontal(delta: Float) {
        if (x >= posicionInicialX) {
            topex = false
        }
        if (x <= posicionTopeX) {
            topex = true
        }
        if (!topex) x -= velocidad * delta
        if (topex) x += velocidad * delta
    }

    private fun defineAnimacion(textura: Texture): Animation<TextureRegion> {
        val duracionFrame = 0.1f
        val columnas = 4
        val filas = 1
        val provisional = TextureRegion.split(textura, anchoFrame, altoFrame)
        val fotogramas = Array<TextureRegion>()
        for (i in 0 until filas) {
            for (j in 0 until columnas) {
                fotogramas.add(provisional[i][j])
            }
        }
        return Animation<TextureRegion>(duracionFrame, fotogramas)
    }
}