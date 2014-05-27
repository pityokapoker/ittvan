	    ____  ______  _____    __       ____  ___________  ______  __ __ ___       
	   / __ \/ __ \ \/ /   |  / /      / __ \/  _/_  __\ \/ / __ \/ //_//   |      
	  / /_/ / / / /\  / /| | / /      / /_/ // /  / /   \  / / / / ,<  / /| |      
	 / _, _/ /_/ / / / ___ |/ /___   / _____/ /  / /    / / /_/ / /| |/ ___ |      
	/_/ |_|\____/ /_/_/  |_/_____/  /_/   /___/ /_/    /_/\____/_/ |_/_/  |_|      
                                                                               

## Feladatok:

- project környezet kialakítása
    - git telepítés/közös repo kialakítás
- teszt környezet - nagyrész unit teszt, start.sh stop.sh kell tesztelni
- vezérlőág elkészítése
- json parse-olás
- adatok konvertálása saját típusba
    - card: 0-51 int érték, alsó két bit a szín információ, 2-6 bit érték.
    - 0-clubs2, 1-diamond2, 2-hearts2, 3-spades2
    - 4-clubs2, 5-diamond2, 6-hearts2, 7-spades2
    - ...
    - 48-clubsA, 49-diamondA, 50-heartsA, 51-spadesA
- lap valós értékének meghatározása getRealRank(int cards[])
    - 7 ismert lap értékének kiszámítása (0-116 egész érték visszaadása)
    - 0-12 kombináció nélküli lap (magas lap), a legerősebb kártya értéke (high card)
    - 13-25 egy pár, a 13 + a pár értéke (one pair)
    - 26-38 két pár, 26 + az erősebb pár értéke (two pair)
    - 39-51 drill, 39 + a drill értéke (three of kind)
    - 52-64 sor, 52 + a sor legerősebb lapjának értéke (straight)
    - 65-77 flös, 65 + a színflös legerősebb lapjának értéke (flush)
    - 78-90 full, 78 + a drill értéke (full house)
    - 91-103 póker, 91 + a póker értéke (four of kind)
    - 104-116 színsor, 104 + a flös legerősebb lapjának értéke (straight flush)
- lap potenciális értékének meghatározása getPotentialRankMap(int cards[])
    - lehetséges kombinációk iterálása (0,2,5,6 lap ismeretében)
    - áthívás valós érték számításra
    - valamennyi lehetséges kombináció értékét map-ba kell helyezni,key: rank (0-116 egész), value: darabszám, hány ilyen értékű kombináció jöhet ki
    - eredmény Map<Integer,Integer>
- nyerési esély megállapítása
    - saját lap potenciális érték meghatározása homeRankMap
    - ellenfél lap potenciális érték meghatározása (csak a közös lapok ismeretében, minden ellenfelet egyformának tekint) opponentRankMap
    - egy ellenféllel szemben a nyerési valószínűség P=nyerő esetek száma / összes eset száma.
    - TODO-B: ezt befolyásolni kellene tudni az ellenfél valószínűsíthető lapkombinációival
- cselekvés meghatározása
    - nyerési esély megállapítása
    - ideális cselekvés: bet/pot&lt;nyerési esély
    - dobás/tartás/emelés reakciókból választás
    - emelés mértékének meghatározása TODO
- elrettentés fokának megbecsülése (akkora tét, ami vízválasztó lehet)
- ellenfél lapjainak megtippelése
    - reakcióból visszakövetkeztetés a lapjaira
    - tökéletes kalkulációt feltételez az ellenféltől (tét/pot&lt;nyerési esély)
    - az átlaglappal (valamennyi kombináció átlaga) rendelkező viselkedéshez hasonlítja (hogy pl. a flopban feljövő ász pár ne)

>This is a gradle project that can be imported into any IDE. To run the player execute :

>`boot.sh`

>or

>`./gradlew tomcatRun`
