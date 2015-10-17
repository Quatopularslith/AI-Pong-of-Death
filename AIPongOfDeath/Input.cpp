#include "Input.h"
#include "Render.h"
#include <glfw3.h>

int speed = 10;

Input::Input()
{

}

void Input::keyInput(GLFWwindow* window, int key, int scancode, int action, int mods){

	int upKey = glfwGetKey(window, GLFW_KEY_UP);
	int downKey = glfwGetKey(window, GLFW_KEY_DOWN);

	if (upKey == GLFW_PRESS && ply >= 0)
		ply -= speed;

	if (downKey == GLFW_PRESS && ply + lBox.height <= screenHeight)
		ply += speed;

}

Input::~Input()
{
}
