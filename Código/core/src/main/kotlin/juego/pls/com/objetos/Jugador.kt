package juego.pls.com.objetos

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Circle
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.Array
import juego.pls.com.mapas.Mapa
import juego.pls.com.sb

class Jugador(x: Float, y: Float): Sprite(quieto) {
    var tiempo = 0f
    private val anchoFrame = 64
    private val altoFrame = 64
    private val subir = defineAnimacion(arriba)
    private val bajar = defineAnimacion(abajo)
    private val delante = defineAnimacion(derecha)
    private val detras = defineAnimacion(izquierda)
    var ultimoPaso: TextureRegion = bajar.getKeyFrame(0f)

    var posicionAnterior = Vector2(0f, 0f)
    var posicionAnteriorCamara = Vector2(0f, 0f)
    private val direccion = Vector2(0f,0f)
    var velocidad = 300

    val mascara = Rectangle()
    val mascaraC = Circle()
    private val vector1 = Vector2(0f, 0f)
    private val vector2 = Vector2(0f, 0f)

    companion object {
        val arriba = Texture("Jugador/Arriba.png")
        val abajo = Texture("Jugador/Abajo.png")
        val derecha = Texture("Jugador/Derecha.png")
        val izquierda = Texture("Jugador/Izquierda.png")
        val quieto = Texture("Jugador/Parado.png")
    }

    init {
        setPosition(x,y)
        mascara.set(x, y, width - 22, height - 12)
        mascaraC.set(vector1, vector2)
    }

    fun leeTeclado(delta: Float) {
        tiempo += delta
        direccion.set(0f, 0f)
        if (!Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
            setRegion(ultimoPaso)
        }
        if ((Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) && x > 0) {
            setRegion(detras.getKeyFrame(tiempo, true))
            ultimoPaso = detras.getKeyFrame(0f)
            direccion.x--
        }
        if ((Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) && x < Mapa.anchoMapa - width) {
            setRegion(delante.getKeyFrame(tiempo, true))
            ultimoPaso = delante.getKeyFrame(0f)
            direccion.x++
        }
        if ((Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) && y < Mapa.altoMapa - height) {
            setRegion(subir.getKeyFrame(tiempo, true))
            ultimoPaso = subir.getKeyFrame(0f)
            direccion.y++
        }
        if ((Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) && y > 0) {
            setRegion(bajar.getKeyFrame(tiempo, true))
            ultimoPaso = bajar.getKeyFrame(0f)
            direccion.y--
        }
    }

    fun actualizar(delta: Float) {
        x += direccion.x * velocidad * delta
        y += direccion.y * velocidad * delta
        mascara.x = x + 12
        mascara.y = y + 5
        mascaraC.x = x + 32
        mascaraC.y = y + 32
    }

    fun dibujar() {
        draw(sb)
    }

    private fun defineAnimacion(textura: Texture): Animation<TextureRegion> {
        val duracionFrame = 0.1f
        val columnas = 3
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