# BigData_Scala_03_HeroesGame
HeroesGame in scala


Lab
Write Heroes Game in text mode

class Character int power int hp void kick(Character c) boolean isAlive()

Hobbit

power=0 hp=3 kick(toCry())

Elf

hp=10 power=10 kick(kill everybody which weaker than him, otherwise decrease power of other hero by 1)

King

power=5-15 hp=5-15 kick(decrease number of hp of the enemy by random number which will be in range of his own power

knight

power=2-12 hp=2-12 kick(like king)

CharacterFactory

Character createCharacter() return random instance of any existing Character

GameManager

void fight(Character h1,Character h2) to provide fight between two heroes and explain via command line what happens during the fight, till both of heroes are alive
