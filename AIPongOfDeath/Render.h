#ifndef RENDER_H
#define RENDER_H
#include "Paddle.h"
#include "Main.h"

class Render
{
    public:
        Render();
        virtual ~Render();
        void render();

		Paddle paddle = Paddle(screenWidth * .2, screenHeight / 14.4);

    protected:
    private:
};

#endif // RENDER_H
