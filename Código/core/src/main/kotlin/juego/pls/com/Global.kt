package juego.pls.com

import com.badlogic.gdx.Files
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.utils.viewport.FitViewport

// Dimensiones
const val ANCHO = 1024
const val ALTO =  640

// Menu
val fondoMenus = Texture("Menu/FondoMenus.png")

// Volumen de Juego
var volumenMusica = 0.5f
var volumenBotones = 1f

// Botones
var skinBoton = Skin(Gdx.files.internal("Menu/star-soldier-ui.json"))
var sonidoBoton: Sound = Gdx.audio.newSound( Gdx.files.getFileHandle("Sonidos/BotonMenu.ogg", Files.FileType.Internal))
var sonidoBotonSalir: Sound = Gdx.audio.newSound( Gdx.files.getFileHandle("Sonidos/Salir.mp3", Files.FileType.Internal))

// Música Menú
val musica: Music = Gdx.audio.newMusic(Gdx.files.getFileHandle("Sonidos/MenuPrincipal.mp3", Files.FileType.Internal))

// Cámara
var camaraAccion = OrthographicCamera()
var camaraHUD = OrthographicCamera()

// Viewport
val vista = FitViewport(ANCHO.toFloat(), ALTO.toFloat(), camaraAccion)

// SpriteBatch
val sb = SpriteBatch()

// Mapas
val mapa1 = intArrayOf(
    7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,
    7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,0,7,
    7,0,7,7,7,7,7,7,7,0,7,7,7,7,7,7,7,7,7,0,7,
    0,0,7,0,0,0,0,0,7,0,0,0,0,0,0,0,0,0,7,0,7,
    7,0,7,0,7,7,7,7,7,7,7,7,7,7,7,7,7,0,7,0,7,
    7,0,7,0,7,7,7,0,7,0,7,0,7,0,7,0,0,0,0,0,7,
    7,0,7,0,7,7,7,0,7,0,7,0,7,0,7,7,7,7,7,7,7,
    7,0,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    7,0,7,0,7,7,7,0,7,0,7,0,7,0,7,7,7,7,7,7,7,
    7,0,7,0,0,0,7,0,7,0,7,0,7,0,7,0,0,0,7,0,7,
    7,0,7,7,7,0,7,7,7,7,7,7,7,7,7,0,7,0,7,0,7,
    7,0,0,0,7,0,0,0,0,0,0,0,0,0,0,0,0,0,7,0,7,
    7,7,7,0,7,7,7,7,0,7,7,7,7,7,7,7,7,7,7,0,7,
    7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,
    7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7)

val mapa2 = intArrayOf(
    8,8,8,8,8,8,8,8,8,8,11,9,9,9,9,9,9,9,9,9,9,
    8,0,0,0,0,8,0,0,0,8,11,9,9,0,0,0,9,9,0,9,9,
    8,0,8,8,8,8,0,8,0,8,11,9,9,0,0,0,9,9,0,9,9,
    8,0,8,0,0,8,0,8,0,8,11,9,9,0,0,0,0,0,0,0,0,
    8,0,8,0,0,8,0,8,0,8,11,9,9,0,0,0,9,9,0,9,9,
    8,0,8,0,8,8,0,8,0,8,11,9,9,0,0,0,9,9,0,9,9,
    8,0,8,0,8,8,0,8,0,8,11,9,9,0,0,0,9,9,0,9,9,
    8,0,8,0,0,0,0,8,0,8,11,9,9,0,0,0,9,9,0,0,9,
    0,0,8,0,8,8,0,8,0,8,11,9,9,0,0,0,9,9,0,9,9,
    8,0,8,0,8,8,0,8,0,8,11,9,9,0,0,0,9,9,0,9,9,
    8,0,8,0,8,8,0,8,0,8,11,9,9,0,0,0,9,9,0,9,9,
    8,0,0,0,0,0,0,8,0,8,11,9,9,0,0,0,9,9,0,0,9,
    8,0,8,8,8,8,8,8,0,0,0,0,0,0,0,0,9,9,0,9,9,
    8,0,0,0,0,0,0,8,8,8,11,9,9,0,0,0,9,9,0,9,9,
    8,8,8,8,8,8,8,8,8,8,11,9,9,9,9,9,9,9,9,9,9)

val mapa3 = intArrayOf(
    10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,
    10,10,0,0,0,0,0,0,10,10,10,10,0,0,0,0,0,0,0,0,10,
    10,10,0,10,11,11,11,0,11,11,11,10,10,10,10,10,10,10,10,0,10,
    10,0,0,10,11,0,0,0,0,0,11,10,0,0,0,0,0,0,0,0,10,
    10,10,10,10,11,0,11,11,11,0,11,10,0,10,10,10,0,10,10,10,10,
    10,0,0,0,0,0,11,9,11,0,0,0,0,10,0,0,0,0,10,0,0,
    10,0,10,10,11,0,11,11,11,0,11,10,0,10,10,0,10,10,10,0,10,
    0,0,10,10,11,0,0,0,0,0,11,10,0,10,0,0,0,0,10,0,10,
    10,10,10,10,11,11,11,0,11,11,11,10,0,10,10,10,0,10,10,0,10,
    10,0,10,10,10,10,10,0,10,10,10,10,0,10,0,0,0,0,10,0,10,
    10,0,10,10,0,0,0,0,10,0,0,10,0,10,10,0,10,10,10,0,10,
    10,0,0,10,0,10,10,0,10,0,10,10,0,10,0,0,0,0,10,0,10,
    10,0,10,10,10,10,10,0,10,0,10,10,0,10,0,10,10,10,10,0,10,
    10,0,0,0,0,0,0,0,10,0,0,0,0,10,0,0,0,0,0,0,10,
    10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10)

// Cursor
fun mostrarCursor() {
    val texturaRaton = Pixmap(Gdx.files.internal("Menu/cursor.png"));
    val xPosicion = texturaRaton.width / 2 - 15
    val yPosicion = texturaRaton.height / 2 - 15
    val cursor = Gdx.graphics.newCursor(texturaRaton, xPosicion, yPosicion);
    Gdx.graphics.setCursor(cursor)
    texturaRaton.dispose()
}

fun ocultarCursor() {
    val texturaRaton = Pixmap(Gdx.files.internal("Menu/cursorVacio.png"));
    val xPosicion = texturaRaton.width / 2 - 15
    val yPosicion = texturaRaton.height / 2 - 15
    val cursor = Gdx.graphics.newCursor(texturaRaton, xPosicion, yPosicion);
    Gdx.graphics.setCursor(cursor)
    texturaRaton.dispose()
}
