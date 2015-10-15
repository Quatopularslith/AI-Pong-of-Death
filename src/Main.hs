module Main where
import Graphics.Rendering.OpenGL.Raw
import Data.Bits ((.|.))
import qualified Graphics.UI.GLFW as GL
import System.Exit (exitWith, ExitCode(..))
import Control.Monad (forever)
import Paddle
import Render

main :: IO()
main = do
    True <- GL.init

    Just win <- GL.createWindow 640 480 "AI Of Death" Nothing Nothing
    GL.makeContextCurrent (Just win)
    GL.setWindowRefreshCallback win (Just render)
    GL.setFramebufferSizeCallback win (Just resizeWin)
    GL.setKeyCallback win (Just keyPressed)
    GL.setWindowCloseCallback win (Just shutdown)

    initGL win

    forever $ do
        GL.pollEvents
        render win
        GL.swapBuffers win

-------

initGL :: GL.Window -> IO()
initGL win = do
    glShadeModel gl_SMOOTH
    glDisable gl_DEPTH_TEST
    glEnable gl_BLEND
    glDisable gl_LIGHTING
    glBlendFunc gl_SRC_ALPHA gl_ONE_MINUS_SRC_ALPHA
    glClearColor 0 0 0 0
    glClearDepth 1

    (w, h) <- GL.getFramebufferSize win
    resizeWin win w h

-------

resizeWin :: GL.WindowSizeCallback
resizeWin win w 0 = resizeWin win w 1
resizeWin _ width height = do

    glMatrixMode gl_PROJECTION
    glLoadIdentity

    glOrtho 0 (fromIntegral width) (fromIntegral height) 0 1 (-1)

    glMatrixMode gl_MODELVIEW
    glLoadIdentity
    glFlush
-------

keyPressed :: GL.KeyCallback
keyPressed win GL.Key'Escape _ GL.KeyState'Pressed _ = shutdown win
keyPressed _ _ _ _ _ = return()

-------

shutdown :: GL.WindowCloseCallback
shutdown win = do
    GL.destroyWindow win
    GL.terminate
    _ <- exitWith ExitSuccess
    return()











