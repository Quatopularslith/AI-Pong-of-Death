package pong.graphics

import java.awt.image.BufferedImage

import org.newdawn.slick.opengl.Texture
import pong.core.Main
import pong.graphics.ImageCache

/**
 * Created by Razim on 8/21/2015.
 */
object Render {

  val blockTex = ImageCache.loadTextureFromBuffImg(ImageCache.loadImage("block.png"))
  val left = new Image(blockTex, (Main.WH/14.4).toInt, (Main.WW*.2).toInt)
  val right = new Image(blockTex, (Main.WH/14.4).toInt, (Main.WW*.2).toInt)
  val ball = new Image(blockTex, 100,100)
  def renderLeft: Unit ={
    println("Test")
    left.setPos(10,10)
    left.render
  }

  def renderRight: Unit ={
    right.setPos(Main.WW - right.getWidth -  10, Main.WH - right.getHeight - 10)
    right.render
  }

  def renderBall: Unit ={
    ball.setPos(300,300)
    ball.render
  }

}
