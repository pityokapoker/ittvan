package org.leanpoker.player;

import com.google.gson.JsonParser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class PlayerServlet extends HttpServlet
{
    private PokerPlayer player;

    @Override public void init() throws ServletException
    {
        super.init();
        player = new PokerPlayer();
    }

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.getWriter().print("Java player is running");
    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        if (req.getParameter("action").equals("bet_request"))
        {
            String gameState = req.getParameter("game_state");

            resp.getWriter().print(Player.betRequest(new JsonParser().parse(gameState)));
        }

        if (req.getParameter("action").equals("showdown"))
        {
            String gameState = req.getParameter("game_state");

            Player.showdown(new JsonParser().parse(gameState));
        }

        if (req.getParameter("action").equals("version"))
        {
            resp.getWriter().print(Player.VERSION);
        }
    }
}
