-module(file).

-export([blobLoop/0]).

blobLoop() ->
 receive
 {Pid, B} ->
 Pid ! {ok, fac(B)}
 end,
 blobLoop().