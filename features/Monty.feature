Feature: Monty Hall Game
  In order to win a Car
  As a Player
  I want to be able to play the Monty Hall Game

  Background:
      Given there exists a Game
        And there exists a Player

  Scenario Outline: Player should be able to pick a door
     Given the Doors are "Goat, Goat, Car"
     When the Player picks Door no <doorNo>
     Then the Player should have picked a <door>

     Examples:
      |doorNo |door |
      |1      |Goat |
      |2      |Goat |
      |3      |Car  |

  Scenario: Monty should display a Goat
       When the Player picks a Door
       Then Monty should display a Goat

  Scenario Outline: Monty should not pick the Player Door
       When the Player picks Door no <doorNo>
       Then Monty should pick one of <other doors>

       Examples:
        |doorNo |other doors|
        |1      |2,3        |
        |2      |1,3        |
        |3      |1,2        |

  Scenario Outline: The Player should win if he picks a Car
     Given the Doors are "Goat, Goat, Car"
     When the Player picks Door no <doorNo>
     Then the Player should have <won or lost>

     Examples:
      |doorNo |won or lost |
      |1      |Lost        |
      |2      |Lost        |
      |3      |Won         |

  Scenario Outline: The Player should be able to switch door
     Given the Doors are "Goat, Goat, Car"
     When the Player picks Door no <doorNo>
      And the Player switches Door
     Then the Player should have <won or lost>

     Examples:
      |doorNo |won or lost |
      |1      |Won         |
      |2      |Won         |
      |3      |Lost        |
