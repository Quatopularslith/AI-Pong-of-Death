#ifndef INPUT_H
#define INPUT_H
#include <glfw3.h>

class Input
{
public:

	Input();

	void keyInput(GLFWwindow*, int, int, int, int);

	~Input();
};

#endif