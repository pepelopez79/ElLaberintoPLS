import com.badlogic.gdx.Files
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Circle
import com.badlogic.gdx.math.Vector2
import juego.pls.com.volumenMusica
import juego.pls.com.sb

class Moneda(x: Float, y: Float): Sprite(monedaTextura) {
    private var sonidoMoneda: Sound = Gdx.audio.newSound(Gdx.files.getFileHandle("Sonidos/Moneda.mp3", Files.FileType.Internal))
    val mascara = Circle()
    private val vector1 = Vector2(0f, 0f)
    private val vector2 = Vector2(19f, 18f)

    companion object {
        private val monedaTextura = Texture("Objetos/Moneda.png")
    }

    init {
        setPosition(x, y)
        mascara.set(vector1, vector2)
    }

    fun actualizar(delta: Float) {
        mascara.x = x + 16
        mascara.y = y + 16
    }

    fun dibujar() {
        draw(sb)
    }

    fun cogerMoneda() {
        sonidoMoneda.play(volumenMusica)
        this.setPosition(10000f, 10000f)
    }
}