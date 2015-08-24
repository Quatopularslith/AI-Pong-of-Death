package pong.input

import org.lwjgl.input.Keyboard
import pong.core.Main
import pong.graphics.Render

/**
 * Created by Razim on 8/23/2015.
 */
object KeyboardInput {
  def movLeft: Unit ={
    val speed = 4
    if(Keyboard.isKeyDown(Keyboard.KEY_UP) && Render.left.y >= 0) Render.left.setPos(Render.left.x, Render.left.y - speed)
    if(Keyboard.isKeyDown(Keyboard.KEY_DOWN) && Render.left.y + Render.left.getHeight <= Main.WH) Render.left.setPos(Render.left.x, Render.left.y + speed)
  }
}

object MouseInput{

}