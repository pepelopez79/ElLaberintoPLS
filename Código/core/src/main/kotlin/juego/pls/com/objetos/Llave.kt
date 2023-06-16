import com.badlogic.gdx.Files
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Rectangle
import juego.pls.com.volumenMusica
import juego.pls.com.sb

class Llave(x: Float, y: Float): Sprite(llaveTextura) {
    var sonidoLlave: Sound = Gdx.audio.newSound(Gdx.files.getFileHandle("Sonidos/Llave.mp3", Files.FileType.Internal))
    val mascara = Rectangle()

    init {
        setPosition(x, y)
        mascara.set(x, y, width - 9, height - 3)
    }

    companion object {
        private val llaveTextura = Texture("Objetos/Llave.png")
    }

    fun usarLlave() {
        sonidoLlave.play(volumenMusica)
        this.setPosition(10000f, 10000f)
    }

    fun actualizar(delta: Float) {
        mascara.x = x + 5
        mascara.y = y + 2
    }

    fun dibujar() {
        draw(sb)
    }
}