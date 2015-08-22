package pong.core


import org.lwjgl.opengl.{DisplayMode, Display}
import org.lwjgl.opengl.GL11._
import pong.graphics.Render
import pong.physics.BallPhys

/**
 * Created by Razim on 8/20/2015.
 */
object Main {

  val SW: Int = 1280
  val SH: Int = 720

  lazy val WW = Display.getWidth
  lazy val WH = Display.getHeight
  lazy val ballPhys = new BallPhys(Render.ball)

  def main (args: Array[String]) {

    init

    Render.left.setPos(10,10)
    Render.right.setPos(Main.WW - Render.right.getWidth -  10, Main.WH - Render.right.getHeight - 10)
    Render.ball.setPos(300,300)


    while(!Display.isCloseRequested){
      render
      update

      Display.update()
      Display.sync(60)
    }

    Display.destroy()
    System.exit(1)

  }

  def init: Unit ={

    Display.setTitle("Ai Pong of Death")
    Display.setDisplayMode(new DisplayMode(SW,SH))
    Display.setVSyncEnabled(true)
    Display.create()

    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()
    glOrtho(0, WW, WH, 0, 1, -1)
    glMatrixMode(GL_MODELVIEW)
    glEnable(GL_TEXTURE_2D)
    glShadeModel(GL_SMOOTH)
    glDisable(GL_DEPTH_TEST)
    glDisable(GL_LIGHTING)
    glEnable(GL_BLEND)

    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA)
    glClearColor(0f,0f,0f,0f)
    glClearDepth(1)

  }

  def render: Unit ={
    glClear(GL_COLOR_BUFFER_BIT)
    Render.renderLeft
    Render.renderRight
    Render.renderBall
  }

  def update: Unit ={
    ballPhys.update
  }

}
