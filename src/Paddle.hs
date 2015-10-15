module Paddle (paddle) where

import Graphics.Rendering.OpenGL.Raw

paddle :: (GLfloat, GLfloat) -> (GLfloat, GLfloat) -> IO()
paddle (x, y) (w, h) = do
    glPushMatrix

    glBegin gl_QUADS
    glVertex2f x y
    glVertex2f x (y+h)
    glVertex2f (x+w) (y+h)
    glVertex2f (x+w) y

    glEnd

    glPopMatrix
