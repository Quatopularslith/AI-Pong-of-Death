module Paddle (paddle) where

import Graphics.Rendering.OpenGL.Raw

paddle :: (GLfloat, GLfloat) -> (GLfloat, GLfloat) -> IO()
paddle (x, y) (w, h) = do
    glPushMatrix

    glBegin gl_QUADS
    glTranslatef x y 0
    glVertex2f (-1) 1
    glVertex2f 1 1
    glVertex2f 1 (-1)
    glVertex2f (-1) (-1)

    glEnd

    glPopMatrix
