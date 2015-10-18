#ifndef INPUT_H
#define INPUT_H

#include <GLFW/glfw3.h>

class Input {
public:

    Input();

    static void keyInput(GLFWwindow *, int, int, int, int);

    ~Input();
};

#endif