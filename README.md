Tic-Tac-Toe, in Java
====================

Writing a little engine that gives the user the
possibility of playing the classic *Tic-Tac-Toe*.
It's implemented in Java since I feel quite
confortable with that language and with OOP-concepts,
at the moment of this writing at least.

**Sample output**:

    Type the first player choice. Format's: ...,...
    1,1
    Type the second player choice. Format's: ...,...
    1,2
    Player@145e044, Last choice: (1,1)
    Player@86c347, Last choice: (1,2)
    (1,1) -> X
    (1,2) -> O
    (1,3) ->  

    (2,1) ->  
    (2,2) ->  
    (2,3) ->  

    (3,1) ->  
    (3,2) ->  
    (3,3) ->  

    # Other similar output here ...
    #...
    #...

    Type the first player choice. Format's: ...,...
    3,1
    Type the second player choice. Format's: ...,...
    2,2
    Player@145e044, Last choice: (3,1)
    Player@86c347, Last choice: (2,2)
    (1,1) -> X
    (1,2) -> O
    (1,3) -> O

    (2,1) -> X
    (2,2) -> O
    (2,3) ->  

    (3,1) -> X
    (3,2) ->  
    (3,3) ->  

    Winner is: Player@145e044, Last choice: (3,1)

You can simply launch it via `go`, a script
provided in this repository.
