package pong.graphics

import java.awt.image.BufferedImage
import java.nio.ByteBuffer
import javax.imageio.ImageIO

import org.lwjgl.BufferUtils
import org.lwjgl.opengl.GL12
import org.newdawn.slick.opengl.{Texture, TextureLoader}
import org.newdawn.slick.util.ResourceLoader

import org.lwjgl.opengl.GL11._

import scala.collection.mutable.HashMap

/**
 * Created by Razim on 8/21/2015.
 */
class ImageCache {

  object ImageCache {
    val imageCache = HashMap.empty[String, BufferedImage]
    val textureCache = HashMap.empty[String, Texture]
    val texIntCache = HashMap.empty[BufferedImage, Int]

    def loadImage(path: String) = {
      imageCache.getOrElseUpdate(path, ImageIO.read(ResourceLoader.getResourceAsStream(path)))
    }

    def loadTexture(path: String, fileType: String) = { //fileType = "PNG" || "JPG" || etc
      textureCache.getOrElseUpdate(path, TextureLoader.getTexture(fileType, ResourceLoader.getResourceAsStream(path)))
    }

    def loadTextureFromBuffImg(img: BufferedImage): Int ={
      def genTexInt(image: BufferedImage): Int ={
        val BYTES_PER_PIXEL = 4
        val pixels: Array[Int] = new Array(image.getWidth * image.getHeight)
        image.getRGB(0, 0, image.getWidth, image.getHeight, pixels, 0, image.getWidth)
        val buffer: ByteBuffer = BufferUtils.createByteBuffer(image.getWidth * image.getHeight * BYTES_PER_PIXEL)

        pixels.foreach{pixel =>
          buffer.put(((pixel >> 16) & 0xFF).toByte)
          buffer.put(((pixel >> 8) & 0xFF).toByte)
          buffer.put((pixel & 0xFF).toByte)
          buffer.put(((pixel >> 24) & 0xFF).toByte)
        }


        buffer.flip()


        val textureId = glGenTextures()
        glBindTexture(GL_TEXTURE_2D, textureId)
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE)
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE)

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR)
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR)

        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, image.getWidth, image.getHeight, 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer)
        textureId
      }

      texIntCache.getOrElseUpdate(img, genTexInt(img))
    }

  }

}
