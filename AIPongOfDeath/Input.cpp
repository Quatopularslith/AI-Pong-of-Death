#include "Input.h"


Input::Input()
{
}

void Input::keyInput(GLFWwindow* window, int key, int scancode, int action, int mods){

	int upKey = glfwGetKey(window, GLFW_KEY_UP);
	int downKey = glfwGetKey(window, GLFW_KEY_DOWN);
	int leftKey = glfwGetKey(window, GLFW_KEY_LEFT);
	int rightKey = glfwGetKey(window, GLFW_KEY_RIGHT);

	if (upKey == GLFW_PRESS)
		false;

}

Input::~Input()
{
}
