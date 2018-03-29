-module(file).

-export([facLoop/0]).

facLoop() ->
 receive
 {Pid, B} ->
 Pid ! {ok, fac(B)}
 end,
 facLoop().