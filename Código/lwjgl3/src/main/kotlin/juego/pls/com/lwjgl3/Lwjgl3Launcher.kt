package juego.pls.com.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import juego.pls.com.ALTO
import juego.pls.com.ANCHO
import juego.pls.com.Juego

fun main() {
    Lwjgl3Application(Juego(), Lwjgl3ApplicationConfiguration().apply{
        setTitle("El Laberinto")
        useVsync(true)
        setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate)
        setForegroundFPS(60)
        setWindowedMode(ANCHO, ALTO)
        setWindowIcon("Logo128.png", "Logo64.png", "Logo32.png", "Logo16.png")
        setResizable(false)
    })
}