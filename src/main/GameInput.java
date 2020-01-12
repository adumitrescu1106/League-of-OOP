package main;

import abilities.Ability;
import angels.Angel;
import champions.Champion;

import java.util.ArrayList;

public class GameInput {
    // DO NOT MODIFY
    private final ArrayList<ArrayList<Character>> arena;
    private final ArrayList<ArrayList<Character>> moves;
    private final ArrayList<Champion> players;
    private final ArrayList<ArrayList<Ability>> spells;
    private final ArrayList<ArrayList<Angel>> angels;
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
        angels = null;
    }

    public GameInput(final int rounds, final ArrayList<ArrayList<Character>> arena,
                     final ArrayList<Champion> players, final int nDimension,
                     final int mDimension, final ArrayList<ArrayList<Character>> moves,
                     final ArrayList<ArrayList<Ability>> spells,
                     final ArrayList<ArrayList<Angel>> angels) {
        this.arena = arena;
        this.players = players;
        this.moves = moves;
        this.rounds = rounds;
        this.nDimension = nDimension;
        this.mDimension = mDimension;
        this.spells = spells;
        this.angels = angels;
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

    public final ArrayList<ArrayList<Angel>> getAngels() {
        return angels;
    }

    public final boolean isValidInput() {
        boolean membersInstantiated = arena != null && players != null && moves != null
                && angels != null;
        boolean membersNotEmpty = nDimension > 0 && mDimension > 0 && rounds > 0;

        return membersInstantiated && membersNotEmpty;
    }
}
