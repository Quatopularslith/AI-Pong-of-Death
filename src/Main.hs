module Main where
import Graphics.Rendering.OpenGL.Raw
import Data.Bits ((.|.))
import qualified Graphics.UI.GLFW as GL
import System.Exit (exitWith, ExitCode(..))
import Control.Monad (forever)
import Paddle

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


initGL :: GL.Window -> IO()
initGL win = do
    glShadeModel gl_SMOOTH
    glClearColor 0 0 0 0
    glClearDepth 1
    glEnable gl_DEPTH_TEST
    glDepthFunc gl_LEQUAL
    glHint gl_PERSPECTIVE_CORRECTION_HINT gl_NICEST
    (w, h) <- GL.getFramebufferSize win
    resizeWin win w h

resizeWin :: GL.WindowSizeCallback
resizeWin win w 0 = resizeWin win w 1
resizeWin _ width height = do
    glViewport 0 0 (fromIntegral width) (fromIntegral height)
    glMatrixMode gl_PROJECTION
    glLoadIdentity
    glMatrixMode gl_MODELVIEW
    glLoadIdentity
    glFlush

render :: GL.Window -> IO()
render _ = do
    glClear $ fromIntegral $ gl_COLOR_BUFFER_BIT .|. gl_DEPTH_BUFFER_BIT
    paddle (10,10) (20,20)
    glLoadIdentity
    glFlush

keyPressed :: GL.KeyCallback
keyPressed win GL.Key'Escape _ GL.KeyState'Pressed _ = shutdown win
keyPressed _ _ _ _ _ = return()

shutdown :: GL.WindowCloseCallback
shutdown win = do
    GL.destroyWindow win
    GL.terminate
    _ <- exitWith ExitSuccess
    return()











