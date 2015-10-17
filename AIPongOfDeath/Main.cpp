#include "Main.h"
#include "Render.h"
#include "Input.h"
#include <glfw3.h>

int screenWidth = 1280;
int screenHeight = 720;

void initGL(void){

    glShadeModel(GL_SMOOTH);
    glDisable(GL_DEPTH_TEST);
    glEnable(GL_BLEND);
    glDisable(GL_LIGHTING);
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
    glClearColor(0,0,0,0);
    glClearDepth(1);

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();

    glOrtho(0, screenWidth, screenHeight, 0, 1, -1);

    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();

    glFlush();

}


int main(void){

    GLFWwindow* window;
    if(!glfwInit())
        return -1;
	
    window = glfwCreateWindow(screenWidth, screenHeight, "AI-Pong-Of-Death", NULL, NULL);
    if (!window){
        glfwTerminate();
        return -1;
    }

    glfwMakeContextCurrent(window);

	Render render = Render();
	Input input = Input();
	glfwSetKeyCallback(window, input.keyInput);

    initGL();

    while(!glfwWindowShouldClose(window)){

		render.render();

        glfwSwapBuffers(window);
        glfwPollEvents();
    }

    glfwTerminate();
    return 0;
}
