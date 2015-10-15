module Main where
import Graphics.UI.GLUT
import Graphics.Rendering.OpenGL.Raw
import Bindings

main :: IO()
main = do
  (_progName, _args) <- getArgsAndInitialize
  _window <- createWindow "AI-Pong-Of-Death??"

  glMatrixMode gl_PROJECTION
  glLoadIdentity
  glMatrixMode gl_MODELVIEW
  glLoadIdentity

  displayCallback $= display
  reshapeCallback $= Just reshape
  keyboardMouseCallback $= Just keyboardMouse
  mainLoop

