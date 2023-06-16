package juego.pls.com.pantallas

import Moneda
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.g2d.BitmapFont
import juego.pls.com.mapas.*
import juego.pls.com.*

class PantallaAccion(game: Juego, var mapaEnteros: IntArray): Pantalla() {
    private var mapa = Mapa(game, mapaEnteros)
    private val fuente = BitmapFont()
    var monedaContador = Moneda(0f, ALTO - 42f)

    companion object {
        var contadorMonedas = 0
    }

    override fun show() {
        ocultarCursor()
        contadorMonedas = 0
        musica.volume = 0.1f
        mapa.show()
        camaraAccion.setToOrtho(false, mapa.salida.x, mapa.salida.y)
        camaraHUD.setToOrtho(false, ANCHO.toFloat(), ALTO.toFloat())
    }

    override fun leerEntrada(delta: Float) {
        mapa.leerEntrada(delta)
        if ((Gdx.input.isKeyPressed(Input.Keys.ESCAPE))) {
            Juego.instancia.screen.dispose()
            Juego.instancia.screen = MenuPrincipal(game = Juego())
        }
        if ((Gdx.input.isKeyPressed(Input.Keys.SPACE))){
            camaraAccion.zoom = 2f
        } else {
            camaraAccion.zoom = 1f
        }
        if ((Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A))) {
            camaraAccion.translate(- 5f, 0f)
        }
        if ((Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D))) {
            camaraAccion.translate(5f, 0f)
        }
        if ((Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W))) {
            camaraAccion.translate(0f, 5f)
        }
        if ((Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S))) {
            camaraAccion.translate(0f, - 5f)
        }
        camaraAccion.update()
    }

    override fun actualizar(delta: Float) {
        sb.projectionMatrix = camaraAccion.combined
        mapa.actualizar(delta)
        sb.projectionMatrix = camaraHUD.combined
        camaraAccion.update()
    }

    override fun dibujar(delta: Float) {
        sb.projectionMatrix = camaraAccion.combined
        mapa.dibujar(delta)
        sb.projectionMatrix = camaraHUD.combined
        monedaContador.dibujar()
        fuente.draw(sb, "$contadorMonedas / 3", 40f, ALTO - 12f)
    }

    override fun depurar(delta: Float) {
        mapa.depurar(delta)
    }

    override fun resize(width: Int, height: Int) {
        camaraAccion.position.set(mapa.salida.x, mapa.salida.y, 0f)
        vista.update(width, height, false)
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun hide() {
        mostrarCursor()
        musica.volume = 0.5f
        camaraAccion.setToOrtho(false, ANCHO.toFloat(), ALTO.toFloat())
    }

    override fun dispose() {
        fuente.dispose()
        mapa.dispose()
    }
}
