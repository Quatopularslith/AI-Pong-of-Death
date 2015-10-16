#ifndef RENDER_H
#define RENDER_H
#include "Paddle.h"

class Render
{
    public:
        Render();
        virtual ~Render();
        void render();

		Paddle paddle = Paddle(50,200);

    protected:
    private:
};

#endif // RENDER_H
