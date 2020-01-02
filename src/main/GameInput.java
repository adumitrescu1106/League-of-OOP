package main;

import abilities.Ability;
import champions.Champion;

import java.util.ArrayList;

public class GameInput {
    // DO NOT MODIFY
    private final ArrayList<ArrayList<Character>> arena;
    private final ArrayList<ArrayList<Character>> moves;
    private final ArrayList<Champion> players;
    private final ArrayList<ArrayList<Ability>> spells;
    private int rounds;
    private int nDimension;
    private int mDimension;

    public GameInput() {
        this.spells = null;
        arena = null;
        players = null;
        moves = null;
        rounds = -1;
        nDimension = -1;
        mDimension = -1;
    }

    public GameInput(final int rounds, final ArrayList<ArrayList<Character>> arena,
                     final ArrayList<Champion> players, final int nDimension,
                     final int mDimension, final ArrayList<ArrayList<Character>> moves,
                     final ArrayList<ArrayList<Ability>> spells) {
        this.arena = arena;
        this.players = players;
        this.moves = moves;
        this.rounds = rounds;
        this.nDimension = nDimension;
        this.mDimension = mDimension;
        this.spells = spells;
    }

    public final ArrayList<ArrayList<Character>> getArena() {
        return arena;
    }

    public final ArrayList<Champion> getPlayers() {
        return players;
    }

    public final ArrayList<ArrayList<Ability>> getSpells() {
        return spells;
    }

    public final int getRounds() {
        return rounds;
    }

    public final int getnDimension() {
        return nDimension;
    }

    public final int getmDimension() {
        return mDimension;
    }

    public final ArrayList<ArrayList<Character>> getMoves() {
        return moves;
    }

    public final boolean isValidInput() {
        boolean membersInstantiated = arena != null && players != null && moves != null;
        boolean membersNotEmpty = nDimension > 0 && mDimension > 0 && rounds > 0;

        return membersInstantiated && membersNotEmpty;
    }
}
