module Bindings (display, reshape, keyboardMouse) where

import Graphics.UI.GLUT
import Display

reshape :: ReshapeCallback
reshape size = viewport $= (Position 0 0, size)

keyboardMouse :: KeyboardMouseCallback
keyboardMouse key state modifiers position = return()
