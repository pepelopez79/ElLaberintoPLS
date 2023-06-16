package juego.pls.com

import com.badlogic.gdx.Game
import juego.pls.com.pantallas.MenuPrincipal

class Juego: Game() {
    companion object{
        lateinit var instancia: Juego
        lateinit var ultimoMapaJugado: IntArray
    }

    override fun create() {
        ultimoMapaJugado = mapa1
        setScreen(MenuPrincipal(Juego()))
        instancia = this

        // Cursor
        mostrarCursor()

        // Música
        musica.volume = volumenMusica
        musica.isLooping = true
    }

    override fun dispose() {
        musica.dispose()
    }

    override fun resize(width: Int, height: Int) {
        vista.update(width, height,true)
    }
}