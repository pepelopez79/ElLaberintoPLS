package juego.pls.com.mapas

import Llave
import Moneda
import com.badlogic.gdx.Files
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import juego.pls.com.pantallas.PantallaAccion.Companion.contadorMonedas
import juego.pls.com.pantallas.PantallaVictoria
import juego.pls.com.pantallas.PantallaGameOver
import juego.pls.com.objetos.PinchosArriba
import juego.pls.com.objetos.PinchosAbajo
import juego.pls.com.pantallas.Pantalla
import juego.pls.com.objetos.Jugador
import juego.pls.com.objetos.Sierra
import juego.pls.com.pantallas.PantallaCreditos
import juego.pls.com.*

class Mapa(game: Juego, private var mapaEnteros: IntArray): Pantalla() {
    // Assets Mapa
    private var sonidoVictoria: Sound = Gdx.audio.newSound(Gdx.files.getFileHandle("Sonidos/Victoria.mp3", Files.FileType.Internal))
    private var sonidoEliminado: Sound = Gdx.audio.newSound(Gdx.files.getFileHandle("Sonidos/Eliminado.mp3", Files.FileType.Internal))
    private val fondo1 = Texture("Mapas/Fondo1.png")
    private val fondo2 = Texture("Mapas/Fondo2.png")

    // Objetos Mapa
    lateinit var salida: Salida
    private lateinit var meta: Meta
    private lateinit var jugador: Jugador
    private lateinit var llave: Llave
    private lateinit var pinchosArriba: PinchosArriba
    private lateinit var pinchosAbajo: PinchosAbajo
    private lateinit var sierra1: Sierra
    private lateinit var sierra2: Sierra
    private lateinit var sierra3: Sierra
    private lateinit var sierra4: Sierra
    private lateinit var sierra5: Sierra
    private lateinit var moneda1: Moneda
    private lateinit var moneda2: Moneda
    private lateinit var moneda3: Moneda

    private var mapa = arrayOfNulls<Sprite>(numeroBloques)

    companion object {
        // Medidas Mapa
        var columnas = 15
        var filas = 21
        var anchoFrame = 64
        var altoFrame = 64
        var altoMapa = columnas * altoFrame
        var anchoMapa = filas * altoFrame
        var numeroBloques = 315
    }

