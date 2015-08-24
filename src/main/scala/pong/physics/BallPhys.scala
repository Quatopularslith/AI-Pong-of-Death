package pong.physics

import pong.core.Main
import pong.graphics.{Render, Image}

import scala.util.Random

/**
 * Created by Razim on 8/21/2015.
 */
class BallPhys(img: Image) {

  var speed = 8

  var xVel = 1
  var yVel = -1

  def update: Unit ={

    if(img.x >= Main.WW - img.getWidth || img.x <= 0) xVel = -xVel
    if(img.y >= Main.WH - img.getHeight || img.y <= 0) yVel = -yVel

    if(img.x >= Main.WW - img.getWidth) Main.leftScore += 1
    if(img.x <= 0) Main.rightScore += 1

    if(img.x >= Render.left.x && img.x <= Render.left.x + Render.left.getWidth){
      if(img.y + img.getHeight >= Render.left.y && img.y <= Render.left.y + Render.left.getHeight){
        xVel = -xVel
      }
    }

    if(img.x + img.getWidth >= Render.right.x && img.x <= Render.right.x + Render.right.getWidth){
      if(img.y + img.getHeight >= Render.right.y && img.y <= Render.right.y + Render.right.getHeight){
        xVel = -xVel
      }
    }

    img.setPos(img.x+(xVel*speed), img.y+(yVel*speed))
  }
}
