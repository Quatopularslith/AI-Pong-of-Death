module Render (render) where

import Paddle
import Graphics.Rendering.OpenGL.Raw
import qualified Graphics.UI.GLFW as GL
import Data.Bits ((.|.))


render :: GL.Window -> IO()
render _ = do
    glClear $ fromIntegral $ gl_COLOR_BUFFER_BIT .|. gl_DEPTH_BUFFER_BIT
    paddle (-0.5,10) (20,20)
    glLoadIdentity
    glFlush




