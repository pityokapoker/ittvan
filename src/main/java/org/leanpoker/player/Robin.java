package org.leanpoker.player;

import com.google.gson.JsonElement;

import org.leanpoker.player.obj.GameSpace;
import org.leanpoker.player.obj.PlayerObj;
import org.leanpoker.player.parse.Convert;

public class Robin
{
    private static final int DEFAULT_BET = 50;
    private static final double MINIMAL_LEVEL = -0.05;
    private static final double LEVEL0_RISK = 0.1;
    private static final double LEVEL0_MULTPLIER = 1.1;
    private static final double LEVEL1_RISK = 0.2;
    private static final double LEVEL1_MULTPLIER = 1.2;
    private static final double LEVEL2_RISK = 0.4;
    private static final double LEVEL2_MULTPLIER = 1.4;
    private static final double LEVEL3_RISK = 0.6;
    private static final double LEVEL3_MULTPLIER = 1.6;

    public static int getBet(JsonElement request)
    {
        GameSpace gameSpace = Convert.getGameSpace(request);

        return 0;
    }

    public static int getBet(double winChance, GameSpace gameSpace)
    {
        int result = DEFAULT_BET;
        PlayerObj batman = Util.getBatman(gameSpace);
        double betRisk = (double) gameSpace.getMinimumRaise() / (double) gameSpace.getPot();
        double sub = winChance - betRisk;

        if (sub > MINIMAL_LEVEL)
        {
            result = gameSpace.getMinimumRaise();
            if (sub > LEVEL0_RISK)
            {
                result *= LEVEL0_MULTPLIER;
            }
            else if (sub > LEVEL1_RISK)
            {
                result *= LEVEL1_MULTPLIER;
            }
            else if (sub > LEVEL2_RISK)
            {
                result *= LEVEL2_MULTPLIER;
            }
            else if (sub > LEVEL3_RISK)
            {
                result *= LEVEL3_MULTPLIER;
            }

            //ha többet dobnánk be mint amennyink van
            if (result > batman.getStack())
            {
                result = batman.getStack();
            }
        }
        else
        {
            result = 0;
        }

        return result;
    }
}
