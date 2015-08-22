package pong.graphics

import org.lwjgl.opengl.GL11._
/**
 * Created by Razim on 8/20/2015.
 */
class Image(texId: Int, width: Int, height: Int) {

  val getWidth = width
  val getHeight = height

  var x = 0
  var y = 0

  def setPos(x1: Int, y1: Int): Unit ={
    x = x1
    y = y1
  }

  def render: Unit ={
    glPushMatrix()
    glBindTexture(GL_TEXTURE_2D, texId)
    glBegin(GL_QUADS)
      glTexCoord2f(0,0)
      glVertex2f(x, y)

      glTexCoord2f(0,1)
      glVertex2f(x, y + height)

      glTexCoord2f(1,1)
      glVertex2f(x + width, y + height)

      glTexCoord2f(1,0)
      glVertex2f(x + width, y)
    glEnd()
    glPopMatrix()
  }

}
