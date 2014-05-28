package org.leanpoker.player;

import java.util.HashMap;

public class Batman
{
    public HashMap<Integer, Integer> getPotentialRankMap0()
    {
        HashMap<Integer, Integer> result = initRankMap();
        int[] resultArray = new int[117];

        for (int i = 0; i < 117; i++)
        {
            resultArray[i] = 0;
        }

        for (int p1 = 0; p1 < 46; p1++)
        {
            for (int p2 = p1 + 1; p2 < 47; p2++)
            {
                for (int p3 = p2 + 1; p3 < 48; p3++)
                {
                    for (int p4 = p3 + 1; p4 < 49; p4++)
                    {
                        for (int p5 = p4 + 1; p5 < 50; p5++)
                        {
                            for (int p6 = p5 + 1; p6 < 51; p6++)
                            {
                                for (int p7 = p6 + 1; p7 < 52; p7++)
                                {
                                    int rank = getRealRank(p1, p2, p3, p4, p5, p6, p7);

                                    resultArray[rank] = resultArray[rank] + 1;
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    public HashMap<Integer, Integer> getPotentialRankMap2(int mp1, int mp2)
    {
        HashMap<Integer, Integer> result = initRankMap();
        int page1 = mp1 / 4;
        int page2 = mp2 / 4;

        for (int p1 = 0; p1 < 7; p1++)
        {
            for (int p2 = p1; p2 < 8; p2++)
            {
                for (int p3 = p2; p3 < 9; p3++)
                {
                    for (int p4 = p3; p4 < 10; p4++)
                    {
                        for (int p5 = p4; p5 < 11; p5++)
                        {
                            for (int p6 = p5; p6 < 12; p6++)
                            {
                                for (int p7 = p6; p7 < 13; p7++)
                                {
                                    if ((page1 == p1) || (page1 == p2) || (page1 == p3) || (page1 == p4) || (page1 == p5) || (page1 == p6)
                                          || (page1 == p7))
                                    {
                                        boolean go = false;

                                        if (page1 == page2)
                                        {
                                            ;  //TODO
                                        }
                                        else
                                        {
                                            if ((page2 == p1) || (page2 == p2) || (page2 == p3) || (page2 == p4) || (page2 == p5)
                                                  || (page2 == p6) || (page2 == p7))
                                            {
                                                go = true;
                                            }
                                        }

                                        if (go)
                                        {
                                            Integer rank = getRealRank(p1 * 4, p2 * 4, p3 * 4, p4 * 4, p5 * 4, p6 * 4, p7 * 4);
                                            Integer count = result.get(rank) + 1;

                                            result.put(rank, count);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    /**
     * 0-116 kartya erteke
     * cards sorrendbe rendezett kell, hogy legyen
     * @param cards
     * @return
     */
    public int getRealRank(int... cards)
    {
        int highCardValue = -1;
        int pairValue = -1;
        boolean hasTwoPair = false;
        int threeOfKindValue = -1;
        int fourOfKindValue = -1;
        int straigthValue = -1;
        int flushValue = -1;
        int serialLength = 1;

        //azonos erteku lapok keresese
        for (int i = 1; i <= cards.length; i++)
        {
            int prevCardValue = cards[i - 1] / 4;

            if ((i < cards.length) && (prevCardValue == (cards[i] / 4)))
            {
                serialLength++;
            }
            else
            {  //serial vege
                switch (serialLength)
                {

                    case 1:
                        highCardValue = prevCardValue;
                        break;

                    case 2:
                        if (pairValue != -1)
                        {  //mar volt egy par, erteke lenyegtelen
                            hasTwoPair = true;
                        }

                        pairValue = prevCardValue;
                        break;

                    case 3:
                        threeOfKindValue = prevCardValue;
                        break;

                    case 4:
                        fourOfKindValue = prevCardValue;
                }

                serialLength = 1;
            }
        }

        //sor keresese
        serialLength = 1;
        for (int i = 1; i <= cards.length; i++)
        {
            int prevCardValue = cards[i - 1] / 4;

            if ((i < cards.length) && ((prevCardValue + 1) == (cards[i] / 4)))
            {
                serialLength++;
            }
            else
            {  //serial vege
                if (serialLength >= 5)
                {
                    straigthValue = prevCardValue;
                }

                serialLength = 1;
            }
        }

        //flush keresese
        for (int suit = 0; suit < 4; suit++)
        {
            serialLength = 0;
            int hc = -1;

            for (int i = 0; i < cards.length; i++)
            {
                if ((cards[i] % 4) == suit)
                {
                    serialLength++;
                    hc = cards[i] / 4;
                }
            }

            if (serialLength >= 5)
            {
                flushValue = hc;
            }
        }

        //straigh flush keresese
        if ((straigthValue != -1) && (flushValue != -1))
        {
            //TODO
        }

        //ertek visszaadasa
        int rank = 0;

        if (flushValue != -1)
        {
            rank = 104 + flushValue;
        }
        else
        {
            if (fourOfKindValue != -1)
            {
                rank = 91 + fourOfKindValue;
            }
            else
            {
                if ((threeOfKindValue != -1) && (pairValue != -1))
                {
                    rank = 78 + threeOfKindValue;
                }
                else
                {
                    if (flushValue != -1)
                    {
                        rank = 65 + flushValue;
                    }
                    else
                    {
                        if (straigthValue != -1)
                        {
                            rank = 52 + straigthValue;
                        }
                        else
                        {
                            if (threeOfKindValue != -1)
                            {
                                rank = 39 + threeOfKindValue;
                            }
                            else
                            {
                                if (hasTwoPair)
                                {
                                    rank = 26 + pairValue;
                                }
                                else
                                {
                                    if (pairValue != -1)
                                    {
                                        rank = 13 + pairValue;
                                    }
                                    else
                                    {
                                        rank = highCardValue;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return rank;
    }

    public int getWinRate(int[] homeCards, int[] commonCards)
    {
        int[] allCards = new int[homeCards.length + commonCards.length];

        System.arraycopy(homeCards, 0, allCards, 0, homeCards.length);
        System.arraycopy(commonCards, 0, allCards, homeCards.length, commonCards.length);
        Util util = new Util();
        int[] sortedAllCards = util.sort(allCards);
        int homeRank = getRealRank(sortedAllCards);
        int commonRank = getRealRank(commonCards);

        return homeRank - commonRank;
    }

    private HashMap<Integer, Integer> initRankMap()
    {
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();

        for (Integer i = 0; i <= 116; i++)
        {
            result.put(i, 0);
        }

        return result;
    }
}
