package pong.physics

import pong.core.Main
import pong.graphics.{Render, Image}

import scala.util.Random

/**
 * Created by Razim on 8/21/2015.
 */
class BallPhys(img: Image) {

  var speed = 4

  var xVel = -1
  var yVel = 1

  val leftXBounds = img.x >= Render.left.x && img.x <=Render.left.x + Render.left.getWidth
  val rightXBounds = img.x >= Render.right.x && img.x <= Render.right.x + Render.right.getWidth

  val leftYBounds = img.y>=Render.left.y&&img.y<=Render.left.y+Render.left.getHeight
  val rightYBounds = img.y>=Render.right.y&&img.y<=Render.left.y+Render.right.getHeight

  def update: Unit ={
    if(img.x>=Main.WW - img.getWidth || img.x<=0 ||
      (img.x >= Render.left.x && img.x <=Render.left.x + Render.left.getWidth && img.y >= Render.left.y && img.y <= Render.left.y + Render.left.getHeight) ||
      (img.x >= Render.right.x && img.x <= Render.right.x + Render.right.getWidth && img.y >= Render.right.y && img.y <= Render.right.y + Render.right.getHeight)) xVel = -xVel

    if(img.y>=Main.WH - img.getHeight || img.y<=0 ||
      (img.x >= Render.left.x && img.x <=Render.left.x + Render.left.getWidth && img.y >= Render.left.y && img.y <= Render.left.y + Render.left.getHeight) ||
      (img.x >= Render.right.x && img.x <= Render.right.x - Render.right.getWidth && img.y >= Render.right.y && img.y <= Render.right.y + Render.right.getHeight)) yVel = -yVel
    img.setPos(img.x+(xVel*speed), img.y+(yVel*speed))
  }
}