    override fun show() {
        Juego.ultimoMapaJugado = mapaEnteros
        if (mapaEnteros.contentEquals(mapa1)) {
            fondo1.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat)
            mapa = rellenarCeldas()
            salida = Salida(0f, altoMapa - 4 * 64f)
            meta = Meta(anchoMapa - 64f, 7 * 64f)
            sierra1 = Sierra(64f * 7 + 16, 64f * 9 + 16, 64f * 7 + 16, 64f * 5 + 16, 270f)
            sierra2 = Sierra(64f * 9 + 16, 64f * 9 + 16, 64f * 9 + 16, 64f * 5 + 16, 290f)
            sierra3 = Sierra(64f * 11 + 16, 64f * 9 + 16, 64f * 11 + 16, 64f * 5 + 16, 310f)
            sierra4 = Sierra(64f * 13 + 16, 64f * 9 + 16, 64f * 13 + 16, 64f * 5 + 16, 330f)
            sierra5 = Sierra(anchoMapa - 2 * 64f + 8, 64f + 16, 64f + 8 + 16, 64f + 16, 500f)
            llave = Llave(anchoMapa - 2 * 64f + 20, 5 * 64f + 20)
            pinchosArriba = PinchosArriba(anchoMapa - 7 * 64f, 7 * 64f)
            pinchosAbajo = PinchosAbajo(anchoMapa - 7 * 64f, 7 * 64f)
            moneda1 = Moneda(64f + 8, 64f + 8)
            moneda2 = Moneda(anchoMapa - 2 * 64f + 8, altoMapa - 2 * 64f + 8)
            moneda3 = Moneda(17 * 64f + 6, 5 * 64f + 6)
            jugador = Jugador(salida.x, salida.y)
        }
        if (mapaEnteros.contentEquals(mapa2)) {
            fondo1.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat)
            mapa = rellenarCeldas()
            salida = Salida(0f, 6 * 64f)
            meta = Meta(anchoMapa - 64f, 11 * 64f)
            sierra1 = Sierra(anchoMapa - 6 * 64f + 16, altoMapa - 2 * 64f + 16, anchoMapa - 6 * 64f + 16, 64f + 16f, 700f)
            sierra2 = Sierra(anchoMapa - 7 * 64f + 16, altoMapa - 2 * 64f + 16, anchoMapa - 7 * 64f + 16, 64f + 16f, 400f)
            sierra3 = Sierra(anchoMapa - 8 * 64f + 16, altoMapa - 2 * 64f + 16, anchoMapa - 8 * 64f + 16, 64f + 16f, 600f)
            sierra4 = Sierra(anchoMapa - 3 * 64f + 16, altoMapa - 2 * 64f + 16, anchoMapa - 3 * 64f + 16, 64f + 16f, 400f)
            sierra5 = Sierra(6 * 64f + 16, 7 * 64f + 16, 3 * 64f + 8, 7 * 64f + 16, 600f)
            llave = Llave(4 * 64f - 16, 11 * 64f - 16)
            pinchosArriba = PinchosArriba(10 * 64f, 2 * 64f)
            pinchosAbajo = PinchosAbajo(10 * 64f, 2 * 64f)
            moneda1 = Moneda(6 * 64f + 8, 64f + 8)
            moneda2 = Moneda(anchoMapa - 2 * 64f + 8, 7 * 64f + 8)
            moneda3 = Moneda(anchoMapa - 2 * 64f + 8, 3 * 64f + 8)
            jugador = Jugador(salida.x, salida.y)
        }
        if (mapaEnteros.contentEquals(mapa3)) {
            fondo2.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat)
            mapa = rellenarCeldas()
            salida = Salida(0f, 7 * 64f)
            meta = Meta(anchoMapa - 64f, 9 * 64f)
            sierra1 = Sierra(64f + 16, 64f * 5 + 16, 64f + 16, 64f + 16, 250f)
            sierra2 = Sierra(anchoMapa - 4 * 64f + 8, 3 * 64f + 16, anchoMapa - 7 * 64f + 16, 3 * 64f + 16, 80f)
            sierra3 = Sierra(anchoMapa - 4 * 64f + 8, 5 * 64f + 16, anchoMapa - 7 * 64f + 16, 5 * 64f + 16, 80f)
            sierra4 = Sierra(anchoMapa - 4 * 64f + 8, 7 * 64f + 16, anchoMapa - 7 * 64f + 16, 7 * 64f + 16, 80f)
            sierra5 = Sierra(anchoMapa - 4 * 64f + 8, 9 * 64f + 16, anchoMapa - 7 * 64f + 16, 9 * 64f + 16, 80f)
            llave = Llave(2 * 64f + 20, 3 * 64f + 20)
            pinchosArriba = PinchosArriba(11 * 64f, 9 * 64f)
            pinchosAbajo = PinchosAbajo(11 * 64f, 9 * 64f)
            moneda1 = Moneda(64f + 8, altoMapa - 64f * 4 + 8)
            moneda2 = Moneda(10 * 64f + 8, 4 * 64f + 8)
            moneda3 = Moneda(12 * 64f + 8, altoMapa - 2 * 64f + 8)
            jugador = Jugador(salida.x, salida.y)
        }
    }

    override fun leerEntrada(delta: Float) {
        jugador.leeTeclado(delta)
    }

    override fun actualizar(delta: Float) {
        for (celda in mapa) {
            if (celda is CajaMarron) celda.actualizar(delta)
            if (celda is CajaRoja) celda.actualizar(delta)
            if (celda is CajaGris) celda.actualizar(delta)
            if (celda is CajaAzul) celda.actualizar(delta)
            if (celda is CajaVerde) celda.actualizar(delta)
        }
        choqueJugador(jugador)
        jugador.actualizar(delta)
        if (!Juego.ultimoMapaJugado.contentEquals(mapa3)) {
            sierra1.actualizar(delta, false)
            sierra2.actualizar(delta, false)
            sierra3.actualizar(delta, false)
            sierra4.actualizar(delta, false)
            sierra5.actualizar(delta, true)
        } else {
            sierra1.actualizar(delta, false)
            sierra2.actualizar(delta, true)
            sierra3.actualizar(delta, true)
            sierra4.actualizar(delta, true)
            sierra5.actualizar(delta, true)
        }
        llave.actualizar(delta)
        moneda1.actualizar(delta)
        moneda2.actualizar(delta)
        moneda3.actualizar(delta)
        meta.actualizar(delta)
        pinchosArriba.actualizar(delta)
        pinchosAbajo.actualizar(delta)
        if (jugador.mascara.overlaps(pinchosArriba.mascara) || jugador.mascara.overlaps(pinchosAbajo.mascara)) {
            sonidoEliminado.play(volumenMusica)
            Thread.sleep(4 * 1000)
            Juego.instancia.screen.dispose()
            Juego.instancia.screen = PantallaGameOver(game = Juego())
        }
        if (jugador.mascaraC.overlaps(sierra1.mascara) || jugador.mascaraC.overlaps(sierra2.mascara) || jugador.mascaraC.overlaps(sierra3.mascara) || jugador.mascaraC.overlaps(sierra4.mascara) || jugador.mascaraC.overlaps(sierra5.mascara)) {
            sonidoEliminado.play(volumenMusica)
            Thread.sleep(4 * 1000)
            Juego.instancia.screen.dispose()
            Juego.instancia.screen = PantallaGameOver(game = Juego())
        }
        if (jugador.mascara.overlaps(meta.mascara)) {
            sonidoVictoria.play(volumenMusica)
            Thread.sleep(6 * 1000)
            if (Juego.ultimoMapaJugado.contentEquals(mapa3)) {
                Juego.instancia.screen.dispose()
                Juego.instancia.screen = PantallaCreditos(game = Juego())
                Juego.ultimoMapaJugado = mapa1
            } else {
                Juego.instancia.screen.dispose()
                Juego.instancia.screen = PantallaVictoria(game = Juego(), contadorMonedas)
            }
        }
        if (jugador.mascara.overlaps(llave.mascara)) {
            llave.usarLlave()
            pinchosArriba.esconder(delta)
            pinchosAbajo.esconder(delta)
        }
        if (jugador.mascaraC.overlaps(moneda1.mascara)) {
            moneda1.cogerMoneda()
            contadorMonedas++
        }
        if (jugador.mascaraC.overlaps(moneda2.mascara)) {
            moneda2.cogerMoneda()
            contadorMonedas++
        }
        if (jugador.mascaraC.overlaps(moneda3.mascara)) {
            moneda3.cogerMoneda()
            contadorMonedas++
        }
    }

    override fun dibujar(delta: Float) {
        if (mapaEnteros.contentEquals(mapa1)) sb.draw(fondo1, 0f, 0f, 0, 0, anchoMapa, altoMapa)
        if (mapaEnteros.contentEquals(mapa2)) sb.draw(fondo1, 0f, 0f, 0, 0, anchoMapa, altoMapa)
        if (mapaEnteros.contentEquals(mapa3)) sb.draw(fondo2, 0f, 0f, 0, 0, anchoMapa, altoMapa)
        pinchosArriba.dibujar()
        pinchosAbajo.dibujar()
        for (celda in mapa) {
            if (celda is CajaMarron) celda.dibujar()
            if (celda is CajaRoja) celda.dibujar()
            if (celda is CajaGris) celda.dibujar()
            if (celda is CajaAzul) celda.dibujar()
            if (celda is CajaVerde) celda.dibujar()
        }
        salida.dibujar()
        meta.dibujar()
        sierra1.dibujar()
        sierra2.dibujar()
        sierra3.dibujar()
        sierra4.dibujar()
        sierra5.dibujar()
        jugador.dibujar()
        llave.dibujar()
        moneda1.dibujar()
        moneda2.dibujar()
        moneda3.dibujar()
    }

    override fun depurar(delta: Float) {
    }

    override fun resize(width: Int, height: Int) {
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun hide() {
    }

    override fun dispose() {
        fondo1.dispose()
        fondo2.dispose()
    }

    private fun choqueJugador(jugador: Jugador) {
        var bloqueo = false
        if (jugador.x < 0f) {
            camaraAccion.position.x = jugador.posicionAnteriorCamara.x
            camaraAccion.position.y = jugador.posicionAnteriorCamara.y
        }
        for (celda in mapa) {
            if (celda != null) {
                if (celda is CajaMarron) {
                    if (jugador.mascara.overlaps(celda.mascara)) {
                        jugador.x = jugador.posicionAnterior.x
                        jugador.y = jugador.posicionAnterior.y
                        camaraAccion.position.x = jugador.posicionAnteriorCamara.x
                        camaraAccion.position.y = jugador.posicionAnteriorCamara.y
                        bloqueo = true
                        break
                    }
                }
                if (celda is CajaRoja) {
                    if (jugador.mascara.overlaps(celda.mascara)) {
                        jugador.x = jugador.posicionAnterior.x
                        jugador.y = jugador.posicionAnterior.y
                        camaraAccion.position.x = jugador.posicionAnteriorCamara.x
                        camaraAccion.position.y = jugador.posicionAnteriorCamara.y
                        bloqueo = true
                        break
                    }
                }
                if (celda is CajaGris) {
                    if (jugador.mascara.overlaps(celda.mascara)) {
                        jugador.x = jugador.posicionAnterior.x
                        jugador.y = jugador.posicionAnterior.y
                        camaraAccion.position.x = jugador.posicionAnteriorCamara.x
                        camaraAccion.position.y = jugador.posicionAnteriorCamara.y
                        bloqueo = true
                        break
                    }
                }
                if (celda is CajaAzul) {
                    if (jugador.mascara.overlaps(celda.mascara)) {
                        jugador.x = jugador.posicionAnterior.x
                        jugador.y = jugador.posicionAnterior.y
                        camaraAccion.position.x = jugador.posicionAnteriorCamara.x
                        camaraAccion.position.y = jugador.posicionAnteriorCamara.y
                        bloqueo = true
                        break
                    }
                }
                if (celda is CajaVerde) {
                    if (jugador.mascara.overlaps(celda.mascara)) {
                        jugador.x = jugador.posicionAnterior.x
                        jugador.y = jugador.posicionAnterior.y
                        camaraAccion.position.x = jugador.posicionAnteriorCamara.x
                        camaraAccion.position.y = jugador.posicionAnteriorCamara.y
                        bloqueo = true
                        break
                    }
                }
            }
        }
        if (!bloqueo) {
            jugador.posicionAnterior.x = jugador.x
            jugador.posicionAnterior.y = jugador.y
            jugador.posicionAnteriorCamara.x = camaraAccion.position.x
            jugador.posicionAnteriorCamara.y = camaraAccion.position.y
        }
    }

    private fun rellenarCeldas(): Array<Sprite?> {
        var x = 0f
        var y = altoMapa - 64f
        val arrayBloques = arrayOfNulls<Sprite>(numeroBloques)
        var contador = 0
        for (celda in mapaEnteros) {
            if (celda == 7) {
                val caja = CajaMarron(x, y)
                arrayBloques[contador] = caja
            }
            if (celda == 8) {
                val caja = CajaRoja(x, y)
                arrayBloques[contador] = caja
            }
            if (celda == 9) {
                val caja = CajaAzul(x, y)
                arrayBloques[contador] = caja
            }
            if (celda == 10) {
                val caja = CajaVerde(x, y)
                arrayBloques[contador] = caja
            }
            if (celda == 11) {
                val caja = CajaGris(x, y)
                arrayBloques[contador] = caja
            }
            x += anchoFrame
            if (x >= anchoMapa) {
                x = 0f
                y -= altoFrame
            }
            if (y < 0f) {
                break
            }
            contador++
        }
        return arrayBloques
    }
}