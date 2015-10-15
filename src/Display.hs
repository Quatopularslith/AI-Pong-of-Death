module Display (display) where

import Graphics.UI.GLUT
import Paddle

display :: DisplayCallback
display = do
  clear [ColorBuffer]
  paddle (10, 20)
  flush
