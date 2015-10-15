module Paddle (paddle) where

import Graphics.UI.GLUT

vertex2f :: (GLfloat, GLfloat) -> IO()
vertex2f (x, y) = vertex $ Vertex2 x y

paddle :: (GLfloat, GLfloat) -> IO()
paddle (x, y) = renderPrimitive Points $ mapM_ vertex2f
    [(x, y), (x, y + 1), (x + 1, y + 1), (x + 1, y + 1)]
