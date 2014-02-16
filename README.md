Version 0.3 (Tic-Tac-Toe)
=========================

**TODO** list:

* Changing design of `Table`: instead of using
`Move`, we're going to use a new class `Position`
-- hence `Table` should be made of `Position`'s instead
of `Sign`'s.
* It should be clearer that `Move` is `Player`'s
intention.
* We should prevent `Player`'s to choose a `Position`
already set, possibly giving it the chance of choosing
another `Position`.
* If `Player` `p1` wins choosing one position, `p2`
should **not** have its chance and game should
terminate.
* Providing a CPU-like player, hence method `tic()`
should be rethought -- means that we should provide
`tic` with parameters and without param's both.
* Providing both `StupidCPU` and `SmartCPU`, such
that `StupidCPU` can be used for testing. It will
make random choices.
* Making the `toString()` method easier to read
* Taking care of exceptions
* If the match ends with no winner, program outputs
there's a winner in any case. Wrong.
* ***Wrong input format can't make the program crash!***

*Note*:
* `Sign` < `Position` < `Table` < `Engine`

At first `Engine` checks if there's enough space to
play (i.e. if `Table` is not full). If so ...
* `Player` must only provide a `Movement`, telling
`Engine` where he wants to put his sign. Then `Engine`
must:
    * Check if `Position` is already *signed*. If so
`Engine` ask again to provide another (and **different**)
`Movement`. Once `Player` provides a free `Position`,
`Engine` checks if he has won. If not, ask the other
`Player` the same as it has done with the first.
    * Everytime he has ask user to provide a movement
`Engine` must print the current state of `Table`.

* `Movement` < `Player` < `Engine`
